/*
Problem can be seen as scanning n rows, n cols and 2 diagonals for each move.
Diagonal 1 can be the cells with equal row and col values. Such as 00,11,22,33 etc
Diagonal 2 can be the cells having sum equal to n-1 i.e. row+col = n-1 such as 03,12,21,30 etc
*/
class TicTacToe {

    /** Initialize your data structure here. */
    int[] row1; // contains count of X for each row for player 1
    int[] row2; // contains count of 0 for each row for player 2
    int[] col1; // contains count of X for each col for player 1
    int[] col2; // contains count of 0 for each col for player 2
    int[] diag1;// contains count of X for both diagonals for player 1
    int[] diag2;// contains count of 0 for both diagonals for player 2
    int n;
    public TicTacToe(int n) {
        this.n = n;
        row1 = new int[n];
        row2 = new int[n];
        col1 = new int[n];
        col2 = new int[n];
		// 2 types of diagonal
        diag1 = new int[2];
        diag2 = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            row1[row]++;
            col1[col]++;
            if (row1[row] == n || col1[col] == n) {
                return 1;
            }
            if (row == col) {
                diag1[0]++;
                if (diag1[0] == n) return 1;
            }
            if(row+col == n-1) {
                diag1[1]++;
                if (diag1[1] == n) return 1;
            }
            return 0;
        } else {
            row2[row]++;
            col2[col]++;
            if (row2[row] == n || col2[col] == n) {
                return 2;
            }
            if (row == col) {
                diag2[0]++;
                if (diag2[0] == n) return 2;
            }
            if(row+col == n-1) {
                diag2[1]++;
                if (diag2[1] == n) return 2;
            }
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
