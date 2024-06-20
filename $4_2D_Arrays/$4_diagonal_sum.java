package $4_2D_Arrays;

public class $4_diagonal_sum {
    public static void sumOfDiag(int mat[][]) {
        // // Method : 1 --> O(n^2)
        // int sum = 0;
        // for (int i=0; i<mat.length; i++) {
        //     for (int j=0; j<mat[0].length; j++) {
        //         if (i==j) {
        //             sum += mat[i][j];
        //         } else if (i+j == mat.length-1) {
        //             sum += mat[i][j];
        //         }
        //     }
        // }
        // System.out.println("Sum of Diagonal Elements is " + sum);

        // Method : 2 --> O(n)
        int pd = 0;
        int sd = 0;
        for (int i=0; i<mat.length; i++) {
            // pd
            pd += mat[i][i];
            // sd
            if (i != mat.length-1-i) {
                sd += mat[i][mat.length-1-i];
            }
        }
        System.out.println("Sum of Diagonal Elements is " + (pd+sd));

    }
    public static void main(String[] args) {
        int mat1[][] = {{1,2,3,4},
                        {12,13,14,5},
                        {11,16,15,6},
                        {10,9,8,7}};
        
        int mat2[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        // Diagonal Sum exist only for square matrices (n*n)
        sumOfDiag(mat1);
        sumOfDiag(mat2);
    }
}
