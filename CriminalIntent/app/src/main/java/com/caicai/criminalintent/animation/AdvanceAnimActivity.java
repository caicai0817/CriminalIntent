package com.caicai.criminalintent.animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.caicai.criminalintent.R;

import java.util.ArrayList;
import java.util.List;

public class AdvanceAnimActivity extends AppCompatActivity {

    private ViewPager animationVp;
    private FragmentManager supportFragmentManager;
    private List<Fragment> fragments = new ArrayList<>();
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_anim);

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();
        fiveFragment = new FiveFragment();

        fragments.add(oneFragment);
        fragments.add(twoFragment);
        fragments.add(threeFragment);
        fragments.add(fourFragment);
        fragments.add(fiveFragment);

        animationVp = (ViewPager) findViewById(R.id.animation_vp);
        animationVp.setAdapter(new AnimationAdapter(getSupportFragmentManager(), fragments));
        animationVp.setCurrentItem(0);

        animationVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("caicai", position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class AnimationAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList<>();

        public AnimationAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
