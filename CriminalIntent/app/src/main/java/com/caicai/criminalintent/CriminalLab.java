package com.caicai.criminalintent;

import java.util.ArrayList;

/**
 * Author : caicai
 * Time : 2015/12/10 09:41
 * Description:criminal的管理仓库,单例模式
 */
public class CriminalLab {

    private ArrayList<Criminal> mCriminals;

    //单例模式
    private static CriminalLab sCriminalLab;

    private CriminalLab() {
        mCriminals = new ArrayList<Criminal>();

        //初始化数据
        for (int i = 0; i < 100; i++) {
            Criminal criminal = new Criminal();
            criminal.setmTitle("Criminal # " + i);
            criminal.setIsSolved(i % 2 == 0);
            mCriminals.add(criminal);
        }
    }

    public static CriminalLab getsCriminalLab() {
        if (sCriminalLab == null) {
            sCriminalLab = new CriminalLab();
        }
        return sCriminalLab;
    }

    public ArrayList<Criminal> getmCriminals() {
        return mCriminals;
    }
}
