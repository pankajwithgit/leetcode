// BFS approach. O(n) time and O(n) space.
class Solution {
    public int jump(int[] nums) {
        if(nums == null) return 0;
        
        int len = nums.length;
        if(len < 2) return 0;
        int steps = 0;
        
        // We will maintain visited elements in an array.
        int[] visited = new int[len];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;
        
        while(!q.isEmpty()) {
            steps++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int index = q.poll();
                                
                int element = nums[index];
                for(int j = 1; j <= element; j++) {
                    int nextIndex = index + j;
                    
                    // Check if next index is the last index.
                    if(nextIndex == len - 1) return steps;

                    if(visited[nextIndex] != 1) {
                        q.add(nextIndex);
                        visited[nextIndex] = 1;
                    }
                }
            }   
        }
        return steps;
    }
}
