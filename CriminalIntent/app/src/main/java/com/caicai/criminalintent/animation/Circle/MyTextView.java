package com.caicai.criminalintent.animation.Circle;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @Author : caicai
 * @Time : 2016/9/6 15:54
 * @Description: 请用一句话描述
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character character) {
        setText(String.valueOf(character));
    }
}
