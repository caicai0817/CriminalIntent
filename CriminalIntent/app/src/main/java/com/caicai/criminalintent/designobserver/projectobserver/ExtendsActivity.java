package com.caicai.criminalintent.designobserver.projectobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.designobserver.projectobserver.bean.OtherBean;
import com.caicai.criminalintent.designobserver.projectobserver.controller.DetailController;
import com.caicai.criminalintent.designobserver.projectobserver.search.ResultKey;
import com.caicai.criminalintent.designobserver.projectobserver.search.SearchResolver;
import com.caicai.criminalintent.designobserver.projectobserver.search.Searcher;

import java.util.Observable;

public class ExtendsActivity extends AppCompatActivity implements ViewPage{
    private TextView showTv;
    private DetailController mDetailController = new DetailController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extends);
        showTv = (TextView) findViewById(R.id.extends_tv);

        Searcher.INSTANCE.requestByPost(this, "http://10.252.153.60:8080/extends.txt", "extends", null, ResultKey.EXTENDS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDetailController.registerView(this);
        mDetailController.registSearchModel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDetailController.unRegisterView(this);
        mDetailController.unRegistSearchModel();
    }

    @Override
    public void update(Observable observable, Object data) {
        switch (Integer.parseInt(data.toString())) {
            case ResultKey.ERROR:
                showTv.setText("404");
                break;
            case ResultKey.EXTENDS:
                OtherBean bean = (OtherBean) SearchResolver.getInstance().querySearchResult(ResultKey.EXTENDS);
                showTv.setText(bean.topic);
                break;
        }
    }
}
