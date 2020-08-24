/*
BFS solution. 
*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dirX = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] dirY = {-1, 0, 1, -1, 0, 1, -1, 1};
        int paths = 0;
        
        // If starting loc is '1', it's no results case.
        if(grid[0][0] == 1) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        grid[0][0] = 1;
        
        while(!q.isEmpty()) {
            paths++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] loc = q.poll();
                
                if(loc[0] == grid.length - 1 && loc[1] == grid.length - 1) {
                    return paths;
                }
                
                for(int j = 0; j < 8; j++) {
                    int newX = loc[0] + dirX[j];
                    int newY = loc[1] + dirY[j];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                        q.add(new int[]{ newX, newY });
                        grid[newX][newY] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
