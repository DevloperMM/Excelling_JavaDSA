package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $3_greater_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            System.out.println("a = "+a+" is greater");
        } else {
            System.out.println("b = "+b+" is greater");
        }
    }
}
