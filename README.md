#<center>MediaPalyer</center>

###一、单独使用MediaPalyer只是播放音频；  

播放音频只需要实例化MediaPalyer、设置播放文件、异步（同步）装载文件、调用播放。

	MediaPlayer mp = new MediaPlayer();//实例化
	mp.setDataSource("http://www.citynorth.cn/music/confucius.mp3");//设置资源
	mediaPlayer.prepareAsync();//装载资源  同步方法mediaPlayer.prepare();
	//装载完成回调
	mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
	            @Override
	            public void onPrepared(MediaPlayer mp) {
	                mediaPlayer.start();//播放
	            }
	        });


具体请看该博客[MediaPalyer](http://blog.csdn.net/u014365133/article/details/53330776)中常用方法以及一些技巧


###二、使用SurfaceView+MediaPlayer,播放视频

**比播放音频多出下面内容**

	SurfaceHolder  holder=surfaceView.getHolder();
	holder.addCallback(new MyCallBack());
	
    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

           用到MediaPlayer.setDisplay(holder)；

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }
