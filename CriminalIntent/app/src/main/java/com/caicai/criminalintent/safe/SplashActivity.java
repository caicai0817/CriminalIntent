package com.caicai.criminalintent.safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.util.TitleBarBuilder;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private SplashAdapter splashAdapter;

    private List<View> lists = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TextView start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        initData();
        initView();
    }


    private void initData() {
        titles.add("李小冉");
        titles.add("李易峰");
        titles.add("张鲁一");
        titles.add("周冬雨");
        LayoutInflater layoutInflater = getLayoutInflater().from(this);
        view1 = layoutInflater.inflate(R.layout.splash_one, null);
        view2 = layoutInflater.inflate(R.layout.splash_two, null);
        view3 = layoutInflater.inflate(R.layout.splash_three, null);
        view4 = layoutInflater.inflate(R.layout.splash_four, null);

        new TitleBarBuilder(view1).setTitleText("春江水暖鸭先知");
        new TitleBarBuilder(view2).setTitleText("有朋自远方来");
        new TitleBarBuilder(view3).setTitleText("天上我才必有用");
        new TitleBarBuilder(view4).setTitleText("我辈岂是蓬蒿人");

        initView4(view4);

        lists.add(view1);
        lists.add(view2);
        lists.add(view3);
        lists.add(view4);
    }

    private void initView4(View view4) {
        start = (TextView) view4.findViewById(R.id.splash_four_tv);
        start.setOnClickListener(this);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.splash_vp);
        splashAdapter = new SplashAdapter();
        vp.setAdapter(splashAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.splash_four_tv:
                startActivity(new Intent(SplashActivity.this, MainUI.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
                finish();
                break;
        }
    }

    class SplashAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(lists.get(position), 0);
            return lists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(lists.get(position));
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
