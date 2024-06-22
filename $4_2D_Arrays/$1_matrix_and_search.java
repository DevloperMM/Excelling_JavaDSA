package $4_2D_Arrays;

import java.util.Scanner;
public class $1_matrix_and_search {
    public static boolean search(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at cell (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length;
        int m = matrix[0].length;
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the 2D array");
        for (int i=0; i<n; i++) {
            System.out.print("Enter"+(i+1)+"Row elements ");
            for (int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        //output
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter the number you want to find ");
        int key = sc.nextInt();
        search(matrix, key);
    }
}
