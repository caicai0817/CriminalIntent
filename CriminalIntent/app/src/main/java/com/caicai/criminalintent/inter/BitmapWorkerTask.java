package com.caicai.criminalintent.inter;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * @author Caicai.
 * @date 2018/3/29.
 * @description
 */

public class BitmapWorkerTask extends AsyncTask<Integer,Void,Bitmap> {
    private final WeakReference<ImageView> imageViewWeakReference;
    private int data = 0;

    public BitmapWorkerTask(ImageView imageView) {
        this.imageViewWeakReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return null;
    }
}
