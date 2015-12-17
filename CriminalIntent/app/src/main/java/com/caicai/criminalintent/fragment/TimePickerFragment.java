package com.caicai.criminalintent.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import com.caicai.criminalintent.Config;
import com.caicai.criminalintent.R;

import java.sql.Time;

/**
 * @Author : caicai
 * @Time : 2015/12/15 11:13
 * @Description: 请用一句话描述
 */
public class TimePickerFragment extends DialogFragment {

    private Time mTime;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mTime = (Time) getArguments().getSerializable(Config.TIME_PICKER_TRANS);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_time_picker, null);
        TimePicker tp = (TimePicker) view.findViewById(R.id.dialog_timepicker);

//        TimePicker tp = new TimePicker(getActivity());

        return new AlertDialog.Builder(getActivity())
                .setView(tp)
                .setTitle("time")
                .setPositiveButton("en", null)
                .create();
    }

    public static TimePickerFragment getInstance(Time time) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Config.TIME_PICKER_TRANS, time);
        TimePickerFragment timeFragment = new TimePickerFragment();
        timeFragment.setArguments(bundle);

        return timeFragment;
    }
}
