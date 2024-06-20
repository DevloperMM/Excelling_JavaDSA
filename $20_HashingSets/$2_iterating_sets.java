package $20_HashingSets;
import java.util.*;

public class $2_iterating_sets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Hathras");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Chandigarh");

        //M-1
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------");
        //M-2
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
