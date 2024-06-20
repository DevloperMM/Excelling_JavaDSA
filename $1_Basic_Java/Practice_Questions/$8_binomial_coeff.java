package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $8_binomial_coeff {
    public static int fact(int num) {
        int f = 1;
        for (int i=1; i<=num; i++){
            f = f * i;
        }
        return f;
    }
    public static int binCoeff(int n, int r) {
        int bc = fact(n) / (fact(r) * fact(n-r));
        return bc;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n ");
        int n = sc.nextInt();
        System.out.print("Enter r ");
        int r = sc.nextInt();
        System.out.println(binCoeff(n, r));
    }
}
