package com.binarywalllabs.socialintegration;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.binarywalllabs.socialintegration.managers.SharedPreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Arun on 05-09-2015.
 */
public class AppDelegate extends Application implements Application.ActivityLifecycleCallbacks {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "abyAEIDjXwMNHjkWZsGVJvldv";
    private static final String TWITTER_SECRET = "6KSqPZD0vl6oDENgBFgfalKQOkQmLZYTaqlaQXWu93YtACY3Al";



    @Override
    public void onCreate() {
        super.onCreate();
        instantiateManagers();
    }

    /**
     * Method to instantiate all the managers in this app
     */
    private void instantiateManagers() {
        FacebookSdk.sdkInitialize(this);
        Fresco.initialize(this);
        SharedPreferenceManager.getSharedInstance().initiateSharedPreferences(getApplicationContext());
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }


}

