package zielabi.icon_worldwide.com.zielabi.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityTargetAbiBinding;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;

/**
 * Created by margarita on 24/08/2017.
 */

public class TargetABIActivity extends BaseActivity implements View.OnClickListener{
    private ActivityTargetAbiBinding binding;
    private BubblePicker mBubblePicker;
    private ImageView mButtonBack;
    private float mx, my;
    private float curX, curY;
    private TextView mContinueTextView;
    private HorizontalScrollView hScroll;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityAnimationUtils.goBackAnimation(TargetABIActivity.this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_target_abi);
        mBubblePicker = binding.picker;
        mContinueTextView = binding.buttonContinue;
        mButtonBack = binding.headerSecondary.buttonBack;
        mButtonBack.setOnClickListener(this);
        mContinueTextView.setOnClickListener(this);
        binding.headerSecondary.txtPageName.setText(getString(R.string.preferences));
        final String[] titles = getResources().getStringArray(R.array.subjects);

        mBubblePicker.setCenterImmediately(true);
        mBubblePicker.setBubbleSize(60);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        // You want size to be 50% per EditText, so divide available height by 2.
        // Note: this is absolute height, does not take into consideration window decoration!
        mBubblePicker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int position) {
                PickerItem item = new PickerItem();
                item.setTitle(titles[position]);
                item.setColor(ContextCompat.getColor(TargetABIActivity.this, R.color.prime_orange));
                item.setTextColor(ContextCompat.getColor(TargetABIActivity.this, android.R.color.white));

                return item;
            }
        });
        mBubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {

            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mBubblePicker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBubblePicker.onPause();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBack:
                onBackPressed();
                break;
            case R.id.button_continue:
                Intent intent = new Intent(TargetABIActivity.this, ExamSubjectsActivity.class);
                startActivity(intent);
                ActivityAnimationUtils.startActivityAnimation(TargetABIActivity.this);
                break;
        }
    }
}
