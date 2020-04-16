// We can solve this problem with BFS. But it will consume a lot more time for processing for larger inputs. A DP solution works perfectly.
// DP SOlution: https://github.com/pankajwithgit/leetcode/blob/master/dp/MinimumPathSumUsingDP.java
class Solution {
    public int minPathSum(int[][] grid) {
        // base case
        if(grid == null || grid.length == 0) return -1;
        
        int minSum = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0, grid[0][0]));
        
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            
            // Check exit condition.
            if(cell.x == rows - 1 && cell.y == cols - 1) { // if this is bottom right cell or not.
                int valSoFar = cell.valSoFar;
                if(valSoFar < minSum) { // update min so far.
                    minSum = valSoFar;
                }
                continue;
            }
            
            if(cell.x + 1 < rows) { // check for bottom cell.
                q.add(new Cell(cell.x + 1, cell.y, cell.valSoFar + grid[cell.x + 1][cell.y]));
            }
            
            if(cell.y + 1 < cols) { // check for right cell.
                q.add(new Cell(cell.x, cell.y + 1, cell.valSoFar + grid[cell.x][cell.y + 1]));
            }
        }
        return minSum;
    }
    
    private class Cell {
        int x;
        int y;
        int valSoFar;
        
        public Cell(int x, int y, int valSoFar) {
            this.x = x;
            this.y = y;
            this.valSoFar = valSoFar;
        }
        
        public String toString() {
            return "x: " + x + " y: " + y + " val: " + valSoFar;
        }
    }
}
