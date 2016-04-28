package com.caicai.criminalintent.designobserver.projectobserver.search;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.caicai.criminalintent.App;

import java.util.HashMap;
import java.util.Map;

public class VolleyRequest {
    public static Request stringRequest;
    public static Context context;


    public static void RequestByPost(Context context, String url, String tag,
                                     final Map<String, String> params, VolleyInterface volleyInterface) {
        App.getHttpRequest().cancelAll(tag);
        stringRequest = new JsonObjectRequest(Method.POST, url,
                volleyInterface.successListener(),
                volleyInterface.errorListener()) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return setHeaders();
            }

            @Override
            public RetryPolicy getRetryPolicy() {

                RetryPolicy retryPolicy = new DefaultRetryPolicy(20000, 0, 2.0f);
                return retryPolicy;
            }

        };
        System.setProperty("http.keepAlive", "false");
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000, 0, 2.0f));
        stringRequest.setTag(tag);
        stringRequest.setShouldCache(false);
        App.getHttpRequest().add(stringRequest);
        //volley本身已初始化过
        //AppApplication.getHttpRequest().start();
    }

    /**
     * 设置请求头
     */
    private static Map<String, String> setHeaders() {
        Map<String, String> headers = new HashMap<String, String>(4);
        // 具体设置
        return headers;
    }
}
