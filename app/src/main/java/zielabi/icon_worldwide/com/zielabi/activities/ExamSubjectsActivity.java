package zielabi.icon_worldwide.com.zielabi.activities;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

import java.util.ArrayList;
import java.util.List;

import zielabi.icon_worldwide.com.zielabi.Constants;
import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.adapters.ExamsSubjectsAdapter;
import zielabi.icon_worldwide.com.zielabi.adapters.TestAdapter;
import zielabi.icon_worldwide.com.zielabi.databinding.ActivityExamsSubjectsBinding;
import zielabi.icon_worldwide.com.zielabi.models.Course;
import zielabi.icon_worldwide.com.zielabi.utils.ActivityAnimationUtils;


/**
 * Created by margarita on 9/3/17.
 */

public class ExamSubjectsActivity extends BaseActivity {
    private ActivityExamsSubjectsBinding binding;
    private List<Course> mSelectedCourses = new ArrayList<Course>();
    private RecyclerView mRecyclerViewSubjects;
    private TestAdapter mExamsSubjectsAdapter = new TestAdapter();
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityAnimationUtils.goBackAnimation(ExamSubjectsActivity.this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exams_subjects);
        mRecyclerViewSubjects = binding.recyclerView;
        initViews();
        mSelectedCourses= (List<Course>) getIntent().getSerializableExtra(Constants.SELECTED_SUBJECTS);
        mExamsSubjectsAdapter.setCourses(mSelectedCourses);
        mRecyclerViewSubjects.setLayoutManager(new StickyHeaderLayoutManager());
        mRecyclerViewSubjects.setAdapter(mExamsSubjectsAdapter);
    }

    private void initViews() {
        mRecyclerViewSubjects = binding.recyclerView;
    }

}
