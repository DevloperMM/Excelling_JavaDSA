package $6_Bit_Manipulation;

public class $2_check_odd_even {
    public static void oddOrEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }
    }
    public static void main(String[] args) {
        oddOrEven(3);
        oddOrEven(11);
        oddOrEven(12);
    }
}
