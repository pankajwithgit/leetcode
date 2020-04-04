class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // Use set instead of list to remove dups if any.
        Set<String> results = new HashSet<>();
        
        if(board == null || board.length == 0 || words == null || words.length == 0) return new ArrayList<>(results);
        
        for(String word : words) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(0)) {
                        boolean exists = backtrack(board, word, i, j, 0);
                        if(exists) results.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) return true;
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || word.charAt(index) != board[i][j]) return false;
        
        char c = board[i][j];
        board[i][j] = '*';
        boolean response = backtrack(board, word, i + 1, j, index + 1) ||
                           backtrack(board, word, i - 1, j, index + 1) ||
                           backtrack(board, word, i, j + 1, index + 1) ||
                           backtrack(board, word, i, j - 1, index + 1);
        board[i][j] = c;
        return response;
    }
}
