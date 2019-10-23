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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> results = new LinkedList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            // Approach level by level
            int totalSiblings = q.size();
            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < totalSiblings; i++) {
                TreeNode node = q.poll();
                nodes.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            results.add(0, nodes);
        }
        return results;
    }
}
