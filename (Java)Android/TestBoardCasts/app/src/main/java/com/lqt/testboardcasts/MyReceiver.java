package com.lqt.testboardcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Đã cắm sạc", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Đã rút sạc", Toast.LENGTH_SHORT).show();
        }
    }
}