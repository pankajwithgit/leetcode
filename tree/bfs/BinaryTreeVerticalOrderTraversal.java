/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 We need to visualize this problem as a matrix problem. Each vertical will be considered as a column in a matrix and will be 
 assigned a column #. Root will have 0, columns on left to root will be assigned -1, -2 etc. and columns on right will be 
 assigned 1 2 3 etc. We will then do a BFS to scan through and build a column map keyed by column# having a list of values having
 that column#.
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case
        if(root == null) return result;
        
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Position> q = new LinkedList<>();
        int column = 0;
        q.add(new Position(root, column));
        
        // We need to keep track of min and max column# in order to iterate over it afterwords. 
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        while(!q.isEmpty()) {
            Position position = q.poll();
            root = position.node;
            int col = position.column;
            
            if(root != null) {
                
                // Update column Map
                if(!columnMap.containsKey(col)) {
                    columnMap.put(col, new ArrayList<Integer>());
                }
                columnMap.get(col).add(root.val);
                
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                
                q.add(new Position(root.left, col - 1));
                q.add(new Position(root.right, col + 1));
            }
        }
        
        // Now prepare result.
        for(int i = minCol; i <= maxCol; i++) {
            result.add(columnMap.get(i));
        }
        return result;
    }
    
    private class Position {
        TreeNode node;
        int column;
        
        public Position(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
}
