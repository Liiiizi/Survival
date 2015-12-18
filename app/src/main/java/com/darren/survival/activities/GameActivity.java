package com.darren.survival.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.darren.survival.elements.Survival;
import com.darren.survival.R;

public class GameActivity extends AppCompatActivity {
    private Survival survival = null;

    private Button btnHurry = null;
    private Button btnFire = null;
    private TextView txtScene = null;
    private TextView txtDistance = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setScreen();
        init();
    }

    private void init() {
        survival = Survival.getInstance();
        btnHurry =(Button)findViewById(R.id.btnHurry);
        btnFire = (Button)findViewById(R.id.btnFire);
        txtScene = (TextView)findViewById(R.id.txtScene);
        txtDistance = (TextView)findViewById(R.id.txtDistance);
        setBtnOnClick();
        setTextView();
    }

    private void setTextView() {
        System.out.println(survival.getScene().toString());
        String[] strings = survival.getScene().getClass().getName().split("\\.");
        txtScene.setText(strings[strings.length - 1]);
        txtDistance.setText(survival.getScene().getLength() + "");
    }

    private void setBtnOnClick() {
        BtnOnClickAdapter onClickListener = new BtnOnClickAdapter();
        btnHurry.setOnClickListener(onClickListener);
        btnFire.setOnClickListener(onClickListener);

    }

    private void setScreen() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void test() {
        for(;;) {
            survival.getHurrier().hurry();
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
            }
        }
        private void hurry() {
            survival.getHurrier().hurry();
            setTextView();
        }

        private void fire() {
            survival.getFirer().fire();
            setTextView();
        }
    }
}
