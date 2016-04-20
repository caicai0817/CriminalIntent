package com.caicai.criminalintent.designobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.caicai.criminalintent.R;

import java.util.Observable;

public class ObserverActivity extends AppCompatActivity {

    private DataWhatcher watcher = new DataWhatcher() {

        @Override
        public void update(Observable observable, Object data) {
            super.update(observable, data);
            //观察者接受到被观察者的通知，来更新自己的数据操作。
            Data mData = (Data)data;
            Log.i("Test", "mData---->>" + mData.getDataChange());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        //模拟被观察者数改变,更新数据

        Data data = new Data();
        data.setDataChange(0);
        DataChange.getInstance().notifyDataChange(data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //观察者往被观察者中添加订阅事件。
        DataChange.getInstance().addObserver(watcher);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //观察者从被观察者队列中移除
        DataChange.getInstance().deleteObserver(watcher);
    }

}
