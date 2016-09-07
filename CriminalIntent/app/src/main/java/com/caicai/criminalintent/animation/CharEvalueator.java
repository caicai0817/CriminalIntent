package com.caicai.criminalintent.animation;

import android.animation.TypeEvaluator;

/**
 * @Author : caicai
 * @Time : 2016/9/5 15:35
 * @Description: 字符求值器
 */
public class CharEvalueator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startChar = (int) startValue;
        int endChar = (int) endValue;
        int curChar = (int) (startChar + (fraction * (endChar - startChar)));
        return (char) curChar;
    }
}
