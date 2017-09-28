package zielabi.icon_worldwide.com.zielabi.models;

import java.io.Serializable;

/**
 * Created by margarita on 23/08/2017.
 */

public class Course implements Serializable{


    private String mCourseTitle;
    private boolean mIsExamCourse;
    private SemesterGrade mSemester1Grade;
    private SemesterGrade mSemester2Grade;
    private SemesterGrade mSemester3Grade;
    private SemesterGrade mSemester4Grade;
    private int mExamGrade;
    private int mOralGrade;
    private int mOptionalOralGrade;
    private double mTotalScore;
    private String mExamType;
    private String mCourseType;
    private int mLastActiveSemester;


    public Course(){}

    public Course(String courseTitle, boolean isExamCourse, SemesterGrade semester1Grade, SemesterGrade semester2Grade,
                  SemesterGrade semester3Grade, SemesterGrade semester4Grade, int examGrade, int oralGrade, int optionalOralGrade, double totalScore,
                  String examType, String courseType, int lastActiveSemester) {
        mCourseTitle = courseTitle;
        mIsExamCourse = isExamCourse;
        mSemester1Grade = semester1Grade;
        mSemester2Grade = semester2Grade;
        mSemester3Grade = semester3Grade;
        mSemester4Grade = semester4Grade;
        mExamGrade = examGrade;
        mOralGrade = oralGrade;
        mOptionalOralGrade = optionalOralGrade;
        mTotalScore = totalScore;
        mExamType = examType;
        mCourseType = courseType;
        mLastActiveSemester = lastActiveSemester;
    }

    public String getCourseTitle() {
        return mCourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        mCourseTitle = courseTitle;
    }

    public boolean isExamCourse() {
        return mIsExamCourse;
    }

    public void setExamCourse(boolean examCourse) {
        mIsExamCourse = examCourse;
    }

    public SemesterGrade getSemester1Grade() {
        return mSemester1Grade;
    }

    public void setSemester1Grade(SemesterGrade semester1Grade) {
        mSemester1Grade = semester1Grade;
    }

    public SemesterGrade getSemester2Grade() {
        return mSemester2Grade;
    }

    public void setSemester2Grade(SemesterGrade semester2Grade) {
        mSemester2Grade = semester2Grade;
    }

    public SemesterGrade getSemester3Grade() {
        return mSemester3Grade;
    }

    public void setSemester3Grade(SemesterGrade semester3Grade) {
        mSemester3Grade = semester3Grade;
    }

    public SemesterGrade getSemester4Grade() {
        return mSemester4Grade;
    }

    public void setSemester4Grade(SemesterGrade semester4Grade) {
        mSemester4Grade = semester4Grade;
    }

    public int getExamGrade() {
        return mExamGrade;
    }

    public void setExamGrade(int examGrade) {
        mExamGrade = examGrade;
    }

    public int getOralGrade() {
        return mOralGrade;
    }

    public void setOralGrade(int oralGrade) {
        mOralGrade = oralGrade;
    }

    public int getOptionalOralGrade() {
        return mOptionalOralGrade;
    }

    public void setOptionalOralGrade(int optionalOralGrade) {
        mOptionalOralGrade = optionalOralGrade;
    }

    public double getTotalScore() {
        return mTotalScore;
    }

    public void setTotalScore(double totalScore) {
        mTotalScore = totalScore;
    }

    public String getExamType() {
        return mExamType;
    }

    public void setExamType(String examType) {
        mExamType = examType;
    }

    public String getCourseType() {
        return mCourseType;
    }

    public void setCourseType(String courseType) {
        mCourseType = courseType;
    }

    public int getLastActiveSemester() {
        return mLastActiveSemester;
    }

    public void setLastActiveSemester(int lastActiveSemester) {
        mLastActiveSemester = lastActiveSemester;
    }
}
