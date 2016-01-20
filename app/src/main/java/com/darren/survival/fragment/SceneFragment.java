package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.widget.ElementWidget;

/**
 * A simple {@link Fragment} subclass.
 */
public class SceneFragment extends Fragment {
    private View view;

    private ElementWidget scene;
    private ElementWidget nextScene;
    private ElementWidget distance;

    private Survivor survivor = Survivor.getInstance();


    public SceneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scene, container, false);
        init();
        return view;
    }

    private void init() {
        scene = (ElementWidget)view.findViewById(R.id.scene);
        nextScene = (ElementWidget)view.findViewById(R.id.nextScene);
        distance = (ElementWidget)view.findViewById(R.id.distance);

        scene.setMassage("当前场景", survivor.getScene().getName());
        nextScene.setMassage("下一场景", survivor.getNextScene().getName());
        distance.setMassage("距离下一场景距离", String.valueOf(survivor.getScene().getLength()));
    }

    public void notifyDataSetChanged() {
        scene.setMassage("当前场景", survivor.getScene().getName());
        nextScene.setMassage("下一场景", survivor.getNextScene().getName());
        distance.setMassage("距离下一场景距离", String.valueOf(survivor.getScene().getLength()));
    }

}
