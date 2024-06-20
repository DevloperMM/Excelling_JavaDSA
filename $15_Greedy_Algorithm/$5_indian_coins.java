package $15_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class $5_indian_coins {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,200,500,2000};
        //we have taken integer class to use reverseOrder

        Arrays.sort(coins, Comparator.reverseOrder());

        int amount = 790;
        int count = 0;
        ArrayList<Integer> l = new ArrayList<>();

        for (int i=0; i<coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    l.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total (min) coins needed = " + count);

        System.out.print("(");
        for (int i=0; i<l.size(); i++) {
            if (i != l.size()-1) {
                System.out.print(l.get(i) + ", ");
            } else {
                System.out.println(l.get(i) + ")");
            }
        }
    }
}