package $8_Recursion;

public class $6_friends_pairing {
    public static int pairingWays(int n) {
        //base case
        if (n==1 || n==2) {
            return n;
        }

        //kaam --> choice
        //single
        int fnm1 = pairingWays(n-1);
        //double
        int fnm2 = pairingWays(n-2);
        int pairWays = (n-1)*fnm2;

        //total ways
        return fnm1 + pairWays;
    }
    public static void main(String[] args) {
        System.out.println(pairingWays(3));
    }
}
