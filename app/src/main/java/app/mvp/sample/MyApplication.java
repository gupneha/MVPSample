package app.mvp.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public class MyApplication extends Application {

    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }


}
