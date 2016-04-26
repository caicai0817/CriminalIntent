package com.caicai.criminalintent.designobserver.projectobserver.search;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Map;

/**
 * @Author : caicai
 * @Time : 2016/4/20 17:18
 * @Description: 网络搜索
 */
public enum Searcher {
    INSTANCE;

    private SearcherListener mSearcherListener;

    public void requestByPost(Context context, final String url, String tag,
                              final Map<String, String> params, final int flag) {
        VolleyRequest.RequestByPost(context, url, tag, params, new VolleyInterface<JSONObject>(context) {
            @Override
            public void onMySuccess(JSONObject result) {
                if (TextUtils.isEmpty(result.toString())) {
                    mSearcherListener.onGetResult(ResultKey.ERROR, null);
                    Toast.makeText(context, "return null ------", Toast.LENGTH_SHORT);
                } else {
                    mSearcherListener.onGetResult(flag, result.toString());

                }
            }

            @Override
            public void onMyError(VolleyError error) {
                mSearcherListener.onGetResult(ResultKey.ERROR, null);
                Toast.makeText(context, "return error !!!!!!!!", Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 设置网络数据回调监听
     *
     * @param mSearcherListener
     */
    public void setSearcherListener(
            SearcherListener mSearcherListener) {
        this.mSearcherListener = mSearcherListener;
    }

    /**
     * 网络数据回调
     *
     * @author Administrator
     */
    public interface SearcherListener {
        void onGetResult(int flag, String json);
    }

}
