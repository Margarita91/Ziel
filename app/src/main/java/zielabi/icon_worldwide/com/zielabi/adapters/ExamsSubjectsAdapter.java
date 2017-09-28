package zielabi.icon_worldwide.com.zielabi.adapters;

import android.annotation.SuppressLint;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.plus.model.people.Person;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.ZielAbiApplication;
import zielabi.icon_worldwide.com.zielabi.databinding.ItemExamSubjectBinding;
import zielabi.icon_worldwide.com.zielabi.models.Course;

/**
 * Created by margarita on 9/3/17.
 */

public class ExamsSubjectsAdapter extends SectioningAdapter implements View.OnClickListener {


    static final boolean USE_DEBUG_APPEARANCE = false;
    private ItemExamSubjectBinding binding;

    @Override
    public void onClick(View view) {

    }

    private class Section {
        String type;
        ArrayList<Course> mCourses = new ArrayList<>();
    }

    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder {
        private TextView mTxtQ1;
        private TextView mTxtQ2;
        private TextView mTxtQ3;
        private TextView mTxtQ4;
        private TextView mTxtS;
        private TextView mTxtSM;
        private TextView mTxtSubject;
        private LinearLayout mTxtQ1Ly;
        private LinearLayout mTxtQ2Ly;
        private LinearLayout mTxtQ3Ly;
        private LinearLayout mTxtQ4Ly;
        private LinearLayout mTxtSLy;
        private LinearLayout mTxtSMLy;
        private int mSelectedExam = R.id.txt_q1_value;

        private void initViews() {

            mTxtQ1 = binding.txtQ1Value;
            mTxtQ2 = binding.txtQ2Value;
            mTxtQ3 = binding.txtQ3Value;
            mTxtQ4 = binding.txtQ4Value;
            mTxtS = binding.txtSValue;
            mTxtSM = binding.txtSmValue;

            mTxtQ1Ly = binding.txtQ1ValueLy;
            mTxtQ2Ly = binding.txtQ2ValueLy;
            mTxtQ3Ly = binding.txtQ3ValueLy;
            mTxtQ4Ly = binding.txtQ4ValueLy;
            mTxtSLy = binding.txtSValueLy;
            mTxtSMLy = binding.txtSmValueLy;
            mTxtSubject = binding.txtSubject;


            mTxtQ1Ly.setBackgroundResource(R.drawable.selector_red_border_background);



        }

        public ItemViewHolder(View itemView) {
            super(itemView);
            initViews();
        }
    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView titleTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }


    List<Course> courses;
    ArrayList<Section> sections = new ArrayList<>();

    public ExamsSubjectsAdapter() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        sections.clear();

        // sort people into buckets by the first letter of last name
        char alpha = 0;
        Section currentSection = null;
        for (Course course : courses) {
            if (course.getCourseType().charAt(0) != alpha) {
                if (currentSection != null) {
                    sections.add(currentSection);
                }

                currentSection = new Section();
                alpha = course.getCourseType().charAt(0);
                currentSection.type = String.valueOf(alpha);
            }

            if (currentSection != null) {
                currentSection.mCourses.add(course);
            }
        }

        sections.add(currentSection);
        notifyAllSectionsDataSetChanged();
    }

    @Override
    public int getNumberOfSections() {
        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        return sections.get(sectionIndex).mCourses.size();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_exam_subject, parent, false);
        binding = ItemExamSubjectBinding.inflate(inflater, parent, true);
        return new ItemViewHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_subject_header, parent, false);
        return new HeaderViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {
        Section s = sections.get(sectionIndex);
        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        Course course = s.mCourses.get(itemIndex);
        ivh.mTxtQ1.setText(course.getCourseTitle());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        Section s = sections.get(sectionIndex);
        HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;

        if (USE_DEBUG_APPEARANCE) {
            hvh.itemView.setBackgroundColor(ContextCompat.getColor(ZielAbiApplication.getContext(),R.color.colorPrimary));
            hvh.titleTextView.setText(pad(sectionIndex * 2) + s.type);
        } else {
            hvh.titleTextView.setText(s.type);
        }
    }

    private String capitalize(String s) {
        if (s != null && s.length() > 0) {
            return s.substring(0, 1) + s.substring(1);
        }

        return "";
    }

    private String pad(int spaces) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            b.append(' ');
        }
        return b.toString();
    }

}
