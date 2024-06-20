package $14_Queues;

import java.util.*;
public class $9_first_non_repeating {
    public static void firstNonRepeatingChar(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        firstNonRepeatingChar(str);

        System.out.println();
        
        String str2 = "apnacollege";
        firstNonRepeatingChar(str2);
    }
}
