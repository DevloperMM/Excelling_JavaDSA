package $4_2D_Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class $_inbuilt_sorting {
    public static void main(String[] args) {

        //int matrix[][] = new int[5][3];
        int mat[][] = {{24,5},{5,6},{4,23},{1,2}};

        Arrays.sort(mat, Comparator.comparingDouble(o -> o[1]));
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("---------------");
        
        Arrays.sort(mat, Comparator.comparingDouble(o -> o[0]));
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
