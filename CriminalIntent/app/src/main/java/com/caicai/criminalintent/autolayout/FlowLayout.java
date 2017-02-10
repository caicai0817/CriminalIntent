package com.caicai.criminalintent.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author : caicai
 * @Time : 2016/12/16 14:15
 * @Description: 流式布局
 */
public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Log.e("caicai", "flowlayout init~~~");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("caicai", "onMeasure started=====");
        //测量模式和测量值
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //距离左侧距离
        int left = 0;
        //行高
        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            //实际字控件的宽和高
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (left + childWidth < widthSize) {
                left += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            } else {
                break;
            }
        }

        //super
        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? widthSize
                : left, (heightMode == MeasureSpec.EXACTLY) ? heightSize
                : lineHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("caicai", "onlayout started**********");

        int width = getWidth();
        Log.e("caicai", "getWidth==" + width);
        Log.e("caicai", "r-l==" + (r - l));

        int left = 0;
        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            if (child.getVisibility() == View.GONE) {
                continue;
            }

            //子控件的宽和高
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (left + childWidth < width) {
                lineHeight = Math.max(lineHeight, childHeight);
            }
            child.layout(left, 0, left + childWidth, lineHeight);
            left += childWidth;

        }
    }
}
