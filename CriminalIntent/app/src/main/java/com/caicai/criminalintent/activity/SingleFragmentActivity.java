package com.caicai.criminalintent.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.caicai.criminalintent.R;

/**
 * Author : caicai
 * Time : 2015/12/9 11:01
 * Description:创建生成fragment的抽象类
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.container_fragment,fragment).commit();
        }
    }

    /**
     * 创建fragment的类
     */
    protected abstract Fragment createFragment();
}
