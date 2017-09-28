package zielabi.icon_worldwide.com.zielabi.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.Course;

/**
 * Created by margarita on 9/28/17.
 */

public class TestAdapter extends SectioningAdapter  {

    Locale locale = Locale.getDefault();
    static final boolean USE_DEBUG_APPEARANCE = false;

    private class Section {
        String alpha;
        ArrayList<Course> people = new ArrayList<>();
    }

    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder {
        TextView personNameTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            personNameTextView = (TextView) itemView.findViewById(R.id.txt_subject);
        }
    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView titleTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }


    List<Course> people;
    ArrayList<Section> sections = new ArrayList<>();

    public TestAdapter() {
    }

    public List<Course> getPeople() {
        return people;
    }

    public void setCourses(List<Course> courses) {
        this.people = courses;
        sections.clear();

        Map<String, ArrayList<Course>> buckets = new HashMap<String, ArrayList<Course>>();
        for (Course course : courses) {
            Log.i("119", course.getCourseType()+ course.getCourseTitle());
            if (!buckets.containsKey(course.getCourseType())) {
                buckets.put(course.getCourseType(), new ArrayList<Course>());
            }
            buckets.get(course.getCourseType()).add(course);
        }
        Iterator it = buckets.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<Course>> entry = (Map.Entry)it.next();
            Section currentSection = new Section();
            currentSection.alpha = entry.getKey();
            for (int i = 0; i < entry.getValue().size(); ++i) {
                currentSection.people.add(entry.getValue().get(i));
            }
            sections.add(currentSection);
        }
        notifyAllSectionsDataSetChanged();
    }

    @Override
    public int getNumberOfSections() {
        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        return sections.get(sectionIndex).people.size();
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
        Course person = s.people.get(itemIndex);
        ivh.personNameTextView.setText(person.getCourseTitle());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        Section s = sections.get(sectionIndex);
        HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;

        if (USE_DEBUG_APPEARANCE) {
            hvh.itemView.setBackgroundColor(0x55ffffff);
            hvh.titleTextView.setText(pad(sectionIndex * 2) + s.alpha);
        } else {
            hvh.titleTextView.setText(s.alpha);
        }
    }

    private String capitalize(String s) {
        if (s != null && s.length() > 0) {
            return s.substring(0,1).toUpperCase(locale) + s.substring(1);
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
