package $10_BackTracking;

public class $6_find_grid_ways {
    public static int fact(int n) {
        if (n==0) {
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n*fnm1;
        return fn;
    }

    public static int optimisedWays(int i, int j, int n, int m) {
        return fact(n+m-2) / (fact(n-1) * fact(m-1));
    }

    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if (i == n-1 && j == m-1) {//condition for last cell
            return 1;
        } else if (i == n || j == m) {//condition for crossing the boundary
            return 0;
        }
        
        //recursion
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(optimisedWays(0, 0, n, m));
    }
}
