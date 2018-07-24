package com.penguins.upasargatechnology.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by NaRan on 30,April,2018.
 * Copyright (c) inGrails Pvt. Ltd. All rights reserved.
 * nrn.panthi@gmail.com
 **/

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static MyApplication nepaTopApplication;
    private static SharedPreferences sharedPreferences;
    private static boolean isActive;


    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        nepaTopApplication = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getAppContext());

    }

    public static boolean isActivityVisible() {
        return isActive;
    }

    public static Context getAppContext() {
        return nepaTopApplication.getApplicationContext();
    }

    public static SharedPreferences getSharedPreference() {
        return sharedPreferences;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        isActive = true;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        isActive = false;
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
