package zielabi.icon_worldwide.com.zielabi.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityExamsSubjectsBinding;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityTargetAbiBinding;
import zielabi.icon_worldwide.com.zielabi.utils.OnSwipeTouchListener;


/**
 * Created by margarita on 9/3/17.
 */

public class ExamSubjectsActivity extends BaseActivity {
    private ActivityExamsSubjectsBinding binding;
    private List<Object> list;
    private Context mContext;
    LinearLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exams_subjects);
        myLayout = binding.grades;
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                LinearLayout layout = (LinearLayout) v;

                for (int i = 0; i < layout.getChildCount(); i++) {

                    View view = layout.getChildAt(i);
                    Rect outRect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (outRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        view.setBackgroundColor(ContextCompat.getColor(ExamSubjectsActivity.this, R.color.prime_orange));
                    }

                }
                return false;
            }

        });

//        myLayout.setOnTouchListener(new OnSwipeTouchListener(ExamSubjectsActivity.this) {
//            public void onSwipeTop() {
//                Toast.makeText(ExamSubjectsActivity.this, "top", Toast.LENGTH_SHORT).show();
//            }
//            public void onSwipeRight() {
//                Toast.makeText(ExamSubjectsActivity.this, "right", Toast.LENGTH_SHORT).show();
//            }
//            public void onSwipeLeft() {
//                Toast.makeText(ExamSubjectsActivity.this, "left", Toast.LENGTH_SHORT).show();
//
//            }
//            public void onSwipeBottom() {
//                Toast.makeText(ExamSubjectsActivity.this, "bottom", Toast.LENGTH_SHORT).show();
//            }
//
//        });
    }
}
