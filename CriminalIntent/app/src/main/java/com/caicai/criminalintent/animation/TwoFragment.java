package com.caicai.criminalintent.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/9/2 18:07
 * @Description: 请用一句话描述
 */
public class TwoFragment extends Fragment {

    private ImageView car;
    private AnimationDrawable ad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_two, null);
        init(view);
        return view;
    }

    private void init(View view) {
        car = (ImageView) view.findViewById(R.id.guide_two_car);
        ad = (AnimationDrawable) car.getBackground();
        ad.start();
    }


}
