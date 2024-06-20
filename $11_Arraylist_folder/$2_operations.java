package $11_Arraylist_folder;

import java.util.ArrayList;

public class $2_operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //Add Operation = O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(3, 100); // TC = O(n)
        System.out.println(list);

        // //Get Operation = O(1)
        // int element = list.get(3);
        // System.out.println(element);

        // //Remove = O(n)
        // list.remove(2);
        // System.out.println(list);

        //Set element at index = O(n)
        // list.set(5,10);
        // System.out.println(list);

        // //Contains Element = O(n)
        // System.out.println(list.contains(4));
        // System.out.println(list.contains(19));
    }
}
