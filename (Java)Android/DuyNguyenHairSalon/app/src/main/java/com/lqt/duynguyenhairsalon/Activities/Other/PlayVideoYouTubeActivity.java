package com.lqt.duynguyenhairsalon.Activities.Other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.lqt.duynguyenhairsalon.R;

public class PlayVideoYouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String ID_VIDEO;
    private String API_KEY = "AIzaSyC5OO_rliGtqP8EPL4Io8SaFrBi6tOlk6o";
    private int REQUEST_VIDEO = 1412;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_you_tube);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlayerView);

        Intent intent = getIntent();
        ID_VIDEO = intent.getStringExtra("ID_VIDEO");

        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(ID_VIDEO);
        youTubePlayer.play();
    }


    /*
     * kiểm tra lỗi người dùng
     * nếu lỗi thì thử khởi tạo lại lần nữa
     * nếu sai 1 lần nữa thì Toat lên là lỗi
     * */
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(PlayVideoYouTubeActivity.this, REQUEST_VIDEO);
        } else {
            Toast.makeText(this, "Lỗi!", Toast.LENGTH_SHORT).show();
        }
    }


    /*
     * Khởi tạo lại sau khi có lỗi người dùng
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO) {
            youTubePlayerView.initialize(API_KEY, this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}