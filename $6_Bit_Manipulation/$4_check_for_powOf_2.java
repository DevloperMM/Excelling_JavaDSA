package $6_Bit_Manipulation;

public class $4_check_for_powOf_2 {
    public static boolean isPow_ofTwo(int n) {
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(isPow_ofTwo(15));
        System.out.println(isPow_ofTwo(16));
    }
}
