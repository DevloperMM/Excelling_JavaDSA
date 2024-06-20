package $15_Greedy_Algorithm;

import java.util.*;

public class $1_activity_selection {
    public static void main(String[] args) { //O(nlogn) due to sorting
        int start[] = {1,0,3,5,8,5};
        int end[] = {2,6,4,7,9,9};
        //end time based sorted

        //sorting (if not in ques)
        int activities[][] = new int[start.length][3];
        for (int i=0; i<activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function -> shortForm
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(activities[0][0]); //add(0)
        int lastEnd = activities[0][2]; //end[0]

        for (int i=1; i<end.length; i++) {
            if (activities[i][1] >= lastEnd) { //start[i]
                //activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for (int i=0; i<ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
