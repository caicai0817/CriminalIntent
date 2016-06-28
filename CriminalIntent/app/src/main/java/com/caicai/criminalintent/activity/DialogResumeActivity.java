package com.caicai.criminalintent.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.activity.popupwindow.FinishProjectPopupWindows;

/*AlertDialog dialog = new AlertDialog.Builder(DialogResumeActivity.this).create();

        dialog.setView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);  //此处可以设置dialog显示的位置
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.height = 30; // 高度
        dialogWindow.setAttributes(lp);
        window.setWindowAnimations(R.style.mystyle);  //添加动画


//                dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(DialogResumeActivity.this, R.layout.dialog_resume, null);
//                view.setFocusable(true);
//                view.setFocusableInTouchMode(true);

                final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);

                popupWindow.setContentView(view);
                popupWindow.showAtLocation(DialogResumeActivity.this.findViewById(R.id.action999), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

                view.findViewById(R.id.show_action).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogResumeActivity.this,"dialog内部点击",Toast.LENGTH_SHORT);
                    }
                });
                view.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            popupWindow.dismiss();
                            return true;
                        }
                        return false;
                    }
                });



            }
        });

        findViewById(R.id.action999).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogResumeActivity.this,"action",Toast.LENGTH_SHORT);
            }
        });


    }


        */
public class DialogResumeActivity extends AppCompatActivity {
    private FinishProjectPopupWindows mFinishProjectPopupWindow;
    private RelativeLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_resume);

        ll = (RelativeLayout) findViewById(R.id.ll_dialog_action);

        final TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f);
        mHiddenAction.setDuration(500);

        findViewById(R.id.action999).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogResumeActivity.this, "外部点击", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mFinishProjectPopupWindow = new FinishProjectPopupWindows(DialogResumeActivity.this, itemsOnClick);
//                // 显示PopupWindow
//                mFinishProjectPopupWindow.showAtLocation(DialogResumeActivity.this.findViewById(R.id.action999),
//                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                ll.setVisibility(View.VISIBLE);
                ll.startAnimation(mShowAction);

            }
        });

    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mFinishProjectPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.show_action:
                    Toast.makeText(DialogResumeActivity.this, "dialog触发", Toast.LENGTH_SHORT).show();
                    break;
            }

        }

    };
}
