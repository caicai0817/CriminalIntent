package com.caicai.criminalintent.media;

import android.content.Context;
import android.media.MediaPlayer;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2015/12/19 15:05
 * @Description: 播放音频
 */
public class AudioPlayer {

    private MediaPlayer mMediaPlayer;

    /**
     * 播放
     * @param context
     */
    public void start(final Context context){

        if (mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(context, R.raw.apollo_17_stroll);
        }
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mMediaPlayer.start();
    }

    /**
     * 停止播放
     */
    public void stop(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * 是否正在播放
     * @return
     */
    public boolean isPlaying(){
        return mMediaPlayer != null;
    }

    /**
     * 暂停
     */
    public void pause(){
        if (mMediaPlayer != null){
            mMediaPlayer.pause();
        }
    }
}
