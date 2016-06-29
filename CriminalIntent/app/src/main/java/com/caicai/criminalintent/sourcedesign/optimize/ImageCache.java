package com.caicai.criminalintent.sourcedesign.optimize;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

/**
 * @Author : caicai
 * @Time : 2016/6/28 11:09
 * @Description: 图片缓存器
 */
public class ImageCache {
    LruCache<String, Bitmap> lruCache;

    public ImageCache() {
        initImageCache();
    }

    /**
     * 初始化imagecache
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private void initImageCache() {
        //计算机可使用的最大内存
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //分1/4给它使用
        int cacheSize = maxSize / 4;
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    //存储方法
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void put(String key,Bitmap bitmap){
        lruCache.put(key,bitmap);
    }

    //获取方法
    public Bitmap get(String key){
        return lruCache.get(key);
    }
}
