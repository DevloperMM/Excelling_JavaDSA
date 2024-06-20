package $10_BackTracking;

public class $5_nQueens_one_soln {
    public static void main(String[] args) {
        int n = 3;
        String board[][] = new String[n][n];
        //initialize
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = "~ ";
            }
        }
        
        if (nQueens(board, 0)) {
            System.out.println("Solution is Possible");
        } else {
            System.out.println("Solution is not possible with no Queens placed");
        }
        printBoard(board);
    }

    public static boolean nQueens(String board[][], int row) {
        //base case
        if (row == board.length) {
            // printBoard(board);
            return true;
        }

        //column loop
        for (int j=0; j<board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = "Q ";
                if (nQueens(board, row+1)) {
                    return true;
                }
                board[row][j] = "~ "; //remove queen - backtracking step
            }
        }

        return false;
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