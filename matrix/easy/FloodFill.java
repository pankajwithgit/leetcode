// BFS solution.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] a = {-1,1,0,0};
        int[] b = {0,0,-1,1};
        boolean[][] visited = new boolean[image.length][image[0].length];

        int targetColor = image[sr][sc];
        
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(sr,sc));
        visited[sr][sc] = true;
        
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            image[cell.x][cell.y] = newColor;
            
            for(int i = 0; i < a.length; i++) {
                int row = cell.x + a[i];
                int col = cell.y + b[i];
                if(isWithinBounds(image, row, col) && image[row][col] == targetColor && !visited[row][col]) {
                    q.add(new Cell(row, col));
                    visited[row][col] = true;
                }
            }
        }
        return image;
    }
    
    private boolean isWithinBounds(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
    
    class Cell {
        int x;
        int y;
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }
}
