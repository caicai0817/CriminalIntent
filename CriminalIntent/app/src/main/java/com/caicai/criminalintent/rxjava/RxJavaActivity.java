package com.caicai.criminalintent.rxjava;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.caicai.criminalintent.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView rxJava;
    private TextView rxJava1;
    private ImageView iv;
    private TextView retrofitTv;
    private TextView retrofitTv1;
    private TextView br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        rxJava = (TextView) findViewById(R.id.rxjava_tv);
        rxJava.setOnClickListener(this);
        rxJava1 = (TextView) findViewById(R.id.rxjava_tv1);
        rxJava1.setOnClickListener(this);
        iv = (ImageView) findViewById(R.id.rxjava_iv);

        retrofitTv = (TextView) findViewById(R.id.retrofit);
        retrofitTv1 = (TextView) findViewById(R.id.retrofit1);
        retrofitTv.setOnClickListener(this);

        br = (TextView) findViewById(R.id.receiver);
        br.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rxjava_tv://打印字符串数组
                String[] names = {"caicai", "xiaobai", "qianxi", "wangjunkai", "wangyuan"};
                Observable.from(names).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("caicai", s);
                    }
                });
                break;
            case R.id.rxjava_tv1://显示图片
                final int drawable = R.drawable.icon_home;
                Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        Drawable drawable1 = getDrawable(drawable);
                        subscriber.onNext(drawable1);
                        subscriber.onCompleted();
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Drawable>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("caicai", "tupiancuowu");
                            }

                            @Override
                            public void onNext(Drawable drawable) {
                                iv.setImageDrawable(drawable);
                            }
                        });

                break;
            case R.id.retrofit:
                getMovies();
                break;
            case R.id.receiver:
                Intent intent = new Intent("caicai");
                sendOrderedBroadcast(intent, null, null, null, 0, "中国古代史", null);
                break;
        }
    }

    private void getMovies() {
        String baseUrl = "http://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<MovieEntity> call = movieService.getTopMoview(0, 10);
        call.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                retrofitTv1.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                retrofitTv1.setText(t.toString());
            }
        });
    }

    public interface MovieService {
        @GET("top250")
        Call<MovieEntity> getTopMoview(@Query("start") int start, @Query("count") int count);
    }
}
