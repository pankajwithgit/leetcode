// This is DP problem. Can also be done with BFS but that will timeout with bigger inputs.
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){ 
                if(i == 0 || j == 0){
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[n-1][m-1];
    }
    
    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
	    }
    }
}
