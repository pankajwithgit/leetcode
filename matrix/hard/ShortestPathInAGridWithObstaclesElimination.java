// BFS solution with having 3D visited boolean array.
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        int m = grid.length;
        int n = grid[0].length;
        int steps = 0;
        
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                int currK = cell[2];
                
                if(r == m - 1 && c == n - 1) {
                    return steps;
                }
                
                for(int j = 0; j < dir.length; j++) {
                    int newR = r + dir[j][0];
                    int newC = c + dir[j][1];
                    int newK = currK;
                    if(newR >=0 && newR < m && newC >= 0 && newC < n) {
                        if(grid[newR][newC] == 1) {
                            newK++;
                        }
                        if(newK <= k && !visited[newR][newC][newK]) {
                            visited[newR][newC][newK] = true;
                            q.offer(new int[]{newR, newC, newK});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
