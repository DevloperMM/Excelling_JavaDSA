package $20_HashingSets;
import java.util.*;

public class $1_hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(2);
        System.out.println(set);

        if (set.contains(1)) {
            System.out.println("exist in set");
        }
        set.remove(1);
        if (set.contains(1)) {
            System.out.println("exist in set");
        } else {
            System.out.println("not exist in set");
        }

        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
