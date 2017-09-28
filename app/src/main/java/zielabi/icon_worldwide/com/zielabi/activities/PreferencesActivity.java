package zielabi.icon_worldwide.com.zielabi.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityPreferencesBinding;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;

import com.balysv.materialripple.MaterialRippleLayout;
import com.sevenheaven.iosswitch.ShSwitchView;

/**
 * Created by margarita on 28/09/2017.
 */

public class PreferencesActivity extends BaseActivity {
    private TextView mContinueTextView;
    private ImageView mButtonBack;
    private ActivityPreferencesBinding binding;
    private ShSwitchView mSwitchView;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityAnimationUtils.goBackAnimation(PreferencesActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_preferences);
        mContinueTextView = binding.txtContinue;
        binding.headerSecondary.txtPageName.setText(getString(R.string.preferences));
        mButtonBack = binding.headerSecondary.buttonBack;
        mSwitchView = binding.switchView;

        mSwitchView.setOnSwitchStateChangeListener(new ShSwitchView.OnSwitchStateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onSwitchStateChange(boolean isOn) {
                if (isOn) {


// get the center for the clipping circle
                    int cx = binding.layoutRipple.getWidth() / 2;
                    int cy = binding.layoutRipple.getHeight() / 2 + 120;

// get the final radius for the clipping circle
                    int finalRadius = Math.max(binding.layoutRipple.getWidth(), binding.layoutRipple.getHeight());

// create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(binding.layoutRipple, cx, cy, 0, finalRadius);

                    //Interpolator for giving effect to animation
                    anim.setInterpolator(new AccelerateDecelerateInterpolator());
                    // Duration of the animation
                    anim.setDuration(1000);

// make the view visible and start the animation
                    binding.layoutRipple.setVisibility(View.VISIBLE);
                    anim.start();
                    binding.txtAsk.setTextColor(ContextCompat.getColor(PreferencesActivity.this, R.color.white));
                } else {


                    // get the center for the clipping circle
                    int cx = binding.layoutRipple.getWidth() / 2;
                    int cy = binding.layoutRipple.getHeight() / 2 + 120;

                    // get the initial radius for the clipping circle
                    int initialRadius = binding.layoutRipple.getWidth();

                    // create the animation (the final radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(binding.layoutRipple, cx, cy, initialRadius, 0);

                    // make the view invisible when the animation is done
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            binding.layoutRipple.setVisibility(View.INVISIBLE);
                            binding.txtAsk.setTextColor(ContextCompat.getColor(PreferencesActivity.this, R.color.prime_blue));
                        }
                    });

// start the animation
                    anim.start();

                }
            }
        });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
        mContinueTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, TargetABIActivity.class);
                startActivity(intent);
                ActivityAnimationUtils.startActivityAnimation(PreferencesActivity.this);

            }
        });
    }

}
