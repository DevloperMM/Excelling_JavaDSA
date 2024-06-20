package $8_Recursion;

public class $5_unique_char_string {

    // Recursion method
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map) {

        //base condition
        if (idx==str.length()) {
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if (map[currChar-'a'] == true) {
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    // Iteration Method
    public static String removeDuplicates(String str, StringBuilder newStr, boolean[] map) {
        for (int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);
            if (map[currChar-'a'] != true) {
                map[currChar-'a'] = true;
                newStr.append(currChar);
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        
        String word = "appnnacoollege";
        System.out.println(word);
        removeDuplicates(word, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(removeDuplicates(word, new StringBuilder(""), new boolean[26]));
    }
}
