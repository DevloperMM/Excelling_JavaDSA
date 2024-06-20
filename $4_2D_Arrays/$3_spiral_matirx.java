package $4_2D_Arrays;

public class $3_spiral_matirx {
    public static void getSpiral(int mat[][]) {
        int startRow = 0;
        int endRow = mat.length-1;
        int startCol = 0;
        int endCol = mat[0].length-1;
        while (startRow <= endRow && startCol <= endCol) {
            //top
            for (int k=startCol; k<=endCol; k++) {
                System.out.print(mat[startRow][k]+" ");
            }

            //right
            for (int k=startRow+1; k<=endRow; k++) {
                System.out.print(mat[k][endCol]+" ");
            }

            //bottom
            for (int k=endCol-1; k>=startCol; k--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(mat[endRow][k]+" ");
            }

            //left
            for (int k=endRow-1; k>=startRow+1; k--){
                if (startRow == endRow) {
                    break;
                }
                System.out.print(mat[k][startCol]+" ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    } 
    public static void main(String[] args) {
        int mat[][] = {{1,2,3,4},
                        {12,13,14,5},
                        {11,16,15,6},
                        {10,9,8,7}};
        getSpiral(mat);
        // Spiral Matrix --> I can store elements at designated cell, update the cell index, print the array.
    }
}
