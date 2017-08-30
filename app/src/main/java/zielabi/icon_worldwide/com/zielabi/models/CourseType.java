package zielabi.icon_worldwide.com.zielabi.models;

/**
 * Created by margarita on 23/08/2017.
 */

public class CourseType {
    private String mCourseType;
    private Course mCourses;


    public CourseType(String courseType, Course courses) {
        mCourseType = courseType;
        mCourses = courses;
    }

    public String getCourseType() {
        return mCourseType;
    }

    public void setCourseType(String courseType) {
        mCourseType = courseType;
    }

    public Course getCourses() {
        return mCourses;
    }

    public void setCourses(Course courses) {
        mCourses = courses;
    }
}
