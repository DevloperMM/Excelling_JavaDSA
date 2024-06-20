package $1_Basic_Java;
import java.util.*;
public class $9_break_usage {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // WITHOUT BREAK STATEMENT
        // int n = sc.nextInt();
        // int r = n % 10;

        // while (r != 0) {
        //     System.out.print("your number is ");
        //     System.out.println(n);
        //     n = sc.nextInt();
        //     r = n % 10;
        // }

        while (true) {
            int n = sc.nextInt();
            if (n%10 == 0) {
                break;
            } else {
                System.out.println("Your number is "+n);
            }
        }
    }
}
