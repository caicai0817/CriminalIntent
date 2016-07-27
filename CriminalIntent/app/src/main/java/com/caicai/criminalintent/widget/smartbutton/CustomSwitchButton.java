package com.caicai.criminalintent.widget.smartbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/7/19 16:48
 * @Description: 自定义button
 */
public class CustomSwitchButton extends View {

    private Bitmap backButton;
    private Bitmap slideButton;
    private float left;
    private boolean isClicked = false;
    private boolean isTouch = true;
    private float max;
    private float startX;
    private float firstX;

    public CustomSwitchButton(Context context) {
        super(context);
        initView();
    }

    public CustomSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomSwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomSwitchButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        backButton = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_background);
        slideButton = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_button);
        max = backButton.getWidth() - slideButton.getWidth();

        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isTouch) {
                    if (isClicked) {
                        isClicked = false;
                    } else {
                        isClicked = true;
                    }

                    flushView();
                }
                isTouch = true;
            }
        });

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("gly", "ACTION_DOWN");
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("gly", "ACTION_MOVE");
                float moveX = event.getX();
                float instance = moveX - startX;
                left += instance;
                firstX += Math.abs(instance);
                startX = moveX;

                refreshView();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("gly", "ACTION_UP");
                if (firstX > 10){
                    isTouch = false;
                }
                firstX = 0;

                if (left < max/2){
                    isClicked = false;
                }else{
                    isClicked  = true;
                }
                flushView();

                break;
        }
        return super.onTouchEvent(event);
//        return true;
    }

    private void flushView() {
        if (isClicked) {
            left = max;
        } else {
            left = 0;
        }

        refreshView();
    }

    private void refreshView() {
        if (left < 0) {
            left = 0;
        } else if (left > max) {
            left = max;
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(backButton.getWidth(), backButton.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(backButton, 0, 0, new Paint());
        canvas.drawBitmap(slideButton, left, 0, new Paint());
        Log.e("gly", "onDraw");
    }
}
