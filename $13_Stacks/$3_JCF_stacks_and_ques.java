package $13_Stacks;

import java.util.Stack;

public class $3_JCF_stacks_and_ques {
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    //Question1 - Add element at bottom
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
        return;
    }


    //Question2 - Reverse a string using Stack
    public static String reverseStr(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        
        StringBuilder result = new StringBuilder();
        while (! s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }


    //Question3 - Reverse a Stack
    public static void revStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int val = s.pop();
        revStack(s);
        pushAtBottom(s, val);
        return;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        
        // pushAtBottom(s, 4);
        // System.err.println(reverseStr("HelloWorld"));
        revStack(s);

        // printStack(s); //By this line, Stack is empty now
    }
}
