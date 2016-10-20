package com.caicai.criminalintent.safe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/9/10 16:35
 * @Description: 请用一句话描述
 */
public class MainUI extends Activity implements AdapterView.OnItemClickListener {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        initView();
        gridView.setAdapter(new SafeMainAdapter());
        gridView.setOnItemClickListener(this);
    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.safe_main_gv);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("caicai", "positon == " + position);
        switch (position) {
            case 0:
                dealListView();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;


        }
    }

    /**
     * peroid10.0 招聘职播的需求
     */
    private void dealListView() {
        startActivity(new Intent(this, ZhaopinListActivity.class));

    }

    class SafeMainAdapter extends BaseAdapter {
        int[] imageId = {R.mipmap.face1, R.mipmap.face2,
                R.mipmap.face3, R.mipmap.face4, R.mipmap.face5,
                R.mipmap.face6, R.mipmap.face7, R.mipmap.face8,
                R.mipmap.face9};

        String[] names = {"吴亦凡", "陈伟霆", "李易峰", "易烊千玺", "彭于晏", "吴彦祖",
                "谢霆锋", "靳东", "周杰伦"};

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainUI.this, R.layout.item_safe_main_gv, null);
            ImageView iv = (ImageView) view.findViewById(R.id.item_safe_main_iv);
            TextView tv = (TextView) view.findViewById(R.id.item_safe_main_tv);
            iv.setImageResource(imageId[position]);
            tv.setText(names[position]);
            return view;
        }
    }
}
