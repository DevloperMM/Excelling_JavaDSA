package $23_Dynamic_Programming;

public class $6_rod_cutting {
    public static int cutProfit(int price[], int len[], int totalRod) {
        int n = price.length;
        int dp[][] = new int[n+1][totalRod+1];

        for (int i=0; i<n+1; i++) {
            for (int j=0; j<totalRod+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<totalRod+1; j++) {
                if (len[i-1] <= j) { //valid
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
                }
                else { //not validw
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totalRod];
    }   
    public static void main(String[] args) {
        int len[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRod = 8;

        System.out.println(cutProfit(price, len, totalRod));
    }
}