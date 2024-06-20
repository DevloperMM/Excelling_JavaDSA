package $13_Stacks;

import java.util.ArrayList;

public class $1_array_stacks {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        //push function
        public void push(int data) {
            list.add(data);
        }

        //pop function
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        //peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        /* If the class is not static, making nested class object is not that easy
        but yes self-explanatory. For an instance, refer below lines - */
        // $1_array_stack outerObject = new $1_array_stack();
        // Stack st = outerObject.new Stack();

        st.push(4);
        st.push(6);
        st.push(23);
        st.push(10);

        //Printing Stack elements
        while (! st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
        /* If functions are made static, then they can be called directly through class
        without forming the object */

    }
}
