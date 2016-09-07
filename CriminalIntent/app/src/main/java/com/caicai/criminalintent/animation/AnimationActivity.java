package com.caicai.criminalintent.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.*;

import com.caicai.criminalintent.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView animatioin1;
    private TextView animatioin2;
    private TextView animatioin3;
    private TextView animatioin4;
    private ImageView iv;
    private AnimationDrawable drawable;
    private AnimationDrawable drawable1;
    private ImageView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animatioin1 = (TextView) findViewById(R.id.animation_1);
        animatioin2 = (TextView) findViewById(R.id.animation_2);
        animatioin3 = (TextView) findViewById(R.id.animation_3);
        animatioin4 = (TextView) findViewById(R.id.animation_4);

        iv = (ImageView) findViewById(R.id.animation_iv);
        drawable1 = new AnimationDrawable();
        /*drawable1.addFrame(getResources().getDrawable(R.mipmap.a1), 150);
        drawable1.addFrame(getResources().getDrawable(R.mipmap.a2), 150);
        drawable1.addFrame(getResources().getDrawable(R.mipmap.a3), 150);
        drawable1.addFrame(getResources().getDrawable(R.mipmap.a4), 150);
        drawable1.addFrame(getResources().getDrawable(R.mipmap.a5), 150);
        drawable1.addFrame(getResources().getDrawable(R.mipmap.a6), 150);*/
        //上面的代码换一种简单的方式执行
        for (int i = 1; i < 7; i++) {
            int id = getResources().getIdentifier("a" + i, "mipmap", getPackageName());
            Drawable drawable2 = getResources().getDrawable(id);
            drawable1.addFrame(drawable2, 150);
        }
        drawable1.setOneShot(false);//设置为false为无线循环
        iv.setBackgroundDrawable(drawable1);

        dialog = (ImageView) findViewById(R.id.property_animation);
        guideToResume();

        animatioin1.setOnClickListener(this);
        animatioin2.setOnClickListener(this);
        animatioin3.setOnClickListener(this);
        animatioin4.setOnClickListener(this);

    }

    /**
     * 引导创建简历
     */
    private void guideToResume() {
        /**
         * 1 BounceInterpolator 回弹效果 相当于ios的弹力值
         * 2 AccelerateDecelerateInterpolator 加速减速 先慢再快再变慢
         * 3 AccelerateInterpolator 先慢后快
         * 4 AnticipateInterpolator 先往反方向跑 在加速正方向走
         * 5 AnticipateOvershootInterpolator 先往相反的方向跑 再跑出去一点 然后回到终点
         * 6 CycleInterpolator(cycle)按指定的路径以指定时间（或者是偏移量）的1/4、变速地执行一遍，
         *   再按指定的轨迹的相反反向走1/2的时间，再按指定的路径方向走完剩余的1/4的时间，最后回到原点。
         *   假如：默认是让a从原点往东跑100米。它会先往东跑100米，然后往西跑200米，再往东跑100米回到原点。
         *   可在在参数处指定循环的次数
         * 7 DecelerateInterpolator 先快后慢
         * 8 LinearInterpolator 线性匀速
         * 9 OvershootInterpolator 先跑出界然后往回跑
         */
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.guide_resume);
        animation.setInterpolator(new AnticipateInterpolator());
        dialog.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animation_1:
                iv.setImageResource(R.drawable.animation1);
                drawable = (AnimationDrawable) iv.getDrawable();
                drawable.start();
                break;
            case R.id.animation_2:
                iv.setImageResource(R.drawable.animation2);
                drawable = (AnimationDrawable) iv.getDrawable();
                drawable.start();
                break;
            case R.id.animation_3:
                drawable = (AnimationDrawable) iv.getDrawable();
                drawable.stop();
                break;
            case R.id.animation_4:
                if (drawable1 != null && !drawable1.isRunning()) {
                    drawable1.start();
                }
                break;
        }
    }
}
