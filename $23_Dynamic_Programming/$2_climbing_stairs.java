package $23_Dynamic_Programming;

public class $2_climbing_stairs {
    public static int countWays(int n, int ways[]) {
        if (n<0) {
            return 0;
        }
        if (n==0 || n==1) {
            return 1;
        }
        if (ways[n] != 0) {
            return ways[n];
        }
        
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways) + countWays(n-3, ways);
        return ways[n];
    }
    
    public static int countWaysTab(int n) {
        if (n<0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i=2; i<=n; i++) {
            if (i == 2) {
                dp[i] = dp[i-1] + dp[i-2]; //Assuming dp[-1] = 0
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int stair = -1;
        int ways[] = new int[stair+1];
        System.out.println(countWays(stair, ways));
        System.out.println(countWaysTab(stair));
    }
}
