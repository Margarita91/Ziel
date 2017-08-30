package zielabi.icon_worldwide.com.zielabi;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

import zielabi.icon_worldwide.com.zielabi.models.AssignFactor;
import zielabi.icon_worldwide.com.zielabi.models.CourseMultiplier;
import zielabi.icon_worldwide.com.zielabi.models.State;
import zielabi.icon_worldwide.com.zielabi.utils.TypefaceUtil;

/**
 * Created by margarita on 23/08/2017.
 */

public class ZielAbiApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/roboto_regular.ttf");
        ZielAbiApplication.context = getApplicationContext();
    }


    public static Context getContext() {
        return ZielAbiApplication.context;
    }

}
