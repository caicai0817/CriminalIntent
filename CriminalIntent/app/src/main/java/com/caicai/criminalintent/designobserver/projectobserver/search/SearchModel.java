package com.caicai.criminalintent.designobserver.projectobserver.search;

import com.caicai.criminalintent.designobserver.projectobserver.bean.Detail58Bean;
import com.caicai.criminalintent.designobserver.projectobserver.bean.OtherBean;
import com.caicai.criminalintent.designobserver.projectobserver.bean.UpdateBean;
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
    private UpdateBean mUpdateBean;
    private Detail58Bean mDetailBean;
    private OtherBean mOtherBean;

    private Gson gson;

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
        gson = new Gson();
    }

    void setSearchResultObject(int type, Object object) {
        mResults[type] = object;
        if (type == ResultKey.MINE) {

            //根据需求添加到缓存
            //addToCache((UpdateBean) object, mResults[ResultKey.MINE]);
        }
    }

    /**
     * 获取搜索结果对象
     */
    Object getSearchResultObject(int type) {
        return mResults[type];
    }

    /**
     * 获取搜索结果字符串
     */
    String getSearchReuslt(int type) {
        return mSearchResults[type];
    }

    @Override
    public void onGetResult(int flag, String json) {

        switch (flag) {
            case ResultKey.ERROR:
                notifyObservers(ResultKey.ERROR);
                break;
            case ResultKey.MINE:
                    mUpdateBean = gson.fromJson(json, UpdateBean.class);
                    mSearchResults[ResultKey.MINE] = json;
                    mResults[ResultKey.MINE] = mUpdateBean;
                    notifyObservers(ResultKey.MINE);
                break;
            case ResultKey.HOME:
                    mDetailBean = gson.fromJson(json, Detail58Bean.class);
                    mSearchResults[ResultKey.HOME] = json;
                    mResults[ResultKey.HOME] = mDetailBean;
                    notifyObservers(ResultKey.HOME);
                break;
            case ResultKey.MESSAGE:
                    mOtherBean = gson.fromJson(json, OtherBean.class);
                    mSearchResults[ResultKey.MESSAGE] = json;
                    mResults[ResultKey.MESSAGE] = mOtherBean;
                    notifyObservers(ResultKey.MESSAGE);
                break;
            case ResultKey.SQUARE:
                    mOtherBean = gson.fromJson(json, OtherBean.class);
                    mSearchResults[ResultKey.SQUARE] = json;
                    mResults[ResultKey.SQUARE] = mOtherBean;
                    notifyObservers(ResultKey.SQUARE);
                break;
            case ResultKey.EXTENDS:
                    mOtherBean = gson.fromJson(json, OtherBean.class);
                    mSearchResults[ResultKey.EXTENDS] = json;
                    mResults[ResultKey.EXTENDS] = mOtherBean;
                    notifyObservers(ResultKey.EXTENDS);
                break;
        }
    }

    @Override
    public void notifyObservers(Object data) {
        setChanged();
        super.notifyObservers(data);
    }
}
