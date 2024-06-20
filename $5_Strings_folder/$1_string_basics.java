package $5_Strings_folder;

import java.util.*;
public class $1_string_basics {
    public static void main(String[] args) {
        //char ch[] = {'a','b','c','d'};

        //1. ways to declare a string
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = new String("abcd");
        
        //2. input
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String fullname = sc.nextLine();
        System.out.println(name);
        System.out.println(fullname);

        //3. length function
        System.out.println(name.length());

        //4. concatenation
        System.out.println(name + " " + fullname);

        //5. compare function
        if (str1 == str2) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

        if (str1 == str3) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

        if (str1.equals(str3)){
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }
}
