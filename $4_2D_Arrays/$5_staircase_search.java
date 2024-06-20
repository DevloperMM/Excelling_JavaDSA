package $4_2D_Arrays;

public class $5_staircase_search {
    public static boolean sorted_search(int mat[][], int key) {

        // // method:1 --> top right corner

        // int i = 0; //for row
        // int j = mat[0].length-1; //for column
        // while (i < mat.length && j >= 0) {
        //     if (mat[i][j] == key) {
        //         System.out.println("Key found at ("+i+","+j+")");
        //         return true;
        //     } else if (mat[i][j] < key) {
        //         i++;
        //     } else {
        //         j--;
        //     }
        // }

        // method:2 --> bottom left corner
        
        int i = mat.length-1;
        int j = 0;
        while (i >= 0 && j < mat[0].length) {
            if (mat[i][j] == key) {
                System.out.println("Key found at ("+i+","+j+")");
                return true;
            } else if (mat[i][j] < key) {
                j++;
            } else {
                i--;
            }
        }

        System.out.println("Key is not found !");
        return false;
    }
    public static void main(String[] args) {
        int mat[][] = {{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        int key = 35;
        sorted_search(mat, key);
    }
}
