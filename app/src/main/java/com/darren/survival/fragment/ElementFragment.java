package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Parameter;
import com.darren.survival.widget.ElementWidget;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElementFragment extends Fragment implements View.OnClickListener {
    private Survivor survivor;
    private View view;

    private ElementWidget txtCalorie;
    private ElementWidget txtTemperature;
    private ElementWidget txtWater;
    private ElementWidget txtVigor;
    private ElementWidget txtTime;

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

        txtCalorie = (ElementWidget)view.findViewById(R.id.txtCalorie);
        txtTemperature = (ElementWidget)view.findViewById(R.id.txtTemperature);
        txtWater = (ElementWidget)view.findViewById(R.id.txtWater);
        txtVigor = (ElementWidget)view.findViewById(R.id.txtVigor);
        txtTime = (ElementWidget)view.findViewById(R.id.txtTime);

        btnBackpack = (Button)view.findViewById(R.id.btnBackpack);

        txtCalorie.setMassage(Parameter.calorie);
        txtTemperature.setMassage(Parameter.temperature);
        txtWater.setMassage(Parameter.water);
        txtVigor.setMassage(Parameter.vigor);
        txtTime.setMassage(Parameter.time);

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
        txtCalorie.setMassage(Parameter.calorie);
        txtTemperature.setMassage(Parameter.temperature);
        txtWater.setMassage(Parameter.water);
        txtVigor.setMassage(Parameter.vigor);
        txtTime.setMassage(Parameter.time);
    }

    public interface ElementFOnClickListener {

        void elementFOnClick(View v);
    }

}
