package $4_2D_Arrays;

public class $2_find_largest {
    public static void getLarge(int mat[][]) {
        int large = Integer.MIN_VALUE;
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] > large) {
                    large = mat[i][j];
                }
            }
        }
        System.out.println("The largest number in array is " + large);
    }

    public static void main(String[] args) {
        // int mat[][] = new int[3][3];
        int mat[][] = {{5,3,41},{10,1000,100}};
        
        //output
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        getLarge(mat);
    }
}
