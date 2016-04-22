package com.caicai.criminalintent.designobserver.projectobserver;

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
     * @param observer 要注册的监听者(需要实现{@link Observer})
     */
    public void regSearchModel(Observer observer) {
        SearchModel.getInstance().addObserver(observer);
    }

    /**
     * 取消监听注册
     * @param observer 要取消注册的监听者(需要实现{@link Observer})
     */
    public void unRegSearchModel(Observer observer) {
        SearchModel.getInstance().deleteObserver(observer);
    }

    /**
     * 获得SearchModel的实例
     *
     * 发现有部分代码需要得到SearchModel实例，所以提供这个方法
     * @return SearchModel实例
     */
    public Observable getSearchModelInstance() {
        return SearchModel.getInstance();
    }

    /**
     * 查询对应搜索类型的搜索结果
     * 注意，此函数已经废弃。此函数用于获取旧检索实体。在新PB检索中，以无旧检索实体。</p>
     * 请使用querySearchResultCache(int)} 获取到Cache.Item，内部可以分别获取到新旧实体和ResultType
     * @param searchType 搜索结果类型，
     *                   可选参数参考{@link ResultKey}类
     * @param formatType 输出结果格式，支持json和对象,
     *                   可选参数 {@link SearchResolver}和{@link SearchResolver}
     * @return 对应搜索类型的搜索结果
     */
    @Deprecated
    public Object querySearchResult(int searchType, int formatType) {

//        if (RESULT_TYPE_OBJ == formatType) {
            return SearchModel.getInstance().getSearchResultObject(searchType);

//        return SearchModel.getInstance().getSearchReuslt(searchType);
    }

    /**
     * 查询搜索结果
     *
     * @param searchType 搜索结果类型，
     *                   可选参数参考{@link ResultKey}类
     * @return
     */
    public String querySearchResultCache(int searchType) {
        String key = SearchModel.getInstance().getSearchReuslt(searchType);
        return key != null ? key : null;
    }
}
