package com.caicai.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author : caicai
 * Time : 2015/12/9 11:24
 * Description:CriminalFragment
 */
public class CriminalFragment extends Fragment {

    private Criminal mCriminal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCriminal = new Criminal();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_criminal, container, false);
        return view;
    }
}
