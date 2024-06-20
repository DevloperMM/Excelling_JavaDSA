package $14_Queues;

import java.util.*;

public class $8_queuePop_stacks {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        //add element - O(1)
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        //remove element - O(n)
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack !!");
                return -1;
            }
            int top = -1; //this top is initialized with -1 bcoz we started with assumption of the empty stack inspite the case is already catered.

            // case-1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        //Actually this is the removing element step
                        break;
                    }
                    q2.add(top);
                }
            }
            else {
                //case-2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        //peek - O(n)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack !!");
                return -1;
            }
            int top = -1;

            //case-1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    //Break is not used as this time we are not removing the element
                    q2.add(top);
                }
            }
            else {
                //case-2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (! s.isEmpty()) {//write opposite of breaking condition
            System.out.println(s.pop());
        }
    }
}
