/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return null;
        
        List<Double> avgs = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            Integer count = q.size();
            double total = 0.0;
            
            // poll only the element belonging to current level
            for(int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                total += node.val;
                if(node.left!= null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
            }
            avgs.add(total/count);
        }
        return avgs;
    }
}
