package com.caicai.criminalintent.designobserver.myObserver;

/**
 * @Author : caicai
 * @Time : 2016/4/26 15:15
 * @Description: 观察者
 */
public interface MObserver {

    //气象发生变化时,主题吧这些状态值当做方法的参数,传递给观察者
    void update(float temp,float humidity,float pressure);
}
