package com.caicai.criminalintent.design;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.Window;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Caicai.
 * @date 2018/4/20.
 * @description 单一职责原则
 */

public class ImageLoader {
    LruCache<String,Bitmap> imagCache;
    ExecutorService mExecutorService =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader(){
        initImageCache();
    }

    private void initImageCache() {
        //可使用的最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        //取1/4作为缓存
        int cacheSize = maxMemory / 4;

        imagCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void displayImage(final String url, final ImageView imageView){
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = download(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
                imagCache.put(url,bitmap);
            }
        });
    }

    public Bitmap download(String imageUrl){
        Bitmap bitmap = null;
        try{
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();


        }catch (Exception e){
            e.printStackTrace();
        }

        return bitmap;
    }

}
