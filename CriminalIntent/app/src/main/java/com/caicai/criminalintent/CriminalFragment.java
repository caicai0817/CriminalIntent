package com.caicai.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Author : caicai
 * Time : 2015/12/9 11:24
 * Description:CriminalFragment
 */
public class CriminalFragment extends Fragment implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText criminalTitle;
    private Button desButton;
    private CheckBox solvedCheckBox;


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

        criminalTitle = (EditText) view.findViewById(R.id.fragment_criminal_title);
        criminalTitle.addTextChangedListener(this);

        desButton = (Button) view.findViewById(R.id.fragment_criminal_desription);
        desButton.setText(mCriminal.getmData());
        desButton.setOnClickListener(this);

        solvedCheckBox = (CheckBox) view.findViewById(R.id.fragment_criminal_solved);
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
}
