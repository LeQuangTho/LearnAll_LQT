package com.fsoft.android.audiovideo;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MyAudioPlayer extends Activity {

    private static final String TAG = "AudioVideo";
    private MediaPlayer mMediaPlayer;
  //  private static final String MEDIA = "media";
    private static final String AUDIOVIDEO = "audiovideo";
    private static final int LOCAL_AUDIO = 1;
    private static final int STREAM_AUDIO = 2;
    private static final int RESOURCES_AUDIO = 3;

    private String path;

    private TextView tx;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        tx = new TextView(this);
        setContentView(tx);
        Bundle extras = getIntent().getExtras();
        playAudio(extras.getInt(AUDIOVIDEO));
    }

    private void playAudio(Integer media) {
        try {
            switch (media) {
                case LOCAL_AUDIO:
                    /**
                     * TODO: Set the path variable to a local audio file path.
                     */
                    path = "/sdcard/sample.mp3";
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                    break;
                case RESOURCES_AUDIO:
                    /**
                     * TODO: Upload a audio file to res/raw folder and provide
                     * its reside in MediaPlayer.create() method.
                     */
                    mMediaPlayer = MediaPlayer.create(this, R.raw.sample);
                    mMediaPlayer.start();
                case STREAM_AUDIO:
                    path = "http://www.bogotobogo.com/Audio/sample.mp3";
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                    break;
            }
            tx.setText("Playing audio...");

        } catch (Exception e) {
            Log.e(TAG, "error: " + e.getMessage(), e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO Auto-generated method stub
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}