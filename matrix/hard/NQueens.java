// It is a classic backtrack problem. When a certain direction doesn't result in a successful placement of queens, we backtrack.
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();

        char[][] board = new char[n][n];
        
        // Populate the board with '.' first.
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                board[x][y] = '.';
            }            
        }
        // Start backtracking process.
        backtrack(board, 0, results);
        return results;
    }
    
    private void backtrack(char[][] board, int colIndex, List<List<String>> results) {
        // When we have crossed the last col, we update the results.
        if(colIndex == board.length) {
            results.add(construct(board));
        }
        
        // Loop over all the rows.
        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, colIndex)) {
                board[row][colIndex] = 'Q';
                backtrack(board, colIndex + 1, results); // If Q placement is not possible on colIndex+1, this will return nothing and next line will backtrack the value back to '.'.
                board[row][colIndex] = '.';
            }
        }
    }
        
    // This method is supposed to validate a cell on the board to find out whether is it safe to place a Q.
    private boolean validate(char[][] board, int row, int col) {
        int r,c;
        
        // scan all cells on the same row and on the left side only.
        for(c = 0; c < col; c++) {
            if(board[row][c] == 'Q') return false;
        }
            
        // check all upper diagonal cells on left side only. 
        for(r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q') return false;
        }
            
        // check all lower diagonal cells on left side only.
        for(r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if(board[r][c] == 'Q') return false;
        }
        return true;
    }
        
    // Contruct response list.
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
