package com.lqt.appservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class WeatherService extends Service {
    private String LOG_TAG = "WeatherService";
    private static final Map<String, String> weatherData = new HashMap<String, String>();
    private  final IBinder iBinder = new LocaleWeatherBinder();
    public class LocaleWeatherBinder extends Binder {
        public WeatherService getService(){
            return WeatherService.this;
        }

    }

    public WeatherService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.i(LOG_TAG, "onBind");
        return this.iBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(LOG_TAG, "onReBind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public String getWeatherToday(String Location){
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String dayString = dateFormat.format(now);
        String keyLocAndDay = Location + "$" + dayString;

        String Weather = weatherData.get(keyLocAndDay);
        if(Weather != null){
            return Weather;
        }
        String[] weathers = new String[]{"Sunny", "Rainny","Cloudy", "Thorry ^_^"};
        int i = new Random().nextInt(3);
        Weather = weathers[i];
        weatherData.put(keyLocAndDay, Weather);
        return Weather;
    }
}