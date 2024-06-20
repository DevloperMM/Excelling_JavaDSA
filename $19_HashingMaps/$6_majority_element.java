package $19_HashingMaps;

import java.util.*;

public class $6_majority_element {
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};
        // int nums[] = {1,2};
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            // if (map.containsKey(nums[i])) {
            //     int freq = map.get(nums[i]);
            //     map.put(nums[i], freq+1);
            // } else {
            //     map.put(nums[i], 1);
            // }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) > n/3) {
                System.out.println(i);
            }
        }
    }
}
