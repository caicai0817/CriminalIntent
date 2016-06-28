package com.caicai.criminalintent.activity.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2016/6/6 16:37
 * @Description: 请用一句话描述
 */
public class FinishProjectPopupWindows extends PopupWindow {

    private static final String TAG = "FinishProjectPopupWindows";

    private View mView;
    public TextView btnSaveProject;

    public FinishProjectPopupWindows(Activity context,
                                     View.OnClickListener itemsOnClick) {
        super(context);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_resume, null);

        btnSaveProject = (TextView) mView.findViewById(R.id.show_action);

        btnSaveProject.setOnClickListener(itemsOnClick);

        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.mystyle);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }
}
