package com.caicai.criminalintent.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.caicai.criminalintent.R;

/**
 * @Author : caicai
 * @Time : 2015/12/19 13:59
 * @Description: 播放音频
 */
public class HelloMoonFragment extends Fragment implements View.OnClickListener {

    private FrameLayout layout;
    private SurfaceView mView;
    private Button mStart;
    private Button mStop;
    private MediaPlayer mediaPlayer;

    private AudioPlayer audioPlayer = new AudioPlayer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = new MediaPlayer();

        //activity重建的时候可以不完全销毁fragment
        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        audioPlayer.stop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hello_moon, null);

        layout = (FrameLayout) view.findViewById(R.id.hello_moon_layout);
        mView = (SurfaceView) view.findViewById(R.id.hello_moon_iv);
        mStart = (Button) view.findViewById(R.id.hello_moon_start);
        mStop = (Button) view.findViewById(R.id.hello_moon_stop);

        mStart.setOnClickListener(this);
        mStop.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hello_moon_start: {
//                audioPlayer.start(getActivity());
//                updateButton();
                playMedia();
            }
            break;
            case R.id.hello_moon_stop: {
//                audioPlayer.pause();
//                audioPlayer.stop();
//                updateButton();
                stopMedia();
            }
            break;
        }
    }

    /**
     * 停止播放视频
     */
    private void stopMedia() {
        mediaPlayer.stop();
    }

    /**
     * 播放视频
     */
    private void playMedia() {

        mediaPlayer.create(getActivity(), R.raw.apollo_17_stroll);
        mediaPlayer.setDisplay(mView.getHolder());
    }



    /**
     * 动态更新播放和停止的状态
     */
    private void updateButton() {
        boolean playing = !audioPlayer.isPlaying();
        mStart.setEnabled(playing);
    }
}
