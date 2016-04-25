package com.caicai.criminalintent.designobserver.projectobserver.controller;

import android.os.Handler;
import android.os.Looper;

import com.caicai.criminalintent.designobserver.projectobserver.ViewPage;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author : caicai
 * @Time : 2016/4/20 15:31
 * @Description: 连接页面和网络的中介
 */
public class BaseController extends Observable implements Observer, Controller {

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    @Override
    public void registerView(ViewPage view) {
        addObserver(view);
    }

    @Override
    public void unRegisterView(ViewPage view) {
        deleteObserver(view);
    }

    @Override
    public void notifyChange(final Object obj) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    changed(obj);
                }
            });
        } else {
            changed(obj);
        }
    }

    private void changed(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

    /**
     * 网络消息结果处理
     * @param observable
     * @param obj
     */
    @Override
    public void update(Observable observable, Object obj) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
