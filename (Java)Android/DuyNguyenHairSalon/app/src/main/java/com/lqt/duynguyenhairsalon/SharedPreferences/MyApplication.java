package com.lqt.duynguyenhairsalon.SharedPreferences;

import android.app.Application;

/*
 *
 * Class này extend Application nên sẽ được khai báo trong manifests
 * và nó sẽ khởi tạo DataLocalManager;
 * từ đó ta có thể gọi Shared Preferences ở bất cứ đâu trong Project.
 *
 * */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
