package com.caicai.criminalintent.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Author : caicai
 * @Time : 2016/8/31 14:24
 * @Description: 请用一句话描述
 */
public class LevelReserver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = getResultData();
        Log.e("caicai", "reserver2获取数据为" + data);
        setResultData("宋太祖");
    }
}
