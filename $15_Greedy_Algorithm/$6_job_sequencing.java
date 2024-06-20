package $15_Greedy_Algorithm;

import java.util.*;

public class $6_job_sequencing {
    static class Job {
        int id; //0-A | 1-B | 2-C , etc.
        int deadLine;
        int profit;

        public Job(int i, int d, int p) {
            this.deadLine = d;
            this.profit = p;
            this.id = i;
        }
    }

    //Brute Force Approach - Write code using anyway i.e. AI or etc.

    //Greedy Approach
    public static void main(String[] args) {
        
        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        //Use-Case: {{2,100}, {1,19}, {2,27}, {1,25}, {3,15}}

        ArrayList<Job> jobs = new ArrayList<>();
        //Just storing objects of class Job in the array
        
        for (int i=0; i<jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a,b) -> b.profit - a.profit);
        //dsc order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadLine > time) {
                seq.add(curr.id);
                time++;                
            }
        }

        System.out.println("Max jobs done = " + seq.size());
        //print sequence
        for (int i=0; i<seq.size(); i++) {
            int v = seq.get(i) + 65; //add 65 to make it a ASCII Value
            char ch = (char) v;
            System.out.print(ch+" ");
        }
        System.out.println();
    }
}
