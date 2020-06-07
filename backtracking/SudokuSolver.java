// Backtracking solution.
// This problem was asked by Dropbox.
// Daily Coding Problem: Problem #54 [Hard]
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    private boolean helper(char[][] board)
    {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
            if(board[i][j] == '.') {
              for(int c = 1; c <= 9; c++) {
                char ch = (char)(c + '0');
                if(isValid(board, i, j, ch)) {
                  board[i][j] = ch;
                  if(helper(board)) { // break if solution is found.
                    return true;
                  }
                  board[i][j] = '.'; // backtrack
                }
              }
              if(board[i][j] == '.') { // break if solution is not found.
                return false;
              }
            }
          }
        }
        return true;
    }
    
    /* A char is valid at a cell only if: 
    a) row it belongs to doesn't have same number already. 
    b) col it belongs to doesn't have same number already.
    c) sub-board it belongs to doesn't have same number already.
    */
    private boolean isValid(char[][] board, int i, int j, char c) {
    for(int y = 0; y < 9; y++) {  // scan through complete column.
      if(board[i][y] == c) return false;
    }
    for(int x = 0; x < 9; x++) { // scan through complete row.
      if(board[x][j] == c) return false;
    }
        
    // scan through complete 3*3 board to which the cell belongs.
    int rowIndex = (i / 3) * 3;
    int colIndex = (j / 3) * 3;
    
    for(int x = rowIndex; x < rowIndex + 3; x++) {
      for(int y = colIndex; y < colIndex + 3; y++) {
        if(board[x][y] == c) return false;
      }
    }
    return true;
  }
}
