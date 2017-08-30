package zielabi.icon_worldwide.com.zielabi.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by margarita on 23/08/2017.
 */

public class CourseCalculation {
    private String mCourseTitle;
     private List<String> mCalculations = new ArrayList<String>();

    public CourseCalculation(String courseTitle, List<String> calculations) {
        mCourseTitle = courseTitle;
        mCalculations = calculations;
    }
}
