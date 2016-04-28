package com.caicai.criminalintent.designobserver.projectobserver.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.designobserver.projectobserver.ExtendsActivity;
import com.caicai.criminalintent.designobserver.projectobserver.ViewPage;
import com.caicai.criminalintent.designobserver.projectobserver.bean.Detail58Bean;
import com.caicai.criminalintent.designobserver.projectobserver.controller.DetailController;
import com.caicai.criminalintent.designobserver.projectobserver.search.ResultKey;
import com.caicai.criminalintent.designobserver.projectobserver.search.SearchResolver;
import com.caicai.criminalintent.designobserver.projectobserver.search.Searcher;

import java.util.Observable;

public class HomeFragment extends Fragment implements ViewPage {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private DetailController mDetailController = new DetailController();

    private View view;
    private TextView showView;


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Searcher.INSTANCE.requestByPost(getActivity(), "http://10.252.153.60:8080/home.txt", "home", null, ResultKey.HOME);

        view = View.inflate(getActivity(), R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showView = (TextView) view.findViewById(R.id.home_tv);
        showView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtendsActivity.class));
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        mDetailController.registerView(this);
        mDetailController.registSearchModel();
    }

    @Override
    public void onPause() {
        super.onPause();
        // 将page和Controller断开
        mDetailController.unRegisterView(this);
        // 将SearchModel和Controller断开
        mDetailController.unRegistSearchModel();
    }

    @Override
    public void update(Observable observable, Object data) {

        switch (Integer.parseInt(data.toString())) {
            case ResultKey.ERROR:
                showView.setText("404");
                break;
            case ResultKey.HOME:
                Detail58Bean bean = (Detail58Bean) SearchResolver.getInstance().querySearchResult(ResultKey.HOME);
                showView.setText(bean.caicai);
                break;
        }
    }
}
