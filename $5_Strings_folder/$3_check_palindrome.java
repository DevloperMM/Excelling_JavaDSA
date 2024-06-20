package $5_Strings_folder;

import java.util.*;
public class $3_check_palindrome {
    public static boolean palindrome(String str) {
        for (int i=0; i<str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to check for palindrome ");
        String str = sc.next();
        System.out.println(palindrome(str));
    }
}
