package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;

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

    private View view = null;

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

        BtnOnClickAdapter onClickAdapter = new BtnOnClickAdapter();
        btnHunt.setOnClickListener(onClickAdapter);
        btnTour.setOnClickListener(onClickAdapter);
        btnFire.setOnClickListener(onClickAdapter);
        btnHurry.setOnClickListener(onClickAdapter);
        btnCamp.setOnClickListener(onClickAdapter);
        btnRest.setOnClickListener(onClickAdapter);
    }

    public interface MotionFOnClickListener {
        void MotionFOnClick(View v);
    }

    private class BtnOnClickAdapter implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btnHunt:
                    hunt();
                    break;
                case R.id.btnTour:
                    tour();
                    break;
                case R.id.btnFire:
                    fire(v);
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
            }
        }

        private void hunt() {
            survivor.getHunter().act();
        }

        private void tour() {
            survivor.getTourer().act();
        }

        private void fire(View v) {
            if(getActivity() instanceof  MotionFOnClickListener) {
                ((MotionFOnClickListener)getActivity()).MotionFOnClick(v);
            }
            survivor.getFirer().act();
        }

        private void hurry() {
            survivor.getHurrier().act();
        }

        private void camp() {
            survivor.getCamper().act();
        }

        private void rest() {
            survivor.getRestor().act();
        }
    }

}
