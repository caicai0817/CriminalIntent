package com.caicai.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * listFragment列表fragment
 */
public class CriminalListFragment extends ListFragment {

    private ArrayList<Criminal> mCriminals;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化数据
        mCriminals = CriminalLab.getsCriminalLab().getmCriminals();

        //使用系统自带的布局
        //ArrayAdapter<Criminal> adapter = new ArrayAdapter<Criminal>(getActivity(), android.R.layout.simple_list_item_1, mCriminals);

        //使用自定义Adapter和布局
        CriminalAdapter adapter = new CriminalAdapter(getActivity(), mCriminals);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Criminal criminal = (Criminal) getListAdapter().getItem(position);
        Log.e(utils.CAICAI, criminal.getmTitle() + "点击了");

        Intent intent = new Intent();
        intent.putExtra(Config.ITEM_FLAG, criminal.getmId());
        intent.setClass(getActivity(), CriminalPagerActivity.class);
        startActivity(intent);
    }
}
