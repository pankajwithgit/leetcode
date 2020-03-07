// Using BFS.
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        
        if(grid.length == 0) return 0;
        
        int totalOranges = 0;
        int rotten = 0;
        int time = 0;
        Queue<Position> q = new LinkedList<>();
        
        // Push all rotten oranges position to queue (to be processed) and find out total oranges.
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    totalOranges++;
                } 
                if(grid[i][j] == 2) {
                    q.add(new Position(i,j));
                }
            }
        }
        
        // If there are no oranges, return.
        if(totalOranges == 0) return 0;
        
        // Process till queue is empty and all oranges are not rotten. 
        while(!q.isEmpty() && rotten < totalOranges) {
            // total number of rotten oranges in the current round.
            int size = q.size();
            
            rotten += size;
            if(rotten == totalOranges) return time;
            
            // time will increase with each round.
            time++;
            
            for(int i = 0; i < size; i++) {
                Position pos = q.poll();
            
                if(pos.x + 1 < grid.length && grid[pos.x + 1][pos.y] == 1) {
                    grid[pos.x + 1][pos.y] = 2;
                    q.add(new Position(pos.x + 1, pos.y));
                }
                
                if(pos.x - 1 >= 0 && grid[pos.x - 1][pos.y] == 1) {
                    grid[pos.x - 1][pos.y] = 2;
                    q.add(new Position(pos.x - 1, pos.y));
                }
                
                if(pos.y + 1 < grid[0].length && grid[pos.x][pos.y + 1] == 1) {
                    grid[pos.x][pos.y + 1] = 2;
                    q.add(new Position(pos.x, pos.y + 1));
                }
                
                if(pos.y - 1 >= 0 && grid[pos.x][pos.y - 1] == 1) {
                    grid[pos.x][pos.y - 1] = 2;
                    q.add(new Position(pos.x, pos.y - 1));
                }
            }
        }
        // If not possible.
        return -1;
    }
    
    class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
