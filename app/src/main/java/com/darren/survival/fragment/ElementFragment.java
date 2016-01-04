package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.widget.elementWidget;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElementFragment extends Fragment implements View.OnClickListener {
    private Survivor survivor;
    private View view;

    private elementWidget txtCalorie;
    private elementWidget txtTemperature;
    private elementWidget txtWater;
    private elementWidget txtVigor;
    private elementWidget txtTime;
    private elementWidget txtScene;
    private elementWidget txtDistance;
    private elementWidget txtFireTime;
    private elementWidget txtCamped;

    private Button btnBackpack;

    public ElementFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_element, container, false);
        init();
        return view;
    }

    private void init() {
        survivor = Survivor.getInstance();

        txtCalorie = (elementWidget)view.findViewById(R.id.txtCalorie);
        txtTemperature = (elementWidget)view.findViewById(R.id.txtTemperature);
        txtWater = (elementWidget)view.findViewById(R.id.txtWater);
        txtVigor = (elementWidget)view.findViewById(R.id.txtVigor);
        txtTime = (elementWidget)view.findViewById(R.id.txtTime);
        txtScene = (elementWidget)view.findViewById(R.id.txtScene);
        txtDistance = (elementWidget)view.findViewById(R.id.txtDistance);
        txtFireTime = (elementWidget)view.findViewById(R.id.txtFireTime);
        txtCamped = (elementWidget)view.findViewById(R.id.txtCamped);

        btnBackpack = (Button)view.findViewById(R.id.btnBackpack);

        txtCalorie.setMassage(survivor.getCalorie());
        txtTemperature.setMassage(survivor.getTemperature());
        txtWater.setMassage(survivor.getWater());
        txtVigor.setMassage(survivor.getVigor());
        txtTime.setMassage(survivor.getTime());
        txtScene.setMassage(survivor.getScene());
        txtDistance.setMassage("Distance",survivor.getScene().getLength() + "");
        txtFireTime.setMassage("FireTime", survivor.getFirer().getFireTimeLeft() + "");
        txtCamped.setMassage("Camped", survivor.getCamper().isCAMPED() + "");

        btnBackpack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnBackpack:
                if(getActivity() instanceof ElementFOnClickListener) {
                    ((ElementFOnClickListener)getActivity()).elementFOnClick(v);
                }
        }
    }

    public void notifyDataSetChanged() {
        txtCalorie.setMassage(survivor.getCalorie());
        txtTemperature.setMassage(survivor.getTemperature());
        txtWater.setMassage(survivor.getWater());
        txtVigor.setMassage(survivor.getVigor());
        txtTime.setMassage(survivor.getTime());
        txtScene.setMassage(survivor.getScene());
        txtDistance.setMassage("Distance",survivor.getScene().getLength() + "");
        txtFireTime.setMassage("FireTime", survivor.getFirer().getFireTimeLeft() + "");
        txtCamped.setMassage("Camped", survivor.getCamper().isCAMPED() + "");
    }

    public interface ElementFOnClickListener {

        void elementFOnClick(View v);
    }

}
