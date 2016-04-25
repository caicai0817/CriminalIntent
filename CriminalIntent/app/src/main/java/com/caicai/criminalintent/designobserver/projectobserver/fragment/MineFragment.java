package com.caicai.criminalintent.designobserver.projectobserver.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.designobserver.projectobserver.controller.DetailController;
import com.caicai.criminalintent.designobserver.projectobserver.search.ResultKey;
import com.caicai.criminalintent.designobserver.projectobserver.search.SearchResolver;
import com.caicai.criminalintent.designobserver.projectobserver.search.Searcher;
import com.caicai.criminalintent.designobserver.projectobserver.bean.UpdateBean;
import com.caicai.criminalintent.designobserver.projectobserver.ViewPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class MineFragment extends Fragment implements ViewPage {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private DetailController mDetailController = new DetailController();

    private View view;
    private TextView showView;

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MineFragment() {
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

        Map<String, String> params = new HashMap<String, String>();
        params.put("imei", "867323023729559");
        params.put("medel", "MI4LTE");
        params.put("deviceName", "Xiaomi MI");
        params.put("osVersion", "4.4.4");
        Searcher.INSTANCE.requestByPost(getActivity(), "http://sptrack.58supin.com/app/update", null, params, ResultKey.MINE);


        view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showView = (TextView) view.findViewById(R.id.mine_tv);

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
                break;
            case ResultKey.MINE:
                UpdateBean bean = (UpdateBean) SearchResolver.getInstance().querySearchResult(ResultKey.MINE, 0);
                showView.setText(bean.version);
                break;
        }
    }
}
