package com.caicai.criminalintent.animation.Circle;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.caicai.criminalintent.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author : caicai
 * @Time : 2016/9/6 20:30
 * @Description: 请用一句话描述
 */
public class TextSwitcherView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private ArrayList<String> reArrayList = new ArrayList<String>();
    private int resIndex = 0;
    private final int UPDATE_TEXTSWITCHER = 1;
    private int timerStartAgainCount = 0;
    private Context mContext;
    public TextSwitcherView(Context context) {

        super(context);
        // TODO Auto-generated constructor stub
        mContext = context;
        init();
    }
    public TextSwitcherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
        // TODO Auto-generated constructor stub
    }

    private void init(){
        this.setFactory(this);
        this.setInAnimation(getContext(), R.anim.self_scroll_tv);
        this.setOutAnimation(getContext(), R.anim.self_scroll_tv1);
        Timer timer = new Timer();
        timer.schedule(timerTask, 1,3000);
    }
    TimerTask timerTask =  new TimerTask() {

        @Override
        public void run() {   //不能在这里创建任何UI的更新，toast也不行
            // TODO Auto-generated method stub
            Message msg = new Message();
            msg.what = UPDATE_TEXTSWITCHER;
            handler.sendMessage(msg);
        }
    };
    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXTSWITCHER:
                    updateTextSwitcher();

                    break;
                default:
                    break;
            }

        };
    };
    /**
     * 需要传递的资源
     * @param reArrayList
     */
    public void getResource(ArrayList<String> reArrayList) {
        this.reArrayList = reArrayList;
    }
    public void updateTextSwitcher() {
        if (this.reArrayList != null && this.reArrayList.size()>0) {
            this.setText(this.reArrayList.get(resIndex++));
            if (resIndex > this.reArrayList.size()-1) {
                resIndex = 0;
            }
        }

    }
    @Override
    public View makeView() {
        // TODO Auto-generated method stub
        TextView tView = new TextView(getContext());
        tView.setTextSize(20);
        tView.setTextColor(0xff24aaff);
        return tView;
    }
}
