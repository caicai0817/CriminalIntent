package com.caicai.criminalintent.designobserver.myObserver;

import android.util.Log;

/**
 * @Author : caicai
 * @Time : 2016/4/26 15:39
 * @Description: 请用一句话描述
 */
public class Forecastdisplay implements MObserver, DisplayElement {// Observer
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;// Observable

    //注册观察者
    public Forecastdisplay(Subject weatherData) {// Observable
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
//        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        Log.e("caicai", "forecast: temp:" + temp + "--humidity:" + humidity + "--pressure:" + pressure);
    }

    /*@Override
    public void update(Observable observable, Object data) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }*/

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
