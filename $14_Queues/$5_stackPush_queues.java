package $14_Queues;

import java.util.*;
public class $5_stackPush_queues {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //add - O(n)
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //remove - O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty !!");
                return -1;
            }

            return s1.pop();
        }

        //peek - O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty !!");
                return -1;
            }
            
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
