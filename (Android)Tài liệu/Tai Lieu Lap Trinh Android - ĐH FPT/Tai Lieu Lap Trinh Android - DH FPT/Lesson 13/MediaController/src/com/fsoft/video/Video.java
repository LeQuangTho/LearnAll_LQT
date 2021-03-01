package com.fsoft.video;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        VideoView videoView = (VideoView)this.findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        
        // (1) Web
        videoView.setVideoURI(Uri.parse(
        "http://www.bogotobogo.com/Video/sample.3gp"));
        //"http://www.bogotobogo.com/Video/sample.mp4"));
        		
        /* (2) SD card */
        //videoView.setVideoPath("/sdcard/sample.3gp");
       // videoView.setVideoPath("/sdcard/sample.mp4");
       // videoView.setVideoURI(Uri.parse(
       //	"file:///sdcard/sample.mp4"));
  
        videoView.requestFocus();
        videoView.start();
    }
}