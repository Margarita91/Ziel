package zielabi.icon_worldwide.com.zielabi.activities;

import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


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

public class TargetABIActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityTargetAbiBinding binding;
    private BubblePicker mBubblePicker;
    private ImageView mButtonBack;
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

        mButtonBack = binding.headerSecondary.buttonBack;
        mButtonBack.setOnClickListener(this);
        binding.headerSecondary.txtPageName.setText(getString(R.string.preferences));
        final String[] titles = getResources().getStringArray(R.array.subjects);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            mBubblePicker.setBackgroundColor(getResources().getColor(R.color.prime_orange,TargetABIActivity.this.getTheme()));
//        }
//        else{
//            mBubblePicker.setBackgroundColor(getResources().getColor(R.color.prime_orange));
//        }
//                item.setGradient(new BubbleGradient(colors.getColor((position * 2) % 8, 0),
//                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL));
        mBubblePicker.setTextSize(22);
        mBubblePicker.setTextColor(ContextCompat.getColor(TargetABIActivity.this, android.R.color.white));
        mBubblePicker.setBubbleSize(30);
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

//                item.setGradient(new BubbleGradient(colors.getColor((position * 2) % 8, 0),
//                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL));
                item.setTextColor(ContextCompat.getColor(TargetABIActivity.this, android.R.color.white));
               // item.setBackgroundImage(ContextCompat.getDrawable(TargetABIActivity.this, images.getResourceId(position, 0)));
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
            case R.id.button_back:
                onBackPressed();
                break;
        }
    }
}
