package $19_HashingMaps;

import java.util.HashMap;

public class $1_hashMap {
    public static void main(String[] args) {
        //Create
        HashMap<String,Integer> map = new HashMap<>();

        //Insert - O(1)
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        System.out.println(map);

        //Get - O(1)
        int population = map.get("India");
        System.out.println(population);
        System.out.println(map.get("Indonesia"));

        //ContainsKey - O(1)
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Indonesia"));

        //Remove - O(1)
        System.out.println(map.remove("China"));
        System.out.println(map.remove("Indonesia"));
        System.out.println(map);

        //Size
        System.out.println(map.size());

        //Isempty
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.isEmpty());
    }
}
