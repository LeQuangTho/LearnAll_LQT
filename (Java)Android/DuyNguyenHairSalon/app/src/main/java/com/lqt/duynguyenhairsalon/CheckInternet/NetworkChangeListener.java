package com.lqt.duynguyenhairsalon.CheckInternet;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.lqt.duynguyenhairsalon.R;

/*
 * Tiến trình chạy ngầm lắng nghe sự kiên thay đổi mạng Internet.
 * */
public class NetworkChangeListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Nếu không có kết nối internet nào
        if (!Common.isConnectedToInternet(context)) {
            showDiaglog(context, intent);
        }
    }

    private void showDiaglog(Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View layoutDialog = LayoutInflater.from(context).inflate(R.layout.dialog_check_intenet, null);

        builder.setView(layoutDialog);

        //Show dialog
        AlertDialog dialog = builder.create();

        Button buttonRetry = (Button) layoutDialog.findViewById(R.id.button_Retry);
        buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onReceive(context, intent);
            }
        });

        dialog.show();
        dialog.setCancelable(false);

        dialog.getWindow().setGravity(Gravity.CENTER);
    }
}
