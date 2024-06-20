package $13_Stacks;

import java.util.Stack;
public class $6_valid_parantheses {
    public static boolean isPair(Stack<Character> s, char ch) {
        if (s.peek() == '(' && ch == ')') {
            return true;
        } else if (s.peek() == '[' && ch == ']') {
            return true;
        } else if (s.peek() == '{' && ch == '}') {
            return true;
        }

        return false;
    }
    
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            //opening braces
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                //closing braces
                if (s.isEmpty()) {
                    return false;
                }
                // if (isPair(s, ch)) {
                //     s.pop();
                //}
                if ((s.peek() == '(' && ch == ')')
                    || s.peek() == '[' && ch == ']'
                    || s.peek() == '{' && ch == '}') {
                        s.pop();
                    }
                else {
                    return false;
                }
            }
        }

        return s.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}{"));
        System.out.println(isValid("([{}])[()]"));
    }
}
