package $8_Recursion;

public class $1_recursion_realisation {

    public static void printDec(int n) {
        if (n==1) {
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
        return;
    }
    public static void printInc(int n) {
        if (n==1) {
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
        return;
    }
    public static int fact(int n) {
        if (n==0) {
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n*fnm1;
        return fn;
    }
    public static int sumNaturalNo(int n) {
        if (n==1) {
            return 1;
        }
        int fnm1 = sumNaturalNo(n-1);
        int fn = n+fnm1;
        return fn;
    }
    public static int fibo(int n) {
        if (n==0 || n==1) {
            return n;
        }
        int fnm1 = fibo(n-1);
        int fnm2 = fibo(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static boolean isSorted(int arr[], int i) {
        if (i==arr.length-1) {
            return true;
        }
        if (arr[i]>arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int power(int x, int n) {
        if (n==0) {
            return 1;
        }
        // int xnm1 = power(x, n-1);
        // int xn = x*xnm1;
        // return xn;
        return x*power(x, n-1);
    }
    public static int optimisedPow(int x, int n) {
        if (n==0) {
            return 1;
        }
        int halfPow = optimisedPow(x, n/2);
        int sqHalfPow = halfPow^2;
        if (n%2==0) {
            return x*sqHalfPow;
        }
        return sqHalfPow;
    }

    public static void main(String[] args) {
        // printDec(10);
        // System.out.println();

        // printInc(10);
        // System.out.println();

        System.out.println(fact(5));

        // System.out.println(sumNaturalNo(5));

        // System.out.println(fibo(30));

        // int arr[] = {1,8,12,0,2,3,4,5,6};
        // System.out.println(isSorted(arr, 0));

        //System.out.println(optimisedPow(2, 10));
    }
}