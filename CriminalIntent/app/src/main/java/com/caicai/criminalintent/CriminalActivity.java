package com.caicai.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CriminalActivity extends SingleFragmentActivity {

    /**
     * 创建依附的fragment
     *
     * @return
     */
    @Override
    protected Fragment createFragment() {
//        return new CriminalFragment();
        Intent intent = getIntent();
        if (intent != null && intent.getSerializableExtra(Config.ITEM_FLAG) != null) {
            UUID criminalId = (UUID) intent.getSerializableExtra(Config.ITEM_FLAG);
            return CriminalFragment.getInstance(criminalId);
        }
        return null;
    }
}
