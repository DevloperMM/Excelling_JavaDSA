package $11_Arraylist_folder;

import java.util.ArrayList;

public class $7_pairsum_1 {

    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        // //brute force approach
        // for (int i=0; i<list.size(); i++) {
        //     for (int j=0; j<list.size(); j++) {
        //         if (list.get(i) + list.get(j) == target) {
        //             return true;
        //         }
        //     }
        // }

        //2-pointer approach
        int lp = 0;
        int rp = list.size()-1;
        while (lp < rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(13);
        list.add(3);
        list.add(6);
        list.add(10);

        // To get the right output, the array should be sorted in ascending order
        int target = 16;
        System.out.println(pairSum1(list, target));
    }
}
