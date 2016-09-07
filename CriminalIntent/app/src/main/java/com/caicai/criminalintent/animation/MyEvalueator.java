package com.caicai.criminalintent.animation;

import android.animation.TypeEvaluator;

/**
 * @Author : caicai
 * @Time : 2016/9/5 15:35
 * @Description: 请用一句话描述
 */
public class MyEvalueator implements TypeEvaluator<Float> {
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        return endValue - (endValue - startValue) * fraction;
    }
}
