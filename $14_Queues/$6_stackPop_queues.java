package $14_Queues;

import java.util.Stack;

public class $6_stackPop_queues {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //add - O(1)
        public static void add(int data) {
            s1.push(data);
        }

        //remove - O(2*n) = O(n)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty !!");
                return -1;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }

        //peek - O(n)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty !!");
                return -1;
            }
            
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
