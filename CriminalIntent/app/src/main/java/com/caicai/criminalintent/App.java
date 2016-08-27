package com.caicai.criminalintent;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.caicai.criminalintent.config.Config;
import com.easemob.chat.EMChat;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Iterator;
import java.util.List;

/**
 * @Author : caicai
 * @Time : 2015/12/23 10:50
 * @Description: application
 */
public class App extends Application {

    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化requestQueue对象
        requestQueue = Volley.newRequestQueue(this.getApplicationContext());

        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);

        // 如果app启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的app会在以包名为默认的process name下运行，如果查到的process name不是app的process name就立即返回

        if (processAppName == null || !processAppName.equalsIgnoreCase("com.caicai.criminalintent")) {
            Log.e(Config.TAG, "enter the service process!" + processAppName);
            //"com.easemob.chatuidemo"为demo的包名，换到自己项目中要改成自己包名
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }

        //fresco初始化
        Fresco.initialize(this);


        EMChat.getInstance().init(this);

        //debugMode == true 时为打开，sdk 会在log里输入调试信息,在做代码混淆的时候需要设置成false
        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源
    }

    //热修复
//    public String inject(String libPath) {
//
//        boolean hasBaseDexClassLoader = true;
//
//        try {
//
//            Class.forName("dalvik.system.BaseDexClassLoader");
//
//        } catch (ClassNotFoundException e) {
//
//            hasBaseDexClassLoader = false;
//
//        }
//
//        if (hasBaseDexClassLoader) {
//
//            PathClassLoader pathClassLoader = (PathClassLoader)getClassLoader();
//
//            DexClassLoader dexClassLoader = new DexClassLoader(libPath, getDir("dex", 0).getAbsolutePath(), libPath, getClassLoader());
//
//            try {
//
//                Object dexElements = combineArray(getDexElements(getPathList(pathClassLoader)), getDexElements(getPathList(dexClassLoader)));
//
//                Object pathList = getPathList(pathClassLoader);
//
//                setField(pathList, pathList.getClass(), "dexElements", dexElements);
//
//                return "SUCCESS";
//
//            } catch (Throwable e) {
//
//                e.printStackTrace();
//
//                return android.util.Log.getStackTraceString(e);
//
//            }
//
//        }
//
//        return "SUCCESS";
//
//    }

    /**
     * 获取进程名
     *
     * @param pID
     * @return
     */
    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }

    /**
     * 得到RequestQueue对象
     *
     * @return
     */
    public static RequestQueue getHttpRequest() {
        return requestQueue;
    }
}
