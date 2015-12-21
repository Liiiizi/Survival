package com.darren.survival.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darren.survival.Adapter.BackpackAdapter;
import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Good;

import java.util.List;

public class GameActivity extends AppCompatActivity {
    private Survivor survivor = null;

    private LinearLayout mainLayout = null;
    private LinearLayout backpackLayout = null;
    private Button btnHurry = null;
    private Button btnFire = null;
    private Button btnHunt = null;
    private Button btnTour = null;
    private Button btnBackpack = null;
    private Button btnbpBack = null;
    private TextView txtScene = null;
    private TextView txtDistance = null;

    private List<Good> backpack = null;
    private GridView backpackView = null;
    private BackpackAdapter backpackAdater = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setScreen();
        init();
    }

    private void init() {
        survivor = Survivor.getInstance();
        survivor.init();
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        backpackLayout = (LinearLayout) findViewById(R.id.backpackLayout);
        btnHurry =(Button)findViewById(R.id.btnHurry);
        btnFire = (Button)findViewById(R.id.btnFire);
        btnHunt = (Button)findViewById(R.id.btnHunt);
        btnTour = (Button)findViewById(R.id.btnTour);
        btnBackpack = (Button)findViewById(R.id.btnBackpack);
        btnbpBack = (Button)findViewById(R.id.btnbpBack);
        txtScene = (TextView)findViewById(R.id.txtScene);
        txtDistance = (TextView)findViewById(R.id.txtDistance);
        setBtnOnClick();
        initBackpack();
        setTextView();
    }

    private void initBackpack() {
        backpack = survivor.getBackpack();
        backpackView = (GridView)findViewById(R.id.backpackView);
        backpackAdater = new BackpackAdapter(this, backpack);
        backpackView.setAdapter(backpackAdater);

    }

    private void setTextView() {
        System.out.println(survivor.getScene().toString());
        String[] strings = survivor.getScene().getClass().getName().split("\\.");
        txtScene.setText(strings[strings.length - 1]);
        txtDistance.setText(survivor.getScene().getLength() + "");
        backpackAdater.notifyDataSetChanged();
    }

    private void setBtnOnClick() {
        BtnOnClickAdapter onClickListener = new BtnOnClickAdapter();
        btnHurry.setOnClickListener(onClickListener);
        btnFire.setOnClickListener(onClickListener);
        btnHunt.setOnClickListener(onClickListener);
        btnTour.setOnClickListener(onClickListener);
        btnBackpack.setOnClickListener(onClickListener);
        btnbpBack.setOnClickListener(onClickListener);

    }

    private void setScreen() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void test() {
        for(;;) {
            survivor.getHurrier().hurry();
            setTextView();
        }
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

    private class BtnOnClickAdapter implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.btnHurry:
                   hurry();
                    break;
                case R.id.btnFire:
                    fire();
                    break;
                case R.id.btnHunt:
                    hunt();
                    break;
                case R.id.btnBackpack:
                    backpack();
                    break;
                case R.id.btnbpBack:
                    bpBack();
                    break;
                case R.id.btnTour:
                    Tour();
                    break;
            }
        }
        private void hurry() {
            survivor.getHurrier().hurry();
            setTextView();
        }

        private void fire() {
            survivor.getFirer().fire();
            setTextView();
        }

        private void hunt() {
            survivor.getHunter().hunt();
            setTextView();
        }

        private void Tour() {
            survivor.getTourer().tour();
            setTextView();
        }

        private void backpack() {
            mainLayout.setVisibility(LinearLayout.GONE);
            backpackLayout.setVisibility(LinearLayout.VISIBLE);
        }

        private void bpBack() {
            backpackLayout.setVisibility(LinearLayout.GONE);
            mainLayout.setVisibility(LinearLayout.VISIBLE);
        }

    }
}
