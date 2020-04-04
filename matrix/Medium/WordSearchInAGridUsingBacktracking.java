class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0) return true;

        int outerLength = board.length;
        int innerLength = board[0].length;
        
        for(int i = 0; i < outerLength; i++){
            for(int j = 0; j < innerLength; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(i, j, board, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(int i, int j, char[][] board, int index, String word) {
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean response;
        response = backtrack(i + 1, j, board, index + 1, word) || 
            backtrack(i - 1, j, board, index + 1, word) || 
            backtrack(i, j - 1, board, index + 1, word) ||
            backtrack(i, j + 1, board, index + 1, word);
        board[i][j] = c;
        return response;
    }
}
