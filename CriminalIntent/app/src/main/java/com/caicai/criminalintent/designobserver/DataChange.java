//package com.caicai.criminalintent.designobserver;
//
//import java.util.Observable;
//
///**
// * @Author : caicai
// * @Time : 2016/4/19 17:47
// * @Description: 被观察者
// */
//public class DataChange extends Observable{
//    private static DataChange instance = null;
//    public static DataChange getInstance(){
//        if (null == instance){
//            instance = new DataChange();
//        }
//        return instance;
//    }
//
//    public void notifyDataChange(Data data){
//        //被观察者怎么通知观察者数据有变化了 这两个方法之关键
//        setChanged();
//        notifyDataChange(data);
//    }
//}
