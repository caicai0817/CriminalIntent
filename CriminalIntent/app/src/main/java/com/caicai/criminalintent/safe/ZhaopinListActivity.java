package com.caicai.criminalintent.safe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.caicai.criminalintent.R;

import java.util.ArrayList;
import java.util.List;

public class ZhaopinListActivity extends AppCompatActivity {

    private ListView myLV;
    private MyAdapter myAdapter;
    private List allData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhaopin_list);
        initData();
        myLV = (ListView) findViewById(R.id.zhaopin_lv);
        myAdapter = new MyAdapter();
        myLV.setAdapter(myAdapter);
    }

    private void initData() {
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return allData.size();
        }

        @Override
        public Object getItem(int position) {
            return allData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
