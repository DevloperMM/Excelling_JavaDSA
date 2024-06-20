package $1_Basic_Java;
import java.util.*;
public class $10_continue_usage {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Enter your number ");
            int n = sc.nextInt();
            
            if (n % 10 == 0) {
                continue;
            }
            System.out.println("Number was : " +n);
        } while (true);
    }
}
