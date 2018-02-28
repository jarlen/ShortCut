package cn.jarlen.shortcut;

import android.app.Application;
import android.util.Log;

/**
 * Created by jarlen on 2018/2/28.
 */

public class ShortCutApplication extends Application {

    public static final String TAG = ShortCutApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }
}
