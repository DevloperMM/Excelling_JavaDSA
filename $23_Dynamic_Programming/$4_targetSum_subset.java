package $23_Dynamic_Programming;

public class $4_targetSum_subset {
    public static boolean checkSubsetSum(int nums[], int sum) { //O(n * sum)
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for (int i=0; i<n+1; i++) {  //i -> items & j -> target sum
            dp[i][0] = true;
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<sum+1; j++) {
                int v = nums[i-1];
                //include
                if (v <= j && dp[i-1][j-v]) {
                    dp[i][j] = true;
                }
                //exclude
                else if (dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        printDP(dp);
        return dp[n][sum];
    }

    public static void printDP(boolean dp[][]) {
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (dp[i][j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 7, 1, 3};
        int target = 10;
        System.out.println(checkSubsetSum(nums, target));
    }
}
