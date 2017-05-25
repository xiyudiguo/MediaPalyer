package com.zk.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VitamioActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamio);

        initView();
    }

    private void initView() {
        ////检查vitamio框架是否可用
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        videoView = (VideoView) findViewById(R.id.video_suface);
        videoView.setVideoPath("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov"); //设置播放路径
        //
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();//开始播放
            }
        });
        // 设置video的控制器
        videoView.setMediaController(new MediaController(this));
        //播放完成
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        if (videoView!=null&&videoView.isPlaying()){
            videoView.stopPlayback();
        }
        super.onDestroy();
    }
}
