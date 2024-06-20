package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $9_rangeOf_primeNo {
    public static boolean isPrime(int n) {
        // corner case
        if (n == 2) {
            return true;
        }

        // METHOD_01 --> Normal
        // for (int i=2; i<=n-1; i++) {
        //     if (n%i == 0) {
        //         return false;
        //     }
        // }
        // return true;

        // METHOD_02 --> Optimised
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    // METHOD - 01
    public static void primeRange(int num) {
        System.out.println(2);

        for (int i=3; i<=num; i++) {
            boolean prime = true;
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i%j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime == true) {
                System.out.println(i);
            }
        }
    }
    // METHOD - 02
    public static void primeNoRange(int n) {
        for (int i=2; i<=n; i++) {
            if (isPrime(i)) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Prime no. in 1 and ");
        int n = sc.nextInt();
        // primeRange(n);
        primeNoRange(n);   
    }
}
