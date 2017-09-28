package zielabi.icon_worldwide.com.zielabi;

import java.util.ArrayList;

import zielabi.icon_worldwide.com.zielabi.models.AssignFactor;
import zielabi.icon_worldwide.com.zielabi.models.CourseMultiplier;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 23/08/2017.
 */

public class Constants {
    static String adURL = "http://fs.de/bachelorday?utm_source=abirechner&utm_campaign=abirechner";

    public static final String SELECTED_SUBJECTS="SelectedSubjects";


    public static ArrayList<State> initStatesList() {
        int[] data1 = {2, 2, 2, 2};
        int[] data2 = {2, 2, 2, 1};
        //Bll Replaces - o: Oral, w: Written/Written Oral
        ArrayList<State> stateArrayList = new ArrayList<State>();


        //(String stateName, int writtenLimit, int oralLimit, int optionalOralLimit, double semesterGrades, double maxSemesterGrades,
        //  int examMultiplier, boolean isBllState, String bllReplaces, boolean projectState, boolean projectIsOptional,
        //  int projectFactor, boolean isAdditionalOralState, boolean isPresentationState, CourseMultiplier examCourseFactor, int writtenFactorLimit,
        //  boolean isAutoAssignFactor, AssignFactor assignFactorTo)

        //Baden-Württemberg
        stateArrayList.add(new State("Baden-Württemberg", 3, 2, 3, 40.0, 0, 4, true, "o", false, false, 0, false, false, null, 0, false, null));
        //Bayern
        stateArrayList.add(new State("Bayern", 3, 2, 3, 40.0, 0, 4, false, "", false, false, 0, false, false, null, 0, false, null));
        //Berlin
        stateArrayList.add(new State("Berlin", 3, 2, 0, 40.0, 0, 4, true, "o", false, false, 0, false, false, new CourseMultiplier(data1), 2, false, null));
        //Brandenburg
        stateArrayList.add(new State("Brandenburg", 3, 1, 0, 54.0, 0, 5, true, "", false, false, 0, true, true, new CourseMultiplier(data1), 3, false, null));
        //Bremen
        stateArrayList.add(new State("Bremen", 3, 1, 1, 40.0, 0, 5, true, "", true, false, 2, false, false, new CourseMultiplier(data2), 2, false, null));
        //Hamburg
        stateArrayList.add(new State("Hamburg", 3, 1, 0, 28, 48, 5, true, "", false, false, 0, true, true, new CourseMultiplier(data1), 3, false, null));
        //Hessen
        stateArrayList.add(new State("Hessen", 3, 2, 0, 40, 0, 4, true, "o", false, false, 0, false, true, new CourseMultiplier(data1), 2, false, null));
        //Mecklenburg-Vorpommern
        stateArrayList.add(new State("Mecklenburg-Vorpommern", 4, 1, 4, 44, 0, 4, true, "w", true, true, 2, false, false, new CourseMultiplier(data1), 2, false, null));
        //Niedersachsen
        stateArrayList.add(new State("Niedersachsen", 4, 1, 3, 44, 48, 4, true, "w", true, false, 2, false, false, new CourseMultiplier(data1), 3, false, null));
        //Nordrhein-Westfalen
        stateArrayList.add(new State("Nordrhein-Westfalen", 3, 1, 0, 43, 48, 5, true, "", false, false, 0, true, true, new CourseMultiplier(data1), 2, false, null));
        //Rheinland-Pfalz
        stateArrayList.add(new State("Rheinland-Pfalz", 3, 1, 3, 44, 0, 5, true, "", true, false, 1, true, false, new CourseMultiplier(data1), 0, true, new AssignFactor(0, 0, 2, 0, 0)));
        //Niedersachsen
        stateArrayList.add(new State("Saarland", 4, 1, 1, 36, 0, 4, true, "", false, false, 0, false, false, new CourseMultiplier(data1), 0, false, null));
        //Saarland
        stateArrayList.add(new State("Sachsen", 3, 2, 0, 40, 0, 4, true, "o", false, false, 0, false, false, new CourseMultiplier(data1), 2, false, null));
        //Sachsen-Anhalt
        stateArrayList.add(new State("Sachsen-Anhalt", 4, 1, 2, 36, 0, 4, true, "w", false, false, 0, false, false, new CourseMultiplier(data1), 0, true, new AssignFactor(0, 0, 0, 0, 2)));
        //Schleswig-Holstein
        stateArrayList.add(new State("Schleswig-Holstein", 3, 1, 0, 44, 0, 5, true, "", false, false, 0, true, false, new CourseMultiplier(data1), 2, false, null));
        //Thüringen
        stateArrayList.add(new State("Thüringen", 3, 2, 3, 40, 0, 4, true, "o", false, false, 0, false, false, new CourseMultiplier(data1), 0, false, null));

        return stateArrayList;
    }
}
