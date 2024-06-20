package $14_Queues;

import java.util.*;

public class $11_queue_reversal {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=10; i++) {
            q.add(i);
        }

        reverseQueue(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
