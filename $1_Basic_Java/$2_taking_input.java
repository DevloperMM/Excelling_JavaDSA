package $1_Basic_Java;
import java.util.*;

public class $2_taking_input {
    public static void main(String[] args) {
        // Scanner sc = new Scanner (System.in);
        // // String input = scn.next();

        // String name = sc.nextLine();
        // System.out.println(name);

        //Question
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Something");
        // sc.useDelimiter("+");
        //Learn about the above method of Scanner Class
        int i = sc.nextInt();
        double d = sc.nextDouble();
        sc.nextLine();
        //This is used to consume the next line created due to the use of nextDouble
        String str = sc.nextLine();
        System.out.println("String: "+str);
        System.out.println("Double: "+d);
        System.out.println("Int: "+i);
    }
}

