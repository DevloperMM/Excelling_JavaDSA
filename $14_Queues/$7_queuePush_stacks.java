package $14_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class $7_queuePush_stacks {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (q1.isEmpty()) {
                q1.add(data);
            } else {
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
                q1.add(data);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        public int pop() {
            if (q1.isEmpty()) {
                return q2.remove();
            } else {
                return q1.remove();
            }
        }

        public int peek() {
            if (q1.isEmpty()) {
                return q2.peek();
            } else {
                return q1.peek();
            }
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
