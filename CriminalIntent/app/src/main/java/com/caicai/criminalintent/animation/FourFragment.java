package com.caicai.criminalintent.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/9/2 18:07
 * @Description: 请用一句话描述
 */
public class FourFragment extends Fragment {

    private Button start;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_four, null);
        start = (Button) view.findViewById(R.id.guide_four_animation);
        tv = (TextView) view.findViewById(R.id.guide_four_tv);

//        ValueAnimator va = ValueAnimator.ofFloat(0f, 400f, 0f, 400f);
//        ValueAnimator va = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        ValueAnimator va = ValueAnimator.ofObject(new CharEvalueator(),new Character('A'),new Character('Z'));
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char animatedValue = (char) animation.getAnimatedValue();
//                int value = animatedValue.intValue();
//                tv.layout(value, value, value + tv.getWidth(), value + tv.getWidth());
//                tv.setBackgroundColor(animatedValue);
                Log.e("caicai",String.valueOf(animatedValue));
                tv.setText(String.valueOf(animatedValue));
            }
        });
//        va.setEvaluator(new ArgbEvaluator());
//        va.setRepeatMode(ValueAnimator.REVERSE);
//        va.setRepeatCount(ValueAnimator.INFINITE);
        va.setDuration(3000);
        va.start();
        return view;
    }
}
