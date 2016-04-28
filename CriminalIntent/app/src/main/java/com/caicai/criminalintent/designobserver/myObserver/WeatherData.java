package com.caicai.criminalintent.designobserver.myObserver;

import java.util.ArrayList;

/**
 * @Author : caicai
 * @Time : 2016/4/26 15:24
 * @Description: 请用一句话描述
 */
public class WeatherData implements Subject {//  extends Observable

    private ArrayList<MObserver> observers;
    private float temp;
    private float humidity;
    private float pressure;

    //在构造器中简历集合,记录观察者
    public WeatherData() {
        observers = new ArrayList<MObserver>();
    }

    //注册观察者时,加到observers后面
    @Override
    public void registerObserver(MObserver observer) {
        observers.add(observer);
    }

    //观察者取消注册,从observers中移除
    @Override
    public void unRegisterObserver(MObserver observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    //把状态通知给每个观察者
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            MObserver mObserver = observers.get(i);
            mObserver.update(temp,humidity,pressure);
        }
    }

    //在气象站获取到数据
    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }

    private void measurementsChanged() {
//        setChanged();
        notifyObservers();
    }

    /*//使用拉的方式获取数据
    public float getTemp(){
        return temp;
    }
    //使用拉的方式获取数据
    public float getHumidity(){
        return humidity;
    }
    //使用拉的方式获取数据
    public float getPressure(){
        return pressure;
    }*/
}
