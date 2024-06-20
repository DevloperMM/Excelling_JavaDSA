package $10_BackTracking;

public class $4_N_Queens {

    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        String board[][] = new String[n][n];
        //initialize
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = "x ";
            }
        }
        nQueens(board, 0);
        System.out.println("N-Queens can be placed in = "+count+" ways");
        // printBoard(board);
    }

    public static void nQueens(String board[][], int row) {

        //base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        //loop for columns
        for (int j=0; j<board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = "Q ";
                nQueens(board, row+1);//fn call to set the queen
                board[row][j] = "x ";//remove queen after backtracking
            }
        }
    }

    public static boolean isSafe(String board[][], int row, int col) {
        //vertically up
        for (int i=row-1; i>=0; i--){
            if (board[i][col] == "Q ") {
                return false;
            }
        }

        //diagonally right up
        for (int i=row-1, j=col+1; i>=0 && j<=board.length-1; i--, j++) {
            if (board[i][j] == "Q ") {
                return false;
            }
        }

        //diagonally left up
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == "Q ") {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(String board[][]) {
        int n = board.length;
        System.out.println("----Chess Board----");

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
