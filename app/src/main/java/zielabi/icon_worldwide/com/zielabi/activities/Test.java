package zielabi.icon_worldwide.com.zielabi.activities;

/**
 * Created by margarita on 28/09/2017.
 */

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityExamsSubjectsBinding;
import zielabi.icon_worldwide.com.zielabi.views.TextSeekBar;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.adapters.LocationAdapter;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityExamsSubjectsBinding;
import zielabi.icon_worldwide.com.zielabi.views.TextSeekBar;


/**
 * Created by margarita on 9/3/17.
 */

public class Test extends BaseActivity  {
//    private ActivityExamsSubjectsBinding binding;
//
//    private TextView mTxtQ1;
//    private TextView mTxtQ2;
//    private TextView mTxtQ3;
//    private TextView mTxtQ4;
//    private TextView mTxtS;
//    private TextView mTxtSM;
//    private LinearLayout mTxtQ1Ly;
//    private LinearLayout mTxtQ2Ly;
//    private LinearLayout mTxtQ3Ly;
//    private LinearLayout mTxtQ4Ly;
//    private LinearLayout mTxtSLy;
//    private LinearLayout mTxtSMLy;
//    private int mSelectedExam = R.id.txt_q1_value;
//
//
//    private TextSeekBar seekBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_exams_subjects);
//        initViews();
//        seekBar = binding.seek;
//        seekBar.setOnSeekBarChangeListener(new TextSeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onProgressStart(int index) {
//                ((TextView) findViewById(mSelectedExam)).setText("" + index);
//            }
//
//            @Override
//            public void onProgressMoving(int index) {
//                ((TextView) findViewById(mSelectedExam)).setText("" + index);
//            }
//
//            @Override
//            public void onProgressChanged(int index) {
//
//                ((TextView) findViewById(mSelectedExam)).setText("" + index);
//            }
//        });
//    }
//
//    private void initViews() {
//        mTxtQ1 = binding.txtQ1Value;
//        mTxtQ2 = binding.txtQ2Value;
//        mTxtQ3 = binding.txtQ3Value;
//        mTxtQ4 = binding.txtQ4Value;
//        mTxtS = binding.txtSValue;
//        mTxtSM = binding.txtSmValue;
//
//        mTxtQ1Ly = binding.txtQ1ValueLy;
//        mTxtQ2Ly = binding.txtQ2ValueLy;
//        mTxtQ3Ly = binding.txtQ3ValueLy;
//        mTxtQ4Ly = binding.txtQ4ValueLy;
//        mTxtSLy = binding.txtSValueLy;
//        mTxtSMLy = binding.txtSmValueLy;
//
//
//        mTxtQ1Ly.setBackgroundResource(R.drawable.selector_red_border_background);
//
//        mTxtQ1Ly.setOnClickListener(this);
//        mTxtQ2Ly.setOnClickListener(this);
//        mTxtQ3Ly.setOnClickListener(this);
//        mTxtQ4Ly.setOnClickListener(this);
//        mTxtSLy.setOnClickListener(this);
//        mTxtSMLy.setOnClickListener(this);
//
//
//    }
//
//    void disableOthers(ViewGroup viewGroup, int id) {
//        for (int i = 0; i < viewGroup.getChildCount(); i++) {
//            View child = viewGroup.getChildAt(i);
//            if (child instanceof ViewGroup && (child.getId() != -1 && child.getId() != id)) {
//                child.setBackgroundResource(R.drawable.selector_white_background);
//
//            } else if (child instanceof ViewGroup) {
//                disableOthers((ViewGroup) child, id);
//
//            } else if (child != null) {
//                Log.d("menfis", child.toString());
//                if (child instanceof LinearLayout && (child.getId() != -1 && child.getId() != id)) {
//                    child.setBackgroundResource(R.drawable.selector_white_background);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//            case R.id.txt_q1_value_ly:
//                mTxtQ1Ly.setBackgroundResource(R.drawable.selector_red_border_background);
//                disableOthers(binding.layoutExamsContainer, R.id.txt_q1_value_ly);
//                mSelectedExam = R.id.txt_q1_value;
//
//                break;
//            case R.id.txt_q2_value_ly:
//                disableOthers(binding.layoutExamsContainer, R.id.txt_q2_value_ly);
//                mTxtQ2Ly.setBackgroundResource(R.drawable.selector_red_border_background);
//                seekBar.clear();
//                break;
//            case R.id.txt_q3_value_ly:
//                disableOthers(binding.layoutExamsContainer, R.id.txt_q3_value_ly);
//                mTxtQ3Ly.setBackgroundResource(R.drawable.selector_red_border_background);
//                mSelectedExam = R.id.txt_q3_value;
//                seekBar.clear();
//                break;
//            case R.id.txt_q4_value_ly:
//                disableOthers(binding.layoutExamsContainer, R.id.txt_q4_value_ly);
//                mTxtQ4Ly.setBackgroundResource(R.drawable.selector_red_border_background);
//
//                seekBar.clear();
//                break;
//            case R.id.txt_s_value_ly:
//                disableOthers(binding.layoutExamsContainer, R.id.txt_s_value_ly);
//                mTxtSLy.setBackgroundResource(R.drawable.selector_red_border_background);
//                seekBar.clear();
//                break;
//            case R.id.txt_sm_value_ly:
//                disableOthers(binding.layoutExamsContainer, R.id.txt_sm_value_ly);
//                mTxtSMLy.setBackgroundResource(R.drawable.selector_red_border_background);
//                seekBar.clear();
//                break;
//        }
//
//    }
}
