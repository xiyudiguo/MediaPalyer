package com.zk.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import java.io.IOException;

public class MPActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);
        initView();
    }

    private void initView() {
        SurfaceView surfaceView= (SurfaceView) findViewById(R.id.video_mp);
        SurfaceHolder holder=surfaceView.getHolder();//拿到SurfaceHolder

        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov");
            mediaPlayer.prepareAsync();//装载资源
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(holder);//设置holder
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();//播放
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
