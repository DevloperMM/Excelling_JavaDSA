package $14_Queues;

import java.util.*;

public class $10_interleave_halves {
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int sz = q.size();

        for (int i=0; i<sz/2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        //This is just printing the O/p and not interleaving the queue as in upper method.
        // for (int i=0; i<sz; i++) {
        //     if (i%2 != 0) {
        //         System.out.print(q.peek() + " ");
        //         q.remove();
        //     } else {
        //         System.out.print(firstHalf.peek() + " ");
        //         firstHalf.remove();
        //     }
        // }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=6; i++) {
            q.add(i);
        }

        interLeave(q);
        
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
