package com.caicai.criminalintent.designobserver.projectobserver.controller;

import com.caicai.criminalintent.designobserver.projectobserver.ViewPage;

/**
 * @Author : caicai
 * @Time : 2016/4/20 15:32
 * @Description: 作为被观察者的逻辑
 */
public interface Controller {

    /**
     * 注册View
     * @param view
     */
    void registerView(ViewPage view);

    void unRegisterView(ViewPage view);

    void notifyChange(Object object);
}
