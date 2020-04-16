/* 
DP solution. We can also solve this problem using BFS. But it will consume a lot more time for processing for larger inputs. A DP solution works perfectly.
BFS solution: https://github.com/pankajwithgit/leetcode/blob/master/matrix/Medium/MinimumPathSumUsingBFS.java
*/
class Solution {
    public int minPathSum(int[][] grid) {
        // base case
        if(grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] cache = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(i == 0 && j == 0) { // Top left corner
                    cache[i][j] = grid[i][j];
                } else if(i == 0) { // first row
                    cache[i][j] = grid[i][j] + cache[i][j - 1];
                } else if(j == 0) { // first col
                    cache[i][j] = grid[i][j] + cache[i - 1][j];
                } else { // rest of cells
                    cache[i][j] = grid[i][j] + Math.min(cache[i][j - 1], cache[i - 1][j]);
                }
            }
        }
        
        return cache[rows - 1][cols - 1];
    }
}
