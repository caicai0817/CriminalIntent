package com.caicai.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author : caicai
 * @Time : 2015/12/12 14:53
 * @Description: 日期对话框
 */
public class CriminalDialogFragment extends DialogFragment {
    private Date mDate;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDate = (Date) getArguments().getSerializable(Config.ITEM_TIME_TRANS);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //在dialog中添加datepicker的布局
//        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);

        //在代码中实现datepicker的布局
        DatePicker view = new DatePicker(getActivity());
        view.setCalendarViewShown(false);
//
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.dialog_fragment_date)
                .setPositiveButton(R.string.dialog_fragment_ok, null)
                .create();
    }

    public static CriminalDialogFragment getInstance(Date date){
        Bundle bundle = new Bundle();
        bundle.putSerializable(Config.ITEM_TIME_TRANS, date);

        CriminalDialogFragment fragment = new CriminalDialogFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
}
