package $20_HashingSets;
import java.util.*;

public class $3_more_sets {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Banglore");
        hs.add("Chandigarh");
        System.out.println(hs);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Banglore");
        lhs.add("Chandigarh");
        
        lhs.remove("Delhi");
        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Banglore");
        ts.add("Chandigarh");
        System.out.println(ts);

    }
}
