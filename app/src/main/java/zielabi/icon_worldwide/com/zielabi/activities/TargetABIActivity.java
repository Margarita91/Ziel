package zielabi.icon_worldwide.com.zielabi.activities;

import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityTargetAbiBinding;

/**
 * Created by margarita on 24/08/2017.
 */

public class TargetABIActivity extends AppCompatActivity{
    private ActivityTargetAbiBinding binding;
    private BubblePicker mBubblePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_target_abi);
        mBubblePicker = binding.picker;

        final String[] titles = getResources().getStringArray(R.array.subjects);

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
}
