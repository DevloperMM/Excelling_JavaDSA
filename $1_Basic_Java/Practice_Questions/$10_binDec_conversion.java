package $1_Basic_Java.Practice_Questions;

import java.util.*;
public class $10_binDec_conversion {
    public static int binToDec(int num) {
        int dec = 0;
        for (int power = 0; num > 0; power++) {
            int r = num % 10;
            num /= 10;
            dec += r * Math.pow(2, power);
        }
        return dec;
    }
    public static int decToBin(int num) {
        int bin = 0;
        for (int power=0; num!=0; power++) {
            int r = num % 2;
            num /= 2;
            bin += r * Math.pow(10, power);
        }
        return bin;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Binary to decimal");
        System.out.println("2. Decimal to Binary");

        System.out.print("Enter your operation ");
        int button = sc.nextInt();

        System.out.print("Enter the number ");
        int n = sc.nextInt();

        switch (button) {
            case 1 : System.out.println(binToDec(n));
                        break;
            case 2 : System.out.println(decToBin(n));
                        break;
            default : System.out.println("Wrong Input");
        }
    }
}
