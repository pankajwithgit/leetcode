/*
It's a DP problem. Details here: https://leetcode.com/problems/maximal-square/solution/
*/
class Solution {
    public int maximalSquare(char[][] matrix) {        
        // Check boundary condition.
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        // Initialize cache.
        int[][] cache = new int[matrix.length][matrix[0].length];
        
        int maxVal = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // If we are in the first row or column then the value is just
                // the same. In other rows and columns, need to look up and to the left and to the diagonal element
                if(i == 0 || j == 0) {
                    cache[i][j] = Character.getNumericValue(matrix[i][j]);
                }
                else if(matrix[i][j] == '1') {
                    cache[i][j] = Math.min(cache[i-1][j], 
                                       Math.min(cache[i][j-1], cache[i-1][j-1])) + 1;
                }
                
                // Keep track of max square size value
                if(cache[i][j] > maxVal) {
                    maxVal = cache[i][j];
                }
            }
        }
        return maxVal * maxVal;
    }
}
