package zielabi.icon_worldwide.com.zielabi.utils;

import android.app.Activity;

import zielabi.icon_worldwide.com.zielabi.R;


/**
 * Created by margarita on 24/08/2017.
 *
 */
public class ActivityAnimationUtils {

    public static void startActivityAnimation(Activity activity){
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right_behind);
    }

    public static void finishActivityAnimation(Activity activity){
        activity.overridePendingTransition(R.anim.slide_out_right_behind, R.anim.slide_out_right);
    }

    public static void goBackAnimation(Activity activity){
        activity.overridePendingTransition(R.anim.slide_out_right_behind, R.anim.slide_out_right);
    }

}
