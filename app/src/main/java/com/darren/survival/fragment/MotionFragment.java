package com.darren.survival.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Motion;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotionFragment extends Fragment {
    private Survivor survivor = null;

    private Button btnHunt = null;
    private Button btnTour = null;
    private Button btnFire = null;
    private Button btnHurry = null;
    private Button btnCamp = null;
    private Button btnRest = null;
    private Button btnMake = null;

    private View view = null;

    private LocalBroadcastManager localBroadcastManager;

    public MotionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_motion, container, false);
        init();
        return view;
    }

    private void init() {
        survivor = Survivor.getInstance();

        btnHunt =(Button)view.findViewById(R.id.btnHunt);
        btnTour =(Button)view.findViewById(R.id.btnTour);
        btnFire =(Button)view.findViewById(R.id.btnFire);
        btnHurry =(Button)view.findViewById(R.id.btnHurry);
        btnCamp = (Button)view.findViewById(R.id.btnCamp);
        btnRest = (Button)view.findViewById(R.id.btnRest);
        btnMake = (Button)view.findViewById(R.id.btnMake);

        BtnOnClickAdapter onClickAdapter = new BtnOnClickAdapter();
        btnHunt.setOnClickListener(onClickAdapter);
        btnTour.setOnClickListener(onClickAdapter);
        btnFire.setOnClickListener(onClickAdapter);
        btnHurry.setOnClickListener(onClickAdapter);
        btnCamp.setOnClickListener(onClickAdapter);
        btnRest.setOnClickListener(onClickAdapter);
        btnMake.setOnClickListener(onClickAdapter);

        localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
    }

    public interface MotionFOnClickListener {
        void MotionFOnClick(View v);
    }

    private class BtnOnClickAdapter implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(getActivity() instanceof  MotionFOnClickListener) {
                ((MotionFOnClickListener)getActivity()).MotionFOnClick(v);
            }
            int id = v.getId();
            switch (id) {
                case R.id.btnHunt:
                    hunt();
                    break;
                case R.id.btnTour:
                    tour();
                    break;
                case R.id.btnFire:
                    fire();
                    break;
                case R.id.btnHurry:
                    hurry();
                    break;
                case R.id.btnCamp:
                    camp();
                    break;
                case R.id.btnRest:
                    rest();
                    break;
                case R.id.btnMake:
                    make();
                    break;
            }
            Intent intent = new Intent("com.darren.survival.REFRESH_ELEMENTS");
            localBroadcastManager.sendBroadcast(intent);
        }

        private void hunt() {
            Motion.hunter.act();
        }

        private void tour() {
            Motion.tourer.act();
        }

        private void fire() {
            Motion.firer.act();
        }

        private void hurry() {
            Motion.hurrier.act();
        }

        private void camp() {
            Motion.camper.act();
        }

        private void rest() {
            Motion.restor.act();
        }

        private void make() {
        }
    }

}
