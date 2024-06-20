package $13_Stacks;

import java.util.*;
public class $7_duplicate_parantheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            //closing
            if (ch == ')') {
                int count = 0;
                // //Method-1
                // while (s.peek() != '(') {
                //     count++;
                //     s.pop();
                // }
                // if (count < 1) {
                //     return true; //duplicate yes
                // } else {
                //     s.pop(); //opening pair
                // }

                //Method-2
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }

            } else {
                //opening
                s.push(ch);
            }
        }

        return false;
    }
    public static void main(String[] args) {

        // Assuming given a valid string
        String str = "((a+b))";
        String str2 = "(a-b)";
        System.out.println("Duplicate Parantheses = "+isDuplicate(str));
        System.out.println("Duplicate Parantheses = "+isDuplicate(str2));

    }
}
