package com.caicai.criminalintent.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Author : caicai
 * @Time : 2016/8/27 17:00
 * @Description: 请用一句话描述
 */
public class CallReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("caicai","call");
        String resultData = getResultData();
        int resultCode = getResultCode();
    }
}
