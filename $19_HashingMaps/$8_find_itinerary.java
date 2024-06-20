package $19_HashingMaps;
import java.util.*;

public class $8_find_itinerary {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String route[][] = {{"Chennai", "Bengaluru"}, {"Mumbai", "Delhi"},
                            {"Goa", "Chennai"}, {"Delhi", "Goa"}};

        HashMap<String, String> tickets = new HashMap<>();
        for (int i=0; i<route.length; i++) {
            tickets.put(route[i][0], route[i][1]);
        }
        
        String start = getStart(tickets);
        System.out.print(start);
        for (int i=0; i<tickets.size(); i++) {
            System.out.print( " -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
        System.out.println(start);
    }
}
