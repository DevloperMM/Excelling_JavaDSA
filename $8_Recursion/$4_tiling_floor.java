package $8_Recursion;

public class $4_tiling_floor {
    public static int tilingWays(int n) { //2*n --> Floor Size
        //base case
        if (n==0 || n==1) {
            return 1;
        }

        //kaam
        //veritical
        int fnm1 = tilingWays(n-1);
        //horizontal
        int fnm2 = tilingWays(n-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;

        // Imp_Note --> We are getting answer by adding because vertical and horizantal are choices to complete the tiling work. And we know the addition rule of counting asserts that addition of no. of ways of all the choices will give the total no. of ways to do the work.
    }
    public static void main(String[] args) {
        System.out.println(tilingWays(3));
    }
}
