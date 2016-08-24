package com.caicai.criminalintent.widget.popup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
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
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

//        strs.add("靳东");
//        strs.add("李钟硕");
//        strs.add("陈伟霆");

//        popupEt = (EditText) findViewById(R.id.popup_et);
        gestureDetector = new GestureDetector(this, new GestureListenerImpl());
        arrowDown = (ImageView) findViewById(R.id.popup_down);
//        arrowDown.setOnClickListener(this);
//        arrowDown.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        });

//        popListView = new ListView(this);
//        myAdapter = new MyAdapter();
//        popListView.setAdapter(myAdapter);
//        popListView.setOnItemClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListenerImpl implements GestureDetector.OnGestureListener {

        //触摸屏幕是调用
        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("caicai", "onDown");
            return false;
        }

        //手指在屏幕上按下,且未移动和松开时调用该方法
        @Override
        public void onShowPress(MotionEvent e) {
            Log.e("caicai", "onShowPress");
        }

        //轻击屏幕时调用该方法
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("caicai", "onSingleTapUp");
            return false;
        }

        //手指在屏幕上滚动时会调用该方法
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("caicai", "onScroll");
            return false;
        }

        //手指长按屏幕是会调用该方法
        @Override
        public void onLongPress(MotionEvent e) {
            Log.e("caicai", "onLongPress");
        }

        //手指在屏幕上拖动时会掉用该方法
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.e("caicai", "onFling");
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popup_down:
                /*popupWindow = new PopupWindow(popListView, popupEt.getWidth(), RelativeLayout.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
//                popupWindow.showAtLocation(popupEt, Gravity.BOTTOM, 0, 0);
                popupWindow.showAsDropDown(popupEt);*/
                ViewConfiguration viewConfiguration = ViewConfiguration.get(PopupView.this);

                //是否有物理键
                boolean menuKey = viewConfiguration.hasPermanentMenuKey();//false
                //系统所能识别的被认为是滑动的最小距离
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();//24
                //fling速度的最大值
                int scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();//24000
                //fling速度的最小值
                int scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();//150

                /** 静态方法*/
                //双击间隔时间 在改时间内是双击,否则为点击
                int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout();//300
                //按住状态转变为长按状态所需要的时间
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();//500
                //重复按键的时间
                int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout();//500

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
            } else {
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

    class ViewHolder {
        ImageView itemDelete;
        TextView name;
    }
}
