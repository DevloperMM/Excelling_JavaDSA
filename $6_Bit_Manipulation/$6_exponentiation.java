package $6_Bit_Manipulation;

public class $6_exponentiation {
    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n!=0) {
            if ((n&1) == 1) { //check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }

    public static int modularExpo(int a, int n, int x) {
        int ans = 1;
        while (n!=0) {
            if ((n&1) == 1) { //check LSB
                // ans = (ans % n * a % n) % n;
                // Clearly ans will not exceed n in any case as it modulus with n. So we can take (ans % n = ans).
                ans = (ans * a % x) % x;
            }
            a = ((a % x) * (a % x)) % x;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExpo(5, 5));
        System.out.println(modularExpo(2, 5, 100));
    }
}
