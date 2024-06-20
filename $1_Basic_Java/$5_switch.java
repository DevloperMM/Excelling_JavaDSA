package $1_Basic_Java;
public class $5_switch {
    public static void main(String[] args) {
        int number = 5;
        switch (number) {
            case 1 : System.out.println("samosa");
                        break;
            case 2 : System.out.println("burger");
                        break;
            case 3 : System.out.println("mango shake");
                        break;
            default : System.out.println("wake out of sleep");
        }
    }
}

// WE CAN ALSO USE WITH OTHER DATA TYPES IN SWITCH LIKE AS FOLLOW

// char ch = 'a';
//     switch (char) {
//         case 's' : System.out.println("samosa");
//                     break;
//         case 'b' : System.out.println("burger");
//                     break;
//         case 'm' : System.out.println("mango shake");
//                     break;
//         default : System.out.println("wake out of sleep")
//     }