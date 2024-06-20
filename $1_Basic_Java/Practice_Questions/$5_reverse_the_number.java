package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $5_reverse_the_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // while (n > 0) {
        //     int lastdigit = n % 10;
        //     System.out.print(lastdigit);
        //     n = n/10;
        // }

        int reverse = 0;
        while (n > 0) {
            int lastdigit = n % 10;
            reverse = reverse * 10 + lastdigit;
            n = n/10;
        }
        System.out.println(reverse);
    }
}
