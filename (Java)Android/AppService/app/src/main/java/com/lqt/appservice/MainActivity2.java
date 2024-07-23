package com.lqt.appservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextLocation;
    TextView textViewWeather;
    Button buttonXem;
    private boolean binded = false;
    private WeatherService weatherService;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            WeatherService.LocaleWeatherBinder binder = (WeatherService.LocaleWeatherBinder) service;

            weatherService = binder.getService();
            binded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(MainActivity2.this, WeatherService.class);
        this.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unbindService(connection);
        binded = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
        ListenButton();
    }

    private void ListenButton() {
        buttonXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void AnhXa() {
         editTextLocation = (EditText) findViewById(R.id.editTextLocation) ;
         textViewWeather = (TextView) findViewById(R.id.textViewWeather);
         buttonXem = (Button) findViewById(R.id.buttonXem);
    }

    public void showWeather(){
        String location = this.editTextLocation.getText().toString();
        String weather = this.weatherService.getWeatherToday(location);
        Log.e("a","đến đây");
        this.textViewWeather.setText(weather);
    }
}