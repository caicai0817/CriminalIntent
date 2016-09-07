package com.caicai.criminalintent.animation.Circle;

import android.animation.TypeEvaluator;

/**
 * @Author : caicai
 * @Time : 2016/9/5 17:41
 * @Description: 圆形计数器
 */
public class CircleEvaluator implements TypeEvaluator<MyPoint> {
    @Override
    public MyPoint evaluate(float fraction, MyPoint startValue, MyPoint endValue) {
        int start = startValue.getRadis();
        int end = endValue.getRadis();
        int cur = (int) (start + fraction * (end - start));
        MyPoint myPoint = new MyPoint(cur);
        return myPoint;
    }
}
