package $11_Arraylist_folder;

import java.util.ArrayList;
import java.util.Collections;

public class $3_methods {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(19);
        list.add(2);
        list.add(30);
        list.add(4);

        System.out.println(list);

        System.out.println(list.size());
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //sort - ascending order
        Collections.sort(list);
        System.out.println(list);

        //sort - descending order
        Collections.sort(list, Collections.reverseOrder());//comparator
        System.out.println(list);
    }
}
