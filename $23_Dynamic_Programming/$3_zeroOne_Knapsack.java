package $23_Dynamic_Programming;

public class $3_zeroOne_Knapsack {
// -----------------------------------------------------------------------------------------
    //Memoization: O(n*W)
    //If i remove dp(Matrix) from the fn, it will become the simple code of recursion
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        if (W==0 || n==0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n-1] <= W) { //valid
            //include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else { //not valid
            dp[n][W] = knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }
// ----------------------------------------------------------------------------------------
    //Tabulation: O(n*W)
    public static int knapsacktab(int val[], int wt[], int W) {
        //Initialization
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j=0; j<W+1; j++) {
            dp[0][j] = 0;
        }

        //Assign Meaning: i-->item(val, wt), j-->knapsackSize(W), dp[i][j] = profit

        //Algorithm
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<W+1; j++) {
                int v = val[i-1]; //ith item value
                int w = wt[i-1]; //ith item weight
                if (w <= j) { //valid
                    int ans1 = v + dp[i-1][j-w]; //Included and Profit
                    int ans2 = dp[i-1][j]; //Excluded and Profit
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else { //not valid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printDP(dp);
        return dp[n][W];
    }

    public static void printDP(int dp[][]) {
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }
    }
// ----------------------------------------------------------------------------------------
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        //Memoization
        int dp[][] = new int[val.length+1][W+1];
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, W, val.length, dp));

        //Tabulation
        System.out.println(knapsacktab(val, wt, W));
    }
}
