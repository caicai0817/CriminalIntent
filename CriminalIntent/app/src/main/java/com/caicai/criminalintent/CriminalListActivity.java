package com.caicai.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Author : caicai
 * Time : 2015/12/10 09:59
 * Description:listFragment的托管类
 */
public class CriminalListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CriminalListFragment();
    }
}
