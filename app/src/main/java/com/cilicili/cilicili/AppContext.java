package com.cilicili.cilicili;

import android.app.Application;

/**
 * Created by haifeng on 2018/3/23.
 */

public class AppContext extends Application{

    private static AppContext instance;


    public static AppContext getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public void init(){

    }
}
