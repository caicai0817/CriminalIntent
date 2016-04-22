package com.caicai.criminalintent.designobserver.projectobserver;

import com.google.gson.Gson;

import java.util.Observable;

/**
 * @Author : caicai
 * @Time : 2016/4/20 16:43
 * @Description: 搜索model
 */
public class SearchModel extends Observable implements Searcher.SearcherListener {

    private static SearchModel sSearchModel = null;

    //存储String
    private String[] mSearchResults = null;
    //存储json对象
    private Object[] mResults = null;
    //搜索错误的业务
    private int mErrorSearchType = 0;
    //错误码
    private int mErrorNo = 0;
    private UpdateBean mUpdateBean;
    private Detail58Bean mDetailBean;

    public static SearchModel getInstance() {
        if (sSearchModel == null) {
            sSearchModel = new SearchModel();
        }

        return sSearchModel;
    }

    private SearchModel() {
        mSearchResults = new String[32];
        mResults = new Object[32];
        Searcher.INSTANCE.setSearcherListener(this);
    }


    void setSearchReuslt(int type, String searchResult) {
        mSearchResults[type] = searchResult;
    }

    void setSearchResultObject(int type, Object object) {
        mResults[type] = object;
        if (type == ResultKey.ABTEST) {

            //根据需求添加到缓存
            //addToCache((ABTestBean) object, mResults[ResultKey.ABTEST]);
        }
    }

    /**
     * 获取搜索结果对象
     *
     * @param type 搜索结果类型
     * @return 搜索结果对象
     */
    Object getSearchResultObject(int type) {
        return mResults[type];
    }

    /**
     * 获取搜索结果字符串
     *
     * @param type 搜索结果类型
     * @return　搜索结果
     */
    String getSearchReuslt(int type) {
        return mSearchResults[type];
    }

    /**
     * 获取错误号
     *
     * @return 错误号
     */
    int getError() {
        return mErrorNo;
    }

    /**
     * 获取搜索模块发生错误时, 所进行的业务类型.
     *
     * @return 搜索模块发生错误时, 所进行的业务类型.
     */
    int getErrorSearchType() {
        return mErrorSearchType;
    }

    @Override
    public void onGetResult(int flag, String json) {

        switch (flag) {
            case ResultKey.ERROR:
                notifyObservers(ResultKey.ERROR);
                break;
            case ResultKey.ABTEST:
                try {
//                    JsonParser.setJson2Obj(mUpdateBean, json);
                    Gson gson = new Gson();
                    mUpdateBean = gson.fromJson(json, UpdateBean.class);
                    mSearchResults[ResultKey.ABTEST] = json;
                    mResults[ResultKey.ABTEST] = mUpdateBean;
                    notifyObservers(ResultKey.ABTEST);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ResultKey.DETAIL58:
                try {
//                    JsonParser.setJson2Obj(mUpdateBean, json);
                    Gson gson = new Gson();
                    mDetailBean = gson.fromJson(json, Detail58Bean.class);
                    mSearchResults[ResultKey.DETAIL58] = json;
                    mResults[ResultKey.DETAIL58] = mDetailBean;
                    notifyObservers(ResultKey.DETAIL58);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void notifyObservers(Object data) {
        setChanged();
        super.notifyObservers(data);
    }
}
