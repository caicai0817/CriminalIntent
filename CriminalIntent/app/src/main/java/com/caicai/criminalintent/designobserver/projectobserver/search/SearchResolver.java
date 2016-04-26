package com.caicai.criminalintent.designobserver.projectobserver.search;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author : caicai
 * @Time : 2016/4/20 16:41
 * @Description: 注册到被观察者
 */
public final class SearchResolver {

    private static SearchResolver mInstance;

    private SearchResolver() {
    }

    public static SearchResolver getInstance() {
        if (mInstance == null) {
            mInstance = new SearchResolver();
        }

        return mInstance;
    }

    /**
     * 注册监听者
     * @param observer 要注册的监听者需要实现Observer
    */
    public void regSearchModel(Observer observer) {
        SearchModel.getInstance().addObserver(observer);
    }

    /**
     * 取消监听注册
     * @param observer 要取消注册的监听者
     */
    public void unRegSearchModel(Observer observer) {
        SearchModel.getInstance().deleteObserver(observer);
    }

    /**
     * 获得SearchModel的实例
     *
     * @return SearchModel实例
     */
    public Observable getSearchModelInstance() {
        return SearchModel.getInstance();
    }

    /**
     * 查询对应搜索类型的搜索结果
     * @param searchType 搜索结果类型，
     * @return 对应搜索类型的搜索结果
     */
    public Object querySearchResult(int searchType) {

//        if (RESULT_TYPE_OBJ == formatType) {
            return SearchModel.getInstance().getSearchResultObject(searchType);

//        return SearchModel.getInstance().getSearchReuslt(searchType);
    }

    /**
     * 查询搜索结果
     *
     * @param searchType 搜索结果类型，
     * @return
     */
    public String querySearchResultCache(int searchType) {
        String key = SearchModel.getInstance().getSearchReuslt(searchType);
        return key != null ? key : null;
    }
}
