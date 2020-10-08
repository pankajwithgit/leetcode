// DFS and memoization 
class Solution {
    int[][] dirs = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}};
    int[][] cache;
    
    public int longestIncreasingPath(int[][] matrix) {
        int longestPath = Integer.MIN_VALUE;
        if(matrix == null || matrix.length == 0) return 0;
        
        // Initialize the cache and fill it with -1.
        cache = new int[matrix.length][matrix[0].length];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int path = dfs(matrix, Integer.MIN_VALUE, i, j);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }
    
    public int dfs(int[][] matrix, int min, int x, int y) {
        // edge cases 
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return 0;
        }
        
        // breaking condition
        if(matrix[x][y] <= min) {
            return 0;    
        }
        
        // check in cache first
        if(cache[x][y] != -1) {
            return cache[x][y];
        }
        
        // update min for next level of calls
        min = matrix[x][y];
        
        int path = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            path = Math.max(path, dfs(matrix, min, newX, newY) + 1);   
        }
        // update cache
        cache[x][y] = path;
        
        return path;
    }
}
