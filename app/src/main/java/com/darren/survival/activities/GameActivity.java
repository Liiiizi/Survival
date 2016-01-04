package com.darren.survival.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.fragment.BackpackFragment;
import com.darren.survival.fragment.ChooseFragment;
import com.darren.survival.fragment.ElementFragment;
import com.darren.survival.fragment.MotionFragment;



public class GameActivity extends AppCompatActivity implements ElementFragment.ElementFOnClickListener, BackpackFragment.BackpackFOnClicklistener, MotionFragment.MotionFOnClickListener,
        ChooseFragment.ChooseFOnClickListener {
    private Survivor survivor = null;

    private FragmentManager fm;
    private FragmentTransaction transaction;

    private BackpackFragment bpFragment;
    private ChooseFragment chooseFragment;
    private ElementFragment elementFragment;
    private MotionFragment motionFragment;

    private Fragment leftFragment;
    private Fragment rightFragment;

    private ViewGroup mainlayout;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        survivor = Survivor.getInstance();
        survivor.init();//由于Survivor类于其他类获取实例的种种关系，必须在界面加载前进行初始化
        setContentView(R.layout.activity_game);
        init();
        setScreen();
    }

    private void init() {

        fm = getFragmentManager();

        bpFragment = new BackpackFragment();
        chooseFragment = new ChooseFragment();
        elementFragment = new ElementFragment();
        motionFragment = new MotionFragment();

        transaction = fm.beginTransaction();
        transaction.add(R.id.rightLayout, bpFragment);
        transaction.hide(bpFragment);
        transaction.add(R.id.rightLayout, chooseFragment);
        transaction.hide(chooseFragment);

        transaction.add(R.id.leftLayout, elementFragment);
        leftFragment = elementFragment;
        transaction.add(R.id.rightLayout, motionFragment);
        rightFragment = motionFragment;
        transaction.commit();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                notifyDataSetChanged();
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void setScreen() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void elementFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnBackpack:
                if (rightFragment != elementFragment) {
                    transaction = fm.beginTransaction();
                    transaction.hide(rightFragment);
                    transaction.show(bpFragment);
                    rightFragment = bpFragment;
                    transaction.commit();
                }
                break;
        }
    }

    @Override
    public void backpackFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSure:
                transaction = fm.beginTransaction();
                transaction.hide(rightFragment);
                transaction.show(motionFragment);
                rightFragment = motionFragment;
                transaction.commit();
                break;
        }
    }

    @Override
    public void MotionFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnFire:
                if(rightFragment != chooseFragment) replaceRightFragment(chooseFragment);
                if(survivor.getFirer().getFireTimeLeft() > 0) {
                    chooseFragment.setChooseList(survivor.getFirer().getFireables(), ChooseFragment.CHOOSE_LIST_TYPE_FIREABLE, true);
                } else {
                    chooseFragment.setChooseList(survivor.getFirer().getKINDLINGS(), ChooseFragment.CHOOSE_LIST_TYPE_KINDLINGS, true);
                    replaceRightFragment(chooseFragment);
                }

        }
    }

    @Override
    public void chooseFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSure:
                switch (chooseFragment.getChooseListType()) {
                    case ChooseFragment.CHOOSE_LIST_TYPE_KINDLINGS:
                        chooseFragment.setChooseList(survivor.getFirer().getINFLAMMABLE(), ChooseFragment.CHOOSE_LIST_TYPE_INFLAMMABLE, false);
                        break;
                    case ChooseFragment.CHOOSE_LIST_TYPE_INFLAMMABLE:
                        survivor.getFirer().startFire(chooseFragment.getChoices().get(0), chooseFragment.getChoices().get(1));
                        chooseFragment.setChooseList(survivor.getFirer().getFireables(), ChooseFragment.CHOOSE_LIST_TYPE_FIREABLE, true);
                        break;
                    case ChooseFragment.CHOOSE_LIST_TYPE_FIREABLE:
                        survivor.getFirer().fire(chooseFragment.getChoices().get(0));
                        onBackPressed();
                        break;
                }
        }
    }

    private void notifyDataSetChanged() {
        elementFragment.notifyDataSetChanged();
    }

    private void replaceLeftFragment(Fragment newLeftFragment) {
        transaction = fm.beginTransaction();
        transaction.hide(leftFragment);
        transaction.show(newLeftFragment);
        leftFragment = newLeftFragment;
        transaction.commit();
    }

    private void replaceRightFragment(Fragment newRightFragment) {
        transaction = fm.beginTransaction();
        transaction.hide(rightFragment);
        transaction.show(newRightFragment);
        rightFragment = newRightFragment;
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (rightFragment != motionFragment) {
            transaction = fm.beginTransaction();
            transaction.hide(rightFragment);
            transaction.show(motionFragment);
            rightFragment = motionFragment;
            transaction.commit();
        } else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
