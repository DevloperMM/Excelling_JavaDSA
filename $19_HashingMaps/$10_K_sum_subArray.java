package $19_HashingMaps;
import java.util.*;

public class $10_K_sum_subArray {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = 10;
        // int arr[] = {1,2,3};
        // int k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, count)
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int j=0; j<arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(ans);
    }
}
