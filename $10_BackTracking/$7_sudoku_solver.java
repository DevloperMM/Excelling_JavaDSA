package $10_BackTracking;

public class $7_sudoku_solver {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        //check for column
        for (int i=0; i<9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        //check for row
        for (int j=0; j<9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        //checking the grid
        int start_row = (row/3)*3;
        int start_col = (col/3)*3;

        for (int i=start_row; i<start_row+3; i++) {
            for (int j=start_col; j<start_col+3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if (row == 9) {
            return true;
        }

        //recursion
        //finding nextRow or nextCol
        int nextRow = row, nextCol = col+1;
        if (col+1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }
        //checking whether there is already a digit placed or not to call
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        //try to place if there is not placed
        for (int digit=1; digit<=9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {{1,0,8,7,2,0,0,0,5},
                        {0,0,2,0,0,8,0,0,0},
                        {0,0,0,0,0,9,0,7,0},
                        {0,0,9,3,4,0,0,5,0},
                        {0,0,0,0,0,7,0,0,0},
                        {0,6,0,0,0,0,0,0,1},
                        {9,0,0,0,0,0,4,0,0},
                        {0,0,4,2,5,0,0,3,0},
                        {0,0,0,0,8,0,0,0,0}};

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exist");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}