package $11_Arraylist_folder;

import java.util.ArrayList;

public class $8_pairsum_2 {
    public static boolean pairSum2(ArrayList<Integer> list, int target) {

        //brute force approach - will remain same as in case of the pairSum-1 problem as we will be checking all the possible cases.

        //2-pointer approach
        //we need breaking point first
        int bp = 0;
        for (int i=0; i<list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }

        int n = list.size();
        int lp = bp + 1;
        int rp = bp;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        
        System.out.println(pairSum2(list, 16));
    }
}
