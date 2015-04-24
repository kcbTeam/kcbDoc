package com.android5learn.application;

import android.app.Application;
import android.os.Build;

public class MyApplication extends Application {
    public static boolean isLollipop;

    @Override
    public void onCreate() {
        super.onCreate();

        isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
