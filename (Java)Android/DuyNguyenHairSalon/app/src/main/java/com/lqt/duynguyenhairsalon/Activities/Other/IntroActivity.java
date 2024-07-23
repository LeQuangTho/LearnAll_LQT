package com.lqt.duynguyenhairsalon.Activities.Other;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.lqt.duynguyenhairsalon.Activities.Home.MainActivity;
import com.lqt.duynguyenhairsalon.Activities.Login.SelectTypeLoginActivity;
import com.lqt.duynguyenhairsalon.CheckInternet.NetworkChangeListener;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

public class IntroActivity extends AppCompatActivity {

    //Param
    private Animation topAnim, bottomAnim, alphaAnim;
    private NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    //View
    private ImageView logo, sologan, background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        /**
         * Handler có nhiệm vụ gửi và thực thi các Message hoặc Runnable tới
         * Message Queue của Thread sinh ra nó (Handler). ... Các Message và Runnable sẽ được thực thi khi đi ra khỏi
         * Message Queue. Có 2 nhiệm vụ mà Handler thường làm đó là: Lên lịch thực thi các
         * Message và Runnable ở các thời điểm trong tương lai.
         **/
        topAnim = AnimationUtils.loadAnimation(this, R.anim.scale_logo_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.scale_logo_bottom);
        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_logo);

        logo = (ImageView) findViewById(R.id.imageView_Logo);
        sologan = (ImageView) findViewById(R.id.imageView_sologan);
        background = (ImageView) findViewById(R.id.imageView_Background);

        logo.setAnimation(topAnim);
        sologan.setAnimation(bottomAnim);
        background.setAnimation(alphaAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (DataLocalManager.getPrefIsLogged()) {
                    Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(IntroActivity.this, SelectTypeLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2500);
    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}