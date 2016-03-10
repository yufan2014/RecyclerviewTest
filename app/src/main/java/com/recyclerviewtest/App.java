package com.recyclerviewtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/3/10.
 */
public class App extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
