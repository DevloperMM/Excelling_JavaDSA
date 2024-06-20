package $15_Greedy_Algorithm;

import java.util.Arrays;

public class $3_absoluteDiff_pairs {
    public static void main(String[] args) { // O(nlogn) due to sorting
        int A[] = {4,1,8,7}; // {1,2,3}
        int B[] = {2,3,6,5}; // {2,1,3}

        Arrays.sort(A); // O(nlogn)
        Arrays.sort(B);

        int minDiff = 0; // O(n)
        for (int i=0; i<A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum absolute difference of pairs = " + minDiff);
    
    }
}
