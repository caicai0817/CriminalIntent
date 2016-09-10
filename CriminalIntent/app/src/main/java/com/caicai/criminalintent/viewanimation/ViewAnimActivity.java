package com.caicai.criminalintent.viewanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.caicai.criminalintent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义控件动画类
 */
public class ViewAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView menu;
    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private ImageView circle4;
    private ImageView circle5;


    //    private TextView addData;
//    private ListView animLv;
//    private GridView gridView;
    private ArrayAdapter<String> mAdapter;
    private GridAdapter gridAdapter;
    private Button added;
    private Button remove;
    private LinearLayout aotoAdded;

    private boolean isOpened;
    private List<String> data = new ArrayList<>();
    private int i = 0;
    private LayoutTransition layoutTransition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        initData();
        initView();
        initAnim();
    }

    private void initAnim() {
        layoutTransition = new LayoutTransition();

        //出现时动画
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(null, "rotationY", 0f, 180f, 0f);
        rotationY.setDuration(3000);
        layoutTransition.setAnimator(LayoutTransition.APPEARING, rotationY);

        //消失时动画
        ObjectAnimator ratation = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        ratation.setDuration(3000);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, ratation);

        //出现新动画状态改变时动画
        PropertyValuesHolder left = PropertyValuesHolder.ofInt("left", 0, 100, 0);
        PropertyValuesHolder top = PropertyValuesHolder.ofInt("top", 1, 1);
        //必须第一个值与最后一值相同才会有效果,不然没有效果
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.2f, 1f);
        Animator change = ObjectAnimator.ofPropertyValuesHolder(aotoAdded, left, top, scaleX);
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, change);

        //消失动画状态改变时动画
        PropertyValuesHolder left1 = PropertyValuesHolder.ofInt("left", 0, 0);
        PropertyValuesHolder top1 = PropertyValuesHolder.ofInt("top", 0, 0);

        Keyframe keyframe = Keyframe.ofFloat(0f, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe keyframe3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe keyframe4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe keyframe5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe keyframe6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe keyframe7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe keyframe8 = Keyframe.ofFloat(0.9f, 0);

        PropertyValuesHolder rotationg = PropertyValuesHolder.ofKeyframe("rotation", keyframe, keyframe1, keyframe2, keyframe3, keyframe4, keyframe5, keyframe6, keyframe7,keyframe8);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, left1, top1, rotationg);
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, objectAnimator);

        aotoAdded.setLayoutTransition(layoutTransition);
    }

    private void initView() {
        menu = (ImageView) findViewById(R.id.xianyu_menu);
        circle1 = (ImageView) findViewById(R.id.xianyu_circle_1);
        circle2 = (ImageView) findViewById(R.id.xianyu_circle_2);
        circle3 = (ImageView) findViewById(R.id.xianyu_circle_3);
        circle4 = (ImageView) findViewById(R.id.xianyu_circle_4);
        circle5 = (ImageView) findViewById(R.id.xianyu_circle_5);

//        addData = (TextView) findViewById(R.id.xianyu_tv);
//        animLv = (ListView) findViewById(R.id.xianyu_lv);
//        addData.setOnClickListener(this);
//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
//        animLv.setAdapter(mAdapter);

//        gridView = (GridView) findViewById(R.id.xianyu_grid);
//        gridAdapter = new GridAdapter();
//        gridView.setAdapter(gridAdapter);

        added = (Button) findViewById(R.id.xianyu_added);
        remove = (Button) findViewById(R.id.xianyu_remove);
        aotoAdded = (LinearLayout) findViewById(R.id.xianyu_auto_added);

        menu.setOnClickListener(this);
        circle1.setOnClickListener(this);
        circle2.setOnClickListener(this);
        circle3.setOnClickListener(this);
        circle4.setOnClickListener(this);
        circle5.setOnClickListener(this);

        added.setOnClickListener(this);
        remove.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xianyu_menu://菜单
                if (!isOpened) {
                    isOpened = true;
                    doAnimateOpen(circle1, 0, 5, 500);
                    doAnimateOpen(circle2, 1, 5, 500);
                    doAnimateOpen(circle3, 2, 5, 500);
                    doAnimateOpen(circle4, 3, 5, 500);
                    doAnimateOpen(circle5, 4, 5, 500);
                } else {
                    isOpened = false;
                    doAnimateClose(circle1, 0, 5, 500);
                    doAnimateClose(circle2, 1, 5, 500);
                    doAnimateClose(circle3, 2, 5, 500);
                    doAnimateClose(circle4, 3, 5, 500);
                    doAnimateClose(circle5, 4, 5, 500);
                }
                break;
            case R.id.xianyu_circle_1://菜单1
                Toast.makeText(ViewAnimActivity.this, "吴亦凡--1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xianyu_circle_2://菜单2
                Toast.makeText(ViewAnimActivity.this, "李易峰--2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xianyu_circle_3://菜单3
                Toast.makeText(ViewAnimActivity.this, "易烊千玺--3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xianyu_circle_4://菜单4
                Toast.makeText(ViewAnimActivity.this, "周冬雨--4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xianyu_circle_5://菜单5
                Toast.makeText(ViewAnimActivity.this, "靳东--5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xianyu_added://添加数据
                addButton();
                break;
            case R.id.xianyu_remove://移除
                removeButton();
                break;
//            case R.id.xianyu_tv://添加数据
//                initData();
//                mAdapter.notifyDataSetChanged();
//                gridAdapter.notifyDataSetChanged();
//                break;
        }
    }

    private void removeButton() {
        if (i > 0) {
            int childCount = aotoAdded.getChildCount();
            aotoAdded.removeViewAt(0);
            Log.e("caicai", "remove i=" + i + "child=" + childCount);
        }
        i--;
    }

    private void addButton() {
        Button button = new Button(this);
        button.setText("吴亦凡" + i++);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.rightMargin = 10;

        button.setLayoutParams(params);
        aotoAdded.addView(button, 0);
        int childCount = aotoAdded.getChildCount();
        Log.e("caicai", "add i=" + i + "child=" + childCount);
    }

    private void initData() {
        data.add("吴亦凡");
        data.add("李易峰");
        data.add("易烊千玺");
        data.add("周冬雨");
        data.add("靳东");
    }

    /**
     * 打开菜单的动画
     *
     * @param view   执行动画的view
     * @param index  view在动画序列中的顺序,从0开始
     * @param total  动画序列的个数
     * @param radius 动画半径
     *               <p/>
     *               Math.sin(x):x -- 为number类型的弧度，角度乘以0.017(2π/360)可以转变为弧度
     */
    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
//        double degree = Math.PI/ ((total - 1) * 2)  * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 500).start();
    }

    /**
     * 关闭菜单的动画
     *
     * @param view   执行动画的view
     * @param index  view在动画序列中的顺序
     * @param total  动画序列的个数
     * @param radius 动画半径
     */
    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(1 * 500).start();
    }

    public class GridAdapter extends BaseAdapter {

        public final int getCount() {
            return data.size();
        }

        public final Object getItem(int position) {
            return null;
        }

        public final long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView i = new TextView(ViewAnimActivity.this);
            i.setText(data.get(position));
            i.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
            return i;
        }
    }
}
