package com.caicai.criminalintent.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.animation.*;
import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/9/2 18:07
 * @Description: 请用一句话描述
 */
public class ThreeFragment extends Fragment {

    private ImageView car;
    private ImageView shadow;
    private ImageView fastCloud;
    private ImageView slowCloud;
    private Animation animation;
    private Animation animation1;
    private Animation animation2;
    private Animation animation3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_three,null);
        init(view);
        return view;
    }

    private void init(View view) {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_car);
        animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_shadow);
        animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_cloud);
        animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_cloud2);
        car = (ImageView) view.findViewById(R.id.guide_three_car);
        shadow = (ImageView) view.findViewById(R.id.guide_three_shadow);
        fastCloud = (ImageView) view.findViewById(R.id.guide_three_cloud_fast);
        slowCloud = (ImageView) view.findViewById(R.id.guide_three_cloud_slow);

        car.startAnimation(animation);
        shadow.startAnimation(animation1);
        fastCloud.startAnimation(animation2);
        animation3.setFillAfter(true);
        slowCloud.startAnimation(animation3);
    }
}
