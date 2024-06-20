package $12_Linked_List;

import java.util.LinkedList; //JCF has all its methods best optimized

public class $2_inbuilt_LL {
    public static void main(String[] args) {
        //create linked list
        LinkedList<Integer> ll = new LinkedList<>();

        //add element in linked list
        ll.addLast(2);
        ll.addLast(3);
        ll.addFirst(1);

        //get element
        int val = ll.get(0);
        System.out.println(val);

        //print linked list
        System.out.println(ll);
        
        //remove element
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);

        //Note - There is no way so that i can access the node of the LL using java.util.*;
    }
}
