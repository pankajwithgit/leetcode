/*
BFS solution. We have to respect the constraints as well i.e. |x| + |y| <= 300. |x| means absolute 
value for x.
*/
class Solution {
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        // Define the moves a knight can take.
        int[][] moves = new int[][] {{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1}};
        
        Set<Integer> visited = new HashSet<>();
        visited.add(1001 * 0 + 0);
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] position = queue.poll();
                
                if(position[0] == x && position[1] == y) {
                    return steps;
                }
                
                for(int j = 0; j < moves.length; j++) {
                    int newX = position[0] + moves[j][0];
                    int newY = position[1] + moves[j][1];
                    // check if potential new location is out of bounds as per constraints.
                    if(Math.abs(newX) + Math.abs(newY) > 300) {
                        continue;
                    }
                    // Convert the new location into a hash.
                    int hash = 1001 * newX + newY;
                    if(!visited.contains(hash)) {
                        queue.add(new int[] {newX,newY});
                        visited.add(hash);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
