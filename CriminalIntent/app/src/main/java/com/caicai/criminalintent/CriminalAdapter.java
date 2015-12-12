package com.caicai.criminalintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Author : caicai
 * Time : 2015/12/10 11:21
 * Description:listfragmen的适配器
 */
public class CriminalAdapter extends ArrayAdapter {
    private Context context;
    private TextView itemTitle;
    private TextView itemDes;
    private CheckBox itemIsSolved;

    public CriminalAdapter(Context context, ArrayList<Criminal> mCriminals) {
        super(context, 0, mCriminals);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_crime, null);
        }

        Criminal criminal = (Criminal) getItem(position);

        itemTitle = (TextView) convertView.findViewById(R.id.item_list_title);
        itemDes = (TextView) convertView.findViewById(R.id.item_list_description);
        itemIsSolved = (CheckBox) convertView.findViewById(R.id.item_list_isSolved);

        itemTitle.setText(criminal.getmTitle());
        itemDes.setText(utils.getFormatDate(criminal.getmData()));
        itemIsSolved.setChecked(criminal.isSolved());

        return convertView;
    }
}
