package $15_Greedy_Algorithm;

import java.util.*;

public class $2_fractional_knapsack {
    public static void main(String[] args) { //O(nlogn) due to sortings
        int value[] = {62,101,123};
        int weight[] = {10,20,30};
        int W = 50;

        double ratio[][] = new double[value.length][2];
        // [i][0] => storing idx;
        // [i][1] => storing cost per unit or ratio;
        for (int i=0; i<value.length; i++) {
            ratio[i][1] = (double) (value[i]/weight[i]);
            ratio[i][0] = i;
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double maxValue = 0;
        for (int i=ratio.length-1; i>=0; i--) {
            int idx = (int) ratio[i][0];
            double val = ratio[i][1]; //cost per kg or ratio
            
            if (capacity >= weight[idx]) {
                //include whole item
                maxValue += value[idx];
                capacity -= weight[idx];
            } else {
                //include fractional item
                maxValue += (capacity * val);
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Value can be obtained is = " + maxValue);

    }
}
