package com.caicai.criminalintent.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Author : caicai
 * @Time : 2016/8/27 17:57
 * @Description: 请用一句话描述
 */
public class InstallAndUnstall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            Log.e("caicai", "程序安装");
        } else if (Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
            Log.e("caicai", "卸载了");
        }
    }
}
