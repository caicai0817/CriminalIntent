package com.caicai.criminalintent.designobserver.projectobserver;

import java.util.Observable;

/**
 * @Author : caicai
 * @Time : 2016/4/20 16:32
 * @Description: 详情页controller
 */
public class DetailController extends BaseController{

    /**
     * 将DetailController注册为SearchModel的观察者
     */
    public void registSearchModel(){
        SearchResolver.getInstance().regSearchModel(this);
    }

    /**
     * 将DetailController和SearchModel断开
     */
    public void unRegistSearchModel(){
        SearchResolver.getInstance().unRegSearchModel(this);
    }

    /**
     * 将页面注册为DetailController的观察者
     */
    @Override
    public void registerView(ViewPage view) {
        addObserver(view);
    }

    /**
     * 将页面和DetailController断开
     */
    @Override
    public void unRegisterView(ViewPage view) {
        deleteObserver(view);
    }

    /**
     * SearchModel的结果上报
     * @param observable
     * @param obj
     */
    @Override
    public void update(Observable observable, Object obj) {
        //通知View层
        this.notifyChange(obj);
    }
}
