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
import android.widget.Toast;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.good.Rabbit;
import com.darren.survival.elements.good.Snake;
import com.darren.survival.elements.good.Squirrel;

public class GameActivity extends AppCompatActivity {
    private Survivor survivor = null;

    private Button btnHurry = null;
    private Button btnFire = null;
    private Button btnHunt = null;
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
        survivor = Survivor.getInstance();
        survivor.init();
        btnHurry =(Button)findViewById(R.id.btnHurry);
        btnFire = (Button)findViewById(R.id.btnFire);
        btnHunt = (Button)findViewById(R.id.btnHunt);
        txtScene = (TextView)findViewById(R.id.txtScene);
        txtDistance = (TextView)findViewById(R.id.txtDistance);
        setBtnOnClick();
        setTextView();
    }

    private void setTextView() {
        System.out.println(survivor.getScene().toString());
        String[] strings = survivor.getScene().getClass().getName().split("\\.");
        txtScene.setText(strings[strings.length - 1]);
        txtDistance.setText(survivor.getScene().getLength() + "");
    }

    private void setBtnOnClick() {
        BtnOnClickAdapter onClickListener = new BtnOnClickAdapter();
        btnHurry.setOnClickListener(onClickListener);
        btnFire.setOnClickListener(onClickListener);
        btnHunt.setOnClickListener(onClickListener);

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
    }
}
