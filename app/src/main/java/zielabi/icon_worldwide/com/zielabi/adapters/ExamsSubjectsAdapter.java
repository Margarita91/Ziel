package zielabi.icon_worldwide.com.zielabi.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.Course;

/**
 * Created by margarita on 9/3/17.
 */

public class ExamsSubjectsAdapter  extends ArrayAdapter<Course>{
    private final LayoutInflater inflater;
    private List<Object> list;
    private Context mContext;
    private TextView mQ1Txt;
    private TextView mQ2Txt;
    private TextView mQ3Txt;
    private TextView mQ4Txt;
    private TextView mSTxt;
    private TextView m1Txt;
    private TextView m2Txt;
    private TextView m3Txt;
    private TextView m4Txt;
    private TextView m5Txt;
    private TextView m6Txt;
    private TextView m7Txt;
    private TextView m8Txt;
    private TextView m9Txt;
    private TextView m10Txt;
    private TextView m11Txt;
    private TextView m12Txt;
    private TextView m13Txt;
    private TextView m14Txt;
    private TextView m15Txt;
    private LinearLayout mBackgroundLayout;
    private LinearLayout mQ1Layout;
    private LinearLayout mQ2Layout;
    private LinearLayout mQ3Layout;
    private LinearLayout mQ4Layout;
    private LinearLayout mSLayout;
    private TextView mSubjectName;
    private ImageView mSubjectSettings;
    public ExamsSubjectsAdapter(Context context, ArrayList<Course> list) {
        super(context, R.layout.item_exam_subject, R.id.txt_subject, list);
        inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Course option = (Course) this.getItem(position);


        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_exam_subject, null);


        }
        else{

        }
        return super.getView(position, convertView, parent);
    }
}
