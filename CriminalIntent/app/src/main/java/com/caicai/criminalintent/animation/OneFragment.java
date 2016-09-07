package com.caicai.criminalintent.animation;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.animation.Circle.TextSwitcherView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : caicai
 * @Time : 2016/9/2 18:07
 * @Description: 请用一句话描述
 */
public class OneFragment extends Fragment {

    private ImageView pointer;//指针
    private Animation animation;
    private ImageView light;
    private TextSwitcherView scrollTv;
    private TextSwitcher ts;
    private int curStr;
    private List<String> list = new ArrayList();

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                ts.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.self_scroll_tv1));
                ts.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.self_scroll_tv));
                ts.setText(list.get(curStr++ % list.size()));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //配置自己的动画
        View view = View.inflate(getActivity(), R.layout.fragment_self_tv, null);
        list.add("欢迎来到菜菜庄园");
        list.add("兔子小风扇");
        light = (ImageView) view.findViewById(R.id.self_light);
        AnimationDrawable ad = (AnimationDrawable) light.getDrawable();
        ad.start();
        initTextView(view);
//        initView(view);
//        init(view);
        return view;
    }

    private void initTextView(View view) {
        ts = (TextSwitcher) view.findViewById(R.id.self_ts);
        ts.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(getActivity());
                tv.setTextColor(Color.RED);
                return tv;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        handler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    /*private void initView(View view) {
        light = (ImageView) view.findViewById(R.id.self_light);
        scrollTv = (TextSwitcherView) view.findViewById(R.id.self_scroll_tv);
        scrollTv.getResource((ArrayList<String>) list);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.self_scroll_tv);
//        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_PARENT,0);
        animation.setDuration(2000);
        animation.setRepeatCount(-1);
        scrollTv.startAnimation(animation);

    }*/

    private void init(View view) {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_pointer);
        animation.setFillAfter(true);
        pointer = (ImageView) view.findViewById(R.id.guide_one_pointer);
        pointer.startAnimation(animation);
    }
}
