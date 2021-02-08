/* Few facts:
1) The sum of the grid must be 45, as it is the sum of the distinct values from 1 to 9.
2) Each horizontal and vertical line must add up to 15, as the sum of 3 of these lines equals the sum of the whole grid.
*/
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        
        if(rows < 3 || cols < 3) {
            return result;
        }
        
        for(int i = 0; i < rows - 2; i++) {
            for(int j = 0; j < cols - 2; j++) {
                if(isMagical(grid[i][j],grid[i][j+1],grid[i][j+2],grid[i+1][j],
                            grid[i+1][j+1],grid[i+1][j+2],grid[i+2][j],grid[i+2][j+1],
                            grid[i+2][j+2])) {
                    result++;   
                }
            }
        }
        return result;
    }
    
    private boolean isMagical(int... vals) {
        // First check to see if all numbers are between 1 and 9 inclusive.
        int[] count = new int[16];
        for(int i : vals) {
            count[i]++;
        }
        for(int i = 1; i <=9; i++) {
            if(count[i] != 1) return false;
        }
        
        // now check if each row/col/diagonal are total 15 or not.
        if((vals[0] + vals[1] + vals[2] == 15) &&
            (vals[3] + vals[4] + vals[5] == 15) &&
            (vals[6] + vals[7] + vals[8] == 15) &&
            (vals[1] + vals[4] + vals[7] == 15) &&
            (vals[2] + vals[5] + vals[8] == 15) &&
            (vals[0] + vals[4] + vals[8] == 15) &&
            (vals[2] + vals[4] + vals[6] == 15)) {
            return true;
        }
        return false;
    }
}
