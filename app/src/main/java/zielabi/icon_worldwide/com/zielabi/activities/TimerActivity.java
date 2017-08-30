package zielabi.icon_worldwide.com.zielabi.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityTimerBinding;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;
import zielabi.icon_worldwide.com.zielabi.utils.PathDrawable;
import zielabi.icon_worldwide.com.zielabi.views.TimerView;

/**
 * Created by margarita on 8/26/17.
 */

public class TimerActivity extends AppCompatActivity {
    private TimerView mOutsideCircle;
    private TimerView mInsideCircle;
    private ActivityTimerBinding binding;
    private ImageView button_test;
    private TextView mCounterTextView;
    private TextView mContinueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_timer);

        mOutsideCircle = binding.circleOutside;
        mCounterTextView = binding.txtCounter;
        mContinueTextView = binding.txtContinue;
        mInsideCircle = binding.circleInside;


        if (mInsideCircle != null) {
            mInsideCircle.drawProgress(60);
        }

        button_test = binding.buttonScale;

        button_test.setOnTouchListener(new View.OnTouchListener() {
            private float x;
            private int mx;

            int maxX = TimerActivity.this.getResources().getDisplayMetrics().widthPixels - 200;

            public boolean onTouch(View v, MotionEvent event) {
                Point centerPoint = getPointOfView(button_test);
                double positionFloat = 4.0 - centerPoint.x * 3.0 / maxX;
                int positionInteger = (int) (positionFloat * 10);
                mCounterTextView.setText(positionInteger / 10.0 + "");
                mOutsideCircle.drawProgressMinute((int) (centerPoint.x * 60/ (maxX - 50)+1),true);


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = event.getX();
                    case MotionEvent.ACTION_MOVE:
                        mx = (int) (event.getRawX() - x);
                        if (mx <= maxX && mx > -20)
                            button_test.setX(mx);
                        break;
                }
                return true;
            }
        });
        mContinueTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimerActivity.this, TargetABIActivity.class);
                startActivity(intent);
                ActivityAnimationUtils.startActivityAnimation(TimerActivity.this);
                TimerActivity.this.finish();
            }
        });
    }

    private Point getPointOfView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }


    private Point getCenterPointOfView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        int x = location[0] + view.getWidth() / 2;
        int y = location[1] + view.getHeight() / 2;
        return new Point(x, y);
    }
}
