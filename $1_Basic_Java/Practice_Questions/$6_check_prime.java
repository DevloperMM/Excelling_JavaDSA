package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $6_check_prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ");
        int n = sc.nextInt();

        if (n == 2) {
            System.out.println(n+"is prime");
        } else {
            boolean isprime = true;

            // for (int i = 2; i <= n-1; i ++) --> Normal Logic
            for (int i = 2; i <= Math.sqrt(n); i ++) { // Optimised here
                if (n % i == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime == true) {
                System.out.println(n+" is prime");
            } else {
                System.out.println(n+" is not prime");
            }

        }
    }
}
