package com.caicai.criminalintent.widget.popup;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.caicai.criminalintent.R;

import java.util.ArrayList;

/**
 * @Author : caicai
 * @Time : 2016/7/27 14:37
 * @Description: 请用一句话描述
 */
public class PopupView extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText popupEt;
    private ImageView arrowDown;
    private ListView popListView;
    private MyAdapter myAdapter;
    private ArrayList<String> strs = new ArrayList<>();
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        strs.add("靳东");
        strs.add("李钟硕");
        strs.add("陈伟霆");

        popupEt = (EditText) findViewById(R.id.popup_et);
        arrowDown = (ImageView) findViewById(R.id.popup_down);
        arrowDown.setOnClickListener(this);

        popListView = new ListView(this);
        myAdapter = new MyAdapter();
        popListView.setAdapter(myAdapter);
        popListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popup_down:
                popupWindow = new PopupWindow(popListView, popupEt.getWidth(), RelativeLayout.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
//                popupWindow.showAtLocation(popupEt, Gravity.BOTTOM, 0, 0);
                popupWindow.showAsDropDown(popupEt);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        popupEt.setText(strs.get(position));
        popupWindow.dismiss();
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strs.size();
        }

        @Override
        public Object getItem(int position) {
            return strs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(PopupView.this, R.layout.item_popup, null);
                viewHolder.itemDelete = (ImageView) convertView.findViewById(R.id.item_delete);
                viewHolder.name = (TextView) convertView.findViewById(R.id.item_name);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.name.setText(strs.get(position));
            viewHolder.itemDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strs.remove(position);
                    myAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }

    class ViewHolder{
        ImageView itemDelete;
        TextView name;
    }
}
