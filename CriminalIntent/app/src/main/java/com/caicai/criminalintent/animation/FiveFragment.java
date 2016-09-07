package com.caicai.criminalintent.animation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.animation.Circle.PointView;

/**
 * @Author : caicai
 * @Time : 2016/9/2 18:07
 * @Description: 请用一句话描述
 */
public class FiveFragment extends Fragment {

    private PointView pv;
    private TextView tv;
    private PropertyValuesHolder rotate;
    private PropertyValuesHolder background;
    private ObjectAnimator objectAnimator;
    private PropertyValuesHolder scale;
    private PropertyValuesHolder propertyValuesHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_five, null);
        tv = (TextView) view.findViewById(R.id.guide_five_start);
        pv = (PointView) view.findViewById(R.id.guide_five_circle);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pv.doAnimation();
                ObjectAnimator pointRadius = ObjectAnimator.ofInt(pv, "pointRadius", 0, 300, 100);
                pointRadius.setDuration(2000);
                pointRadius.start();
            }
        });

//        rotate = PropertyValuesHolder.ofFloat("rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
//        background = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffff00, 0xffff0000, 0xff0000ff);
//        scale = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.5f);
//
//        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv, rotate, background,scale);

        propertyValuesHolder = PropertyValuesHolder.ofObject("charText", new CharEvalueator(), new Character('A'), new Character('Z'));
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv,propertyValuesHolder);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        return view;
    }
}
