package com.caicai.criminalintent.util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.caicai.criminalintent.R;

public class TitleBarBuilder {
    private View viewTitle;
    private TextView tvTitle;
    private ImageView ivTitle;
    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvLeft;
    private TextView tvRight;

    public TitleBarBuilder(Activity context) {
        viewTitle = context.findViewById(R.id.navigationbar);
        tvTitle = (TextView) viewTitle.findViewById(R.id.navigationbar_title_txt);
        ivTitle = (ImageView) viewTitle.findViewById(R.id.navigationbar_title_img);
        ivLeft = (ImageView) viewTitle.findViewById(R.id.navigationbar_left_img);
        ivRight = (ImageView) viewTitle.findViewById(R.id.navigationbar_right_img);
        tvLeft = (TextView) viewTitle.findViewById(R.id.navigationbar_left_txt);
        tvRight = (TextView) viewTitle.findViewById(R.id.navigationbar_right_txt);
    }

    public TitleBarBuilder(View context) {
        viewTitle = context.findViewById(R.id.navigationbar);
        tvTitle = (TextView) viewTitle.findViewById(R.id.navigationbar_title_txt);
        ivTitle = (ImageView) viewTitle.findViewById(R.id.navigationbar_title_img);
        ivLeft = (ImageView) viewTitle.findViewById(R.id.navigationbar_left_img);
        ivRight = (ImageView) viewTitle.findViewById(R.id.navigationbar_right_img);
        tvLeft = (TextView) viewTitle.findViewById(R.id.navigationbar_left_txt);
        tvRight = (TextView) viewTitle.findViewById(R.id.navigationbar_right_txt);
    }

    // title

    public TitleBarBuilder setTitleBgRes(int resid) {
        viewTitle.setBackgroundResource(resid);
        return this;
    }

    public TitleBarBuilder setTitleText(String text) {
        tvTitle.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvTitle.setText(text);
        return this;
    }

    public TitleBarBuilder setTitleImage(int resId) {
        ivTitle.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivTitle.setImageResource(resId);
        return this;
    }

    // left

    public TitleBarBuilder setLeftImage(int resId) {
        ivLeft.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivLeft.setImageResource(resId);
        return this;
    }

    public TitleBarBuilder setLeftText(String text) {
        tvLeft.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvLeft.setText(text);
        return this;
    }

    public TitleBarBuilder setLeftOnClickListener(OnClickListener listener) {
        if (ivLeft.getVisibility() == View.VISIBLE) {
            ivLeft.setOnClickListener(listener);
        } else if (tvLeft.getVisibility() == View.VISIBLE) {
            tvLeft.setOnClickListener(listener);
        }
        return this;
    }

    // right

    public TitleBarBuilder setRightImage(int resId) {
        ivRight.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivRight.setImageResource(resId);
        return this;
    }

    public TitleBarBuilder setRightText(String text) {
        tvRight.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvRight.setText(text);
        return this;
    }

    public TitleBarBuilder setRightOnClickListener(OnClickListener listener) {
        if (ivRight.getVisibility() == View.VISIBLE) {
            ivRight.setOnClickListener(listener);
        } else if (tvRight.getVisibility() == View.VISIBLE) {
            tvRight.setOnClickListener(listener);
        }
        return this;
    }

    public View build() {
        return viewTitle;
    }
}
