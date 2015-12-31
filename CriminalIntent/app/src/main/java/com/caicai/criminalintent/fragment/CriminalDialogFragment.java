package com.caicai.criminalintent.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;

import com.caicai.criminalintent.config.Config;
import com.caicai.criminalintent.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author : caicai
 * @Time : 2015/12/12 14:53
 * @Description: 日期对话框
 */
public class CriminalDialogFragment extends DialogFragment implements DatePicker.OnDateChangedListener {
    private Date mDate;
    private DatePicker view;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDate = (Date) getArguments().getSerializable(Config.ITEM_TIME_TRANS);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);

        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //在dialog中添加datepicker的布局
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
        view = (DatePicker) v.findViewById(R.id.dialog_date_datepicker);


        //在代码中实现datepicker的布局
//        DatePicker view = new DatePicker(getActivity());
//        view.setCalendarViewShown(false);

        view.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
                getArguments().putSerializable(Config.ITEM_TIME_TRANS, mDate);
            }
        });

//        DatePickerDialog dialog = new DatePickerDialog(getActivity(), R.style.MyCalendarView, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
//                getArguments().putSerializable(Config.ITEM_TIME_TRANS, mDate);
//            }
//        }, view.getYear(), view.getMonth(), view.getDayOfMonth());
//
//        dialog.create();
//
//        return dialog;

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.dialog_fragment_date)
                .setPositiveButton(R.string.dialog_fragment_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDateChanged(view, view.getYear(), view.getMonth(), view.getDayOfMonth());
                    }
                })
                .create();

    }

    /**
     * dialogfragment向criminal传递数据
     *
     * @param resultOk
     */
    private void send2target(int resultOk) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(Config.ITEM_TIME_TRANS, mDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultOk, intent);
    }

    /**
     * criminal向dialog传递数据
     *
     * @param date
     * @return
     */
    public static CriminalDialogFragment getInstance(Date date) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Config.ITEM_TIME_TRANS, date);

        CriminalDialogFragment fragment = new CriminalDialogFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    /**
     * android5.0ondateChanged方法不调用的解决
     *
     * @param view
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     */
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
        getArguments().putSerializable(Config.ITEM_TIME_TRANS, mDate);
        send2target(Activity.RESULT_OK);
    }
}
