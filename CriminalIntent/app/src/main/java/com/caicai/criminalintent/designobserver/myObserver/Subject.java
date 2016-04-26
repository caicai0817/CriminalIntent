package com.caicai.criminalintent.designobserver.myObserver;

/**
 * @Author : caicai
 * @Time : 2016/4/26 15:13
 * @Description: 主题接口
 */
public interface Subject {

    //注册观察者
    void registerObserver(MObserver observer);
    //移除观察者
    void unRegisterObserver(MObserver observer);
    //通知观察者
    void notifyObservers();
}
