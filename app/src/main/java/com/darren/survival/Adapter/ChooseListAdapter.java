package com.darren.survival.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

import java.util.List;

/**
 * Created by Darren on 2015/12/25 0025.
 */
public class ChooseListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    List<Good> choices = null;

    public ChooseListAdapter(Context context) {
        inflater =LayoutInflater.from(context);
        //choices = new ArrayList<>();
    }

    public ChooseListAdapter(Context context, List<Good> choices) {
        inflater =LayoutInflater.from(context);
        this.choices = choices;
    }

    public void setData(List<Good> choices) {
        this.choices = choices;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return choices == null? 0 : choices.size();
    }

    @Override
    public Object getItem(int position) {
        return choices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Good> getData() {
        return choices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtName = null;
        TextView txtCount = null;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.choose_list, null);
        }
        txtName = (TextView)convertView.findViewById(R.id.txtName);
        txtCount = (TextView)convertView.findViewById(R.id.txtCount);
        txtName.setText(choices.get(position).getName());
        txtCount.setText(choices.get(position).getCOUNT() + "");

        return convertView;
    }
}
