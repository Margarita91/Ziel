package zielabi.icon_worldwide.com.zielabi.models;

/**
 * Created by margarita on 23/08/2017.
 */

public class SemesterGrade {

    private int mSemesterGrade;
    private int  mFactor;
    private boolean  mIsCompulsory;
    private boolean mIsCalculationSemester;

    public SemesterGrade(int semesterGrade, int factor, boolean isCompulsory, boolean isCalculationSemester) {
        mSemesterGrade = semesterGrade;
        mFactor = factor;
        mIsCompulsory = isCompulsory;
        mIsCalculationSemester = isCalculationSemester;
    }
}
