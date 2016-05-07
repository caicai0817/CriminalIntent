package com.caicai.criminalintent.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.caicai.criminalintent.R;

import java.util.ArrayList;

public class MultiListviewActivity extends AppCompatActivity {
    private ListView mListView;
    private MyAdapter myAdapter;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_listview);

        mListView = (ListView) findViewById(R.id.multi_listview);
        mList = new ArrayList<String>();

        //初始化数据
        for (int i = 0; i < 100; i++) {
            mList.add(i + "");
        }

        myAdapter = new MyAdapter(this);
        mListView.setAdapter(myAdapter);

    }

    class MyAdapter extends BaseAdapter {
        private Context context;
        private final int TYPE_1 = 0;
        private final int TYPE_2 = 1;
        private final int TYPE_3 = 2;


        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public int getItemViewType(int position) {
            int p = position % 6;
            if (p == 0) {
                return TYPE_1;
            } else if (p < 3) {
                return TYPE_2;
            } else if (p < 6) {
                return TYPE_3;
            } else {
                return TYPE_1;
            }
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder1 viewHolder1 = null;
            ViewHolder2 viewHolder2 = null;
            ViewHolder3 viewHolder3 = null;

            int type = getItemViewType(position);

            if (convertView == null) {
                switch (type) {
                    case TYPE_1:
                        convertView = View.inflate(context, R.layout.item_list_1, null);
                        viewHolder1 = new ViewHolder1();
                        viewHolder1.textView = (TextView) convertView.findViewById(R.id.item_1_textView);
                        viewHolder1.checkBox = (CheckBox) convertView.findViewById(R.id.item_1_checkbox);
                        convertView.setTag(viewHolder1);
                        break;
                    case TYPE_2:
                        convertView = View.inflate(context, R.layout.item_list_2, null);
                        viewHolder2 = new ViewHolder2();
                        viewHolder2.textView = (TextView) convertView.findViewById(R.id.item_2_textView);
                        convertView.setTag(viewHolder2);
                        break;
                    case TYPE_3:
                        convertView = View.inflate(context, R.layout.item_list_3, null);
                        viewHolder3 = new ViewHolder3();
                        viewHolder3.textView = (TextView) convertView.findViewById(R.id.item_3_textView);
                        viewHolder3.imageView = (ImageView) convertView.findViewById(R.id.item_3_imageview);
                        convertView.setTag(viewHolder3);
                        break;

                }
            }else{
                switch (type){
                    case TYPE_1:
                        viewHolder1 = (ViewHolder1) convertView.getTag();
                        break;
                    case TYPE_2:
                        viewHolder2 = (ViewHolder2) convertView.getTag();
                        break;
                    case TYPE_3:
                        viewHolder3 = (ViewHolder3) convertView.getTag();
                        break;
                }
            }

            switch (type){
                case TYPE_1:
                    viewHolder1.textView.setText(position+"");
                    viewHolder1.checkBox.setChecked(true);
                    break;
                case TYPE_2:
                    viewHolder2.textView.setText(position+"");
                    break;
                case TYPE_3:
                    viewHolder3.textView.setText(position+"");
                    viewHolder3.imageView.setBackgroundResource(R.drawable.icon_home);
                    break;
            }

            return convertView;

        }
    }

    class ViewHolder1 {
        CheckBox checkBox;
        TextView textView;
    }

    class ViewHolder2 {
        TextView textView;
    }

    class ViewHolder3 {
        ImageView imageView;
        TextView textView;
    }

}
