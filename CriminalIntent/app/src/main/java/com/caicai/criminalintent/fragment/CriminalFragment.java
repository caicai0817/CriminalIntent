package com.caicai.criminalintent.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.caicai.criminalintent.config.Config;
import com.caicai.criminalintent.model.Criminal;
import com.caicai.criminalintent.model.CriminalLab;
import com.caicai.criminalintent.R;
import com.caicai.criminalintent.util.utils;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Author : caicai
 * Time : 2015/12/9 11:24
 * Description:CriminalFragment
 */
public class CriminalFragment extends Fragment implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText criminalTitle;
    private Button desButton;
    private Button timePickerButton;
    private Button oneButton;
    private CheckBox solvedCheckBox;
    private Time mTime;

    private static final String DIALOG_DTAE = "date";


    private Criminal mCriminal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCriminal = new Criminal();

//        Intent intent = getActivity().getIntent();
//        if (intent != null) {
//            UUID uuid = (UUID) intent.getSerializableExtra(Config.ITEM_FLAG);
//            mCriminal = CriminalLab.getsCriminalLab().getCriminalByUUID(uuid);
//        }

        UUID criminalId = (UUID) getArguments().getSerializable(Config.ITEM_FLAG);

        mCriminal = CriminalLab.getsCriminalLab().getCriminalByUUID(criminalId);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_criminal, container, false);

        criminalTitle = (EditText) view.findViewById(R.id.fragment_criminal_title);
        criminalTitle.setText(mCriminal.getmTitle());
        criminalTitle.addTextChangedListener(this);

        desButton = (Button) view.findViewById(R.id.fragment_criminal_desription);
        desButton.setText(utils.getFormatDate(mCriminal.getmData()));
        desButton.setOnClickListener(this);

        timePickerButton = (Button) view.findViewById(R.id.fragment_criminal_timepicker);
        timePickerButton.setOnClickListener(this);

        oneButton = (Button) view.findViewById(R.id.exercise_one_button);
        oneButton.setOnClickListener(this);

        solvedCheckBox = (CheckBox) view.findViewById(R.id.fragment_criminal_solved);
        solvedCheckBox.setChecked(mCriminal.isSolved());
        solvedCheckBox.setOnCheckedChangeListener(this);
        return view;
    }

    /**
     * criminal的textchangelistener
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /**
     * criminal的textchangelistener
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * criminal的textchangelistener
     */
    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_criminal_desription:

                FragmentManager fm = getActivity().getSupportFragmentManager();
//                CriminalDialogFragment dialog = new CriminalDialogFragment();

                CriminalDialogFragment dialog = CriminalDialogFragment.getInstance(mCriminal.getmData());

                //将criminalfragment设为criminaldialogfragment的目标
                dialog.setTargetFragment(CriminalFragment.this,Config.DIALOG2CRIMINAL_REQUEST);

                dialog.show(fm,DIALOG_DTAE);

                break;

            case R.id.fragment_criminal_timepicker:

                android.app.FragmentManager fragmentManager = getActivity().getFragmentManager();

                TimePickerFragment timeDialog = TimePickerFragment.getInstance(mTime);

//                timeDialog.setTargetFragment(CriminalFragment.this,Config.TIME_PICKER_REQUEST);

                timeDialog.show(fragmentManager,"show");

                break;

            case R.id.exercise_one_button:
                new AlertDialog.Builder(getActivity()).setPositiveButton("date", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentManager fm = getActivity().getSupportFragmentManager();

                        CriminalDialogFragment criminaldialog = CriminalDialogFragment.getInstance(mCriminal.getmData());

                        criminaldialog.setTargetFragment(CriminalFragment.this,Config.DIALOG2CRIMINAL_REQUEST);

                        criminaldialog.show(fm,DIALOG_DTAE);
                    }
                }).setNeutralButton("time", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.app.FragmentManager fragmentManager = getActivity().getFragmentManager();

                        TimePickerFragment timeDialog = TimePickerFragment.getInstance(mTime);

                        timeDialog.show(fragmentManager,"show");
                    }
                }).create().show();

                break;
        }
    }

    /**
     * checkbox 切换监听事件
     *
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCriminal.setIsSolved(isChecked);
    }

    public static CriminalFragment getInstance(UUID criminalId) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Config.ITEM_FLAG, criminalId);


        CriminalFragment fragment = new CriminalFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    /**
     * 接收从dialogfragment传递过来的参数
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
      if (resultCode != Activity.RESULT_OK){
          return;
      }

        if (requestCode == Config.DIALOG2CRIMINAL_REQUEST){
            Date date = (Date) data.getSerializableExtra(Config.ITEM_TIME_TRANS);
            mCriminal.setmData(date);

            desButton.setText(utils.getFormatDate(mCriminal.getmData()));
        }
    }
}
