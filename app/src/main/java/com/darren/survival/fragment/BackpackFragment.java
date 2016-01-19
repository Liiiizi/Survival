package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackpackFragment extends Fragment implements View.OnClickListener {
    private View view;

    private Button btnSure;

    public BackpackFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_backpack, container, false);
        init();
        return view;
    }

    public void init() {
        btnSure = (Button)view.findViewById(R.id.btnSure);

        btnSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnSure:
                if(getActivity() instanceof BackpackFOnClicklistener) {
                    ((BackpackFOnClicklistener)getActivity()).backpackFOnClick(v);
                }
        }
    }

    public interface BackpackFOnClicklistener {
        void backpackFOnClick(View v);
    }
}
