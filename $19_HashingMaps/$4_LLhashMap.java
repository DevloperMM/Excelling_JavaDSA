package $19_HashingMaps;
import java.util.*;

public class $4_LLhashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkMap = new LinkedHashMap<>();
        linkMap.put("India", 135);
        linkMap.put("China", 165);
        linkMap.put("SriLanka", 55);
        linkMap.put("US", 65);
        linkMap.put("Italy", 15);
        System.out.println(linkMap);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 135);
        hm.put("China", 165);
        hm.put("SriLanka", 55);
        hm.put("US", 65);
        hm.put("Italy", 15);
        System.out.println(hm);
    }
}
