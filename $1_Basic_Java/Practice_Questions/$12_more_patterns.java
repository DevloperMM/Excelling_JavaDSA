package $1_Basic_Java.Practice_Questions;

public class $12_more_patterns {
    public static void num_pyramid(int n) {
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            //numbers
            for (int j=1; j<=i; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void num_palindrome(int n) {
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //descending
            for (int j=i; j>=1; j--) {
                System.out.print(j+" ");
            }
            //ascending
            for (int j=2; j<=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static int fact(int num) {
        int f = 1;
        for (int i=1; i<=num; i++){
            f = f * i;
        }
        return f;
    }
    public static int nCr(int n, int r) {
        int bc = fact(n) / (fact(r) * fact(n-r));
        return bc;
    }
    public static void pascal_triangle(int n) {
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            //nCr
            for (int j=1; j<=i; j++) {
                System.out.print(nCr(i-1,j-1)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // num_pyramid(9);
        // num_palindrome(7);
        pascal_triangle(5);
    }
}
