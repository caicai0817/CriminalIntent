package com.caicai.criminalintent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.caicai.criminalintent.Config;
import com.caicai.criminalintent.Criminal;
import com.caicai.criminalintent.fragment.CriminalFragment;
import com.caicai.criminalintent.CriminalLab;
import com.caicai.criminalintent.R;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @Author : caicai
 * @Time : 2015/12/11 16:57
 * @Description: viewpagerActivity
 */
public class CriminalPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private ArrayList<Criminal> mCriminals;
    private UUID criminalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);

        setContentView(viewPager);

        Intent intent = getIntent();
        if (intent != null) {
            criminalId = (UUID) intent.getSerializableExtra(Config.ITEM_FLAG);
        }

        mCriminals = CriminalLab.getsCriminalLab().getmCriminals();

        FragmentManager fm = getSupportFragmentManager();

        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Criminal criminal = mCriminals.get(position);
                return CriminalFragment.getInstance(criminal.getmId());
            }

            @Override
            public int getCount() {
                return mCriminals.size();
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Criminal criminal = mCriminals.get(position);
                if (criminal.getmTitle() != null) {
                    setTitle(criminal.getmTitle());
                    Log.e("caicai", "pager选中的item" + criminal.getmTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        for (int i = 0; i < mCriminals.size(); i++) {
            if (mCriminals.get(i).getmId().equals(criminalId)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
