package zielabi.icon_worldwide.com.zielabi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by margarita on 23/08/2017.
 */

public class CourseMultiplier  implements Serializable {

    private List<Integer> mSemesterGradeMultipliers = new ArrayList<>();

    public CourseMultiplier(List<Integer> semesterGradeMultipliers) {
        mSemesterGradeMultipliers = semesterGradeMultipliers;
    }

    public CourseMultiplier(int[] data1) {

    }

    public List<Integer> getSemesterGradeMultipliers() {
        return mSemesterGradeMultipliers;
    }

    public void setSemesterGradeMultipliers(List<Integer> semesterGradeMultipliers) {
        mSemesterGradeMultipliers = semesterGradeMultipliers;
    }
    int semester1Multiplier(CourseMultiplier courseMultiplier) {

            if (courseMultiplier.getSemesterGradeMultipliers().size() == 4) {
                return mSemesterGradeMultipliers.get(0);
            } else {
                return 1;
            }

    }
    int semester2Multiplier(CourseMultiplier courseMultiplier) {

        if (courseMultiplier.getSemesterGradeMultipliers().size() == 4) {
            return mSemesterGradeMultipliers.get(1);
        } else {
            return 1;
        }

    }

    int semester3Multiplier(CourseMultiplier courseMultiplier) {

        if (courseMultiplier.getSemesterGradeMultipliers().size() == 4) {
            return mSemesterGradeMultipliers.get(2);
        } else {
            return 1;
        }

    }
    int semester4Multiplier(CourseMultiplier courseMultiplier) {

        if (courseMultiplier.getSemesterGradeMultipliers().size() == 4) {
            return mSemesterGradeMultipliers.get(3);
        } else {
            return 1;
        }

    }
}

