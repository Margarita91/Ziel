package zielabi.icon_worldwide.com.zielabi;

import android.app.Application;
import android.content.Context;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by margarita on 23/08/2017.
 */

public class ZielAbiApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ZielAbiApplication.context = getApplicationContext();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/avenir-next-regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }


    public static Context getContext() {
        return ZielAbiApplication.context;
    }

}
