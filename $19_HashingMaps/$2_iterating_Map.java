package $19_HashingMaps;

import java.util.*;

public class $2_iterating_Map {
    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("China", 150);
        hashmap.put("India", 100);
        hashmap.put("US", 50);
        hashmap.put("Indonesia", 6);
        hashmap.put("Nepal", 5);

        //Iterate
        //method1
        // Set pairs = hashmap.entrySet();
        Set<HashMap.Entry<String, Integer>> pairs = hashmap.entrySet();
        System.out.println(pairs);  

        //method2
        Set<String> keys = hashmap.keySet(); //all keys are stored in it
        for (String k : keys) {
            System.out.print(k + "=" + hashmap.get(k) + " | ");
        }
        System.out.println();
    }
}
