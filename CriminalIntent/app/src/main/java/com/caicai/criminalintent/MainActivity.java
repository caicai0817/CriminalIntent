package com.caicai.criminalintent;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    /**
     * 创建依附的fragment
     * @return
     */
    @Override
    protected Fragment createFragment() {
        return new CriminalFragment();
    }
}