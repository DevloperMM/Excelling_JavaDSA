package $14_Queues;

import java.util.*;
public class $12_implementing_deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        //addFirst
        dq.addFirst(3);
        dq.addFirst(2);
        dq.addFirst(1);
        //addLast
        dq.addLast(4);
        dq.addLast(5);
        //removeFirst
        dq.removeFirst();
        dq.remove();
        //removeLast
        dq.removeLast();
        //getFirst
        System.out.println(dq.getFirst());
        //getLast
        System.err.println(dq.getLast());

        System.out.println(dq);
        
        // Due to the double ended nature of adding and removing elements in deque, it can be used as Stacks (by addLast and removeLast) and Queues (addLast and removeFirst).
    }
}
