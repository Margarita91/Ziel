package zielabi.icon_worldwide.com.zielabi.models;

import java.io.Serializable;

/**
 * Created by margarita on 23/08/2017.
 */

public class State  implements Serializable {


    private String mStateName;
    private int mWrittenLimit;
    private int mOralLimit;
    private int mOptionalOralLimit;
    private double mSemesterGrades;
    private double mMaxSemesterGrades;
    private int mExamMultiplier;
    private boolean mIsBllState;
    private String mBllReplaces;
    private boolean mProjectState;
    private boolean mProjectIsOptional;
    private int mProjectFactor;
    private boolean mIsAdditionalOralState;
    private boolean mIsPresentationState;
    private CourseMultiplier mExamCourseFactor;
    private int mWrittenFactorLimit;
    private boolean mIsAutoAssignFactor;
    private AssignFactor mAssignFactorTo;
    private boolean mIsMagic;
    private int mType;

    public State(){}
    public State(String stateName){
        mStateName = stateName;
    }
    public State(String stateName, int writtenLimit, int oralLimit, int optionalOralLimit, double semesterGrades, double maxSemesterGrades,
                 int examMultiplier, boolean isBllState, String bllReplaces, boolean projectState, boolean projectIsOptional,
                 int projectFactor, boolean isAdditionalOralState, boolean isPresentationState, CourseMultiplier examCourseFactor, int writtenFactorLimit,
                 boolean isAutoAssignFactor, AssignFactor assignFactorTo) {
        mStateName = stateName;
        mWrittenLimit = writtenLimit;
        mOralLimit = oralLimit;
        mOptionalOralLimit = optionalOralLimit;
        mSemesterGrades = semesterGrades;
        mMaxSemesterGrades = maxSemesterGrades;
        mExamMultiplier = examMultiplier;
        mIsBllState = isBllState;
        mBllReplaces = bllReplaces;
        mProjectState = projectState;
        mProjectIsOptional = projectIsOptional;
        mProjectFactor = projectFactor;
        mIsAdditionalOralState = isAdditionalOralState;
        mIsPresentationState = isPresentationState;
        mExamCourseFactor = examCourseFactor;
        mWrittenFactorLimit = writtenFactorLimit;
        mIsAutoAssignFactor = isAutoAssignFactor;
        mAssignFactorTo = assignFactorTo;
    }
    public boolean isMagic() {
        return mIsMagic;
    }

    public void setMagic(boolean magic) {
        this.mIsMagic = magic;
    }
    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String stateName) {
        mStateName = stateName;
    }

    public int getWrittenLimit() {
        return mWrittenLimit;
    }

    public void setWrittenLimit(int writtenLimit) {
        mWrittenLimit = writtenLimit;
    }

    public int getOralLimit() {
        return mOralLimit;
    }

    public void setOralLimit(int oralLimit) {
        mOralLimit = oralLimit;
    }

    public int getOptionalOralLimit() {
        return mOptionalOralLimit;
    }

    public void setOptionalOralLimit(int optionalOralLimit) {
        mOptionalOralLimit = optionalOralLimit;
    }

    public double getSemesterGrades() {
        return mSemesterGrades;
    }

    public void setSemesterGrades(double semesterGrades) {
        mSemesterGrades = semesterGrades;
    }

    public double getMaxSemesterGrades() {
        return mMaxSemesterGrades;
    }

    public void setMaxSemesterGrades(double maxSemesterGrades) {
        mMaxSemesterGrades = maxSemesterGrades;
    }

    public int getExamMultiplier() {
        return mExamMultiplier;
    }

    public void setExamMultiplier(int examMultiplier) {
        mExamMultiplier = examMultiplier;
    }

    public boolean isBllState() {
        return mIsBllState;
    }

    public void setBllState(boolean bllState) {
        mIsBllState = bllState;
    }

    public String getBllReplaces() {
        return mBllReplaces;
    }

    public void setBllReplaces(String bllReplaces) {
        mBllReplaces = bllReplaces;
    }

    public boolean isProjectState() {
        return mProjectState;
    }

    public void setProjectState(boolean projectState) {
        mProjectState = projectState;
    }

    public boolean isProjectIsOptional() {
        return mProjectIsOptional;
    }

    public void setProjectIsOptional(boolean projectIsOptional) {
        mProjectIsOptional = projectIsOptional;
    }

    public int getProjectFactor() {
        return mProjectFactor;
    }

    public void setProjectFactor(int projectFactor) {
        mProjectFactor = projectFactor;
    }

    public boolean isAdditionalOralState() {
        return mIsAdditionalOralState;
    }

    public void setAdditionalOralState(boolean additionalOralState) {
        mIsAdditionalOralState = additionalOralState;
    }

    public boolean isPresentationState() {
        return mIsPresentationState;
    }

    public void setPresentationState(boolean presentationState) {
        mIsPresentationState = presentationState;
    }

    public CourseMultiplier getExamCourseFactor() {
        return mExamCourseFactor;
    }

    public void setExamCourseFactor(CourseMultiplier examCourseFactor) {
        mExamCourseFactor = examCourseFactor;
    }

    public int getWrittenFactorLimit() {
        return mWrittenFactorLimit;
    }

    public void setWrittenFactorLimit(int writtenFactorLimit) {
        mWrittenFactorLimit = writtenFactorLimit;
    }

    public boolean isAutoAssignFactor() {
        return mIsAutoAssignFactor;
    }

    public void setAutoAssignFactor(boolean autoAssignFactor) {
        mIsAutoAssignFactor = autoAssignFactor;
    }

    public AssignFactor getAssignFactorTo() {
        return mAssignFactorTo;
    }

    public void setAssignFactorTo(AssignFactor assignFactorTo) {
        mAssignFactorTo = assignFactorTo;
    }

    public int getType() {
        return mType;
    }
}
