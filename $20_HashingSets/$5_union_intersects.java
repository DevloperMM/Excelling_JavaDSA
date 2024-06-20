package $20_HashingSets;
import java.util.*;

public class $5_union_intersects {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        //union
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j=0; j<arr2.length; j++) {
            set.add(arr2[j]);
        }
        System.out.println("Union contain elements = " + set.size());
        System.out.println("Union = " + set);
        
        //intersection
        set.clear();
        HashSet<Integer> intersection = new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        int count = 0;
        for (int j=0; j<arr2.length; j++) {
            if (set.contains(arr2[j])) {
                count++;
                set.remove(arr2[j]);
                intersection.add(arr2[j]);
            }
        }
        System.out.println("Intersection contain elements = " + count);
        System.out.println("Intersection = " + intersection);
    }
}
