package com.caicai.criminalintent.sourcedesign.optimize;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : caicai
 * @Time : 2016/6/28 10:52
 * @Description: 图片加载器
 */
public class ImageLoader {
    //图片缓存
    ImageCache mImageCache = new ImageCache();
    //线程池,线程数量为CPU的数量
    ExecutorService mExcutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        imageView.setTag(url);
        mExcutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap imageBitmap = downloadImage(url);
                if (imageBitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(imageBitmap);
                }
                mImageCache.put(url, imageBitmap);
            }
        });
    }

    /**
     * 缓存图片
     *
     * @param url
     */
    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
