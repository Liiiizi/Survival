
package com.darren.survival.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.survival.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakeFragment extends Fragment {
    View view;

    public MakeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_make, container, false);
        return view;
    }

}
