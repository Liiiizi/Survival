package com.darren.survival.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.darren.survival.Adapter.ChooseListAdapter;
import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseFragment extends Fragment implements View.OnClickListener {
    public static final int CHOOSE_LIST_TYPE_KINDLINGS = 0;
    public static final int CHOOSE_LIST_TYPE_INFLAMMABLE = 1;
    public static final int CHOOSE_LIST_TYPE_FIREABLE = 2;

    View view;

    ListView chooseList;

    Button btnSure;

    ChooseListAdapter chooseListAdapter;

    private List<Good> choices;

    private Good choice = null;

    private int chooseListType;

    public ChooseFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose, container, false);
        init();
        return view;
    }

    private void init() {
        chooseList = (ListView)view.findViewById(R.id.chooseList);

        btnSure = (Button)view.findViewById(R.id.btnSure);

        btnSure.setOnClickListener(this);

        chooseListAdapter = new ChooseListAdapter(getActivity());

        chooseList.setAdapter(chooseListAdapter);

        chooseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0; i<parent.getChildCount(); i++) {
                    parent.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                view.setBackgroundColor(Color.DKGRAY);
                choice = (Good)chooseListAdapter.getItem(position);
            }
        });

        choices = new ArrayList<>();
    }

    public void setChooseList(List<Good> goods, int chooseListType, boolean isClearChoices) {
        if(isClearChoices) choices.clear();
        chooseListAdapter.setData(goods);
        this.chooseListType = chooseListType;
    }

    public List<Good> getChoices() {
        return choices;
    }

    public int getChooseListType() {
        return chooseListType;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSure:
                if(getActivity() instanceof ChooseFOnClickListener) {
                    if(choice == null) {
                        Toast.makeText(getActivity(), "请选择一项", Toast.LENGTH_LONG).show();
                        return;

                    }
                    choices.add(choice);
                    choice = null;
                    ((ChooseFOnClickListener)getActivity()).chooseFOnClick(v);
                }
                break;
        }
    }

    public interface ChooseFOnClickListener {
        void chooseFOnClick(View v);
    }

}
