package com.caicai.criminalintent.animation.Circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : caicai
 * @Time : 2016/9/5 17:36
 * @Description: 自定义圆形图片
 */
public class PointView extends View {
    private MyPoint mPoint = new MyPoint(0);

//    public PointView(Context context) {
//        super(context);
//    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public PointView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint != null) {
            Paint mPaint = new Paint();
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300, 300, mPoint.getRadis(), mPaint);
        }
    }

    /**
     * ValueAnimation实现执行圆形放大操作
     */
//    public void doAnimation() {
//        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new CircleEvaluator(), new MyPoint(20), new MyPoint(150));
//
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                mPoint = (MyPoint) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
//        valueAnimator.setInterpolator(new BounceInterpolator());
//        valueAnimator.setDuration(2000);
//        valueAnimator.start();
//    }

    /**
     * ObjectAnimation实现圆形放大的操作
     * @param radius
     */
    public void setPointRadius(int radius){
        mPoint.setRadis(radius);
        invalidate();
    }
}
