package $23_Dynamic_Programming;

public class $1_fibonacci {
    public static int fib(int n) { //Recursion -> O(2^n)
        if (n==0 || n==1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static int fib2(int n, int f[]) { //Memoization -> O(n)
        if (n==0 || n==1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fib(n-1) + fib(n-2);
        return f[n];
    }
    public static int fib3(int n) { //Tabulation - O(n)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
        System.out.println(fib2(n, new int[n+1]));
        System.out.println(fib3(n));
    }
}
