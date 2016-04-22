package com.caicai.criminalintent.designobserver.projectobserver;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

public abstract class VolleyInterface<T> {
    public Context context;
    public Listener<T> successListener;
    public ErrorListener errorListener;

    public VolleyInterface(Context context) {
        this.context = context;
    }

    public abstract void onMySuccess(T result);

    public abstract void onMyError(VolleyError error);

    /**
     * 请求成功的监听
     *
     * @return
     */
    public Listener<T> successListener() {
        successListener = new Listener<T>() {

            @Override
            public void onResponse(T response) {
                // 弹出Loading对话框
                onMySuccess(response);
            }
        };
        return successListener;
    }

    /**
     * 请求失败的监听
     *
     * @return
     */
    public ErrorListener errorListener() {
        errorListener = new ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // 提示请求失败
                onMyError(error);
            }
        };
        return errorListener;
    }

}
