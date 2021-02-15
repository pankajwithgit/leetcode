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
 */
class Solution {
    
    // Prepare a map keyed by column and value as a pair of row and value per node.
    Map<Integer, List<Pair<Integer, Integer>>> byColumnMap = new HashMap<>();
    int minCol = 0;
    int maxCol = 0;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> output = new ArrayList<>();
        
        // Comparator to sort based on value if their row is same or based on row if it is different.
        Comparator<Pair<Integer, Integer>> comparator = new Comparator<>() {
            
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                if(a.getKey() == b.getKey()) {
                    return a.getValue() - b.getValue();
                } else {
                    return a.getKey() - b.getKey();
                }
            }
        };
        
        
        for(int i = minCol; i <= maxCol; i++) {
            List<Pair<Integer, Integer>> list = byColumnMap.get(i);
            
            Collections.sort(list, comparator);
            
            List<Integer> sortedColumn = new ArrayList<>();
            
            for(Pair<Integer, Integer> p : list) {
                sortedColumn.add(p.getValue());
            }
            
            output.add(sortedColumn);
        }
        
        return output;
    }
    
    private void dfs(TreeNode node, int row, int col) {
        if(node == null) return;
        
        if(!byColumnMap.containsKey(col)) {
            byColumnMap.put(col, new ArrayList<>());
        }
        
        byColumnMap.get(col).add(new Pair(row, node.val));
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
