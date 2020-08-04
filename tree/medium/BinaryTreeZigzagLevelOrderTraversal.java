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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if(root == null) return results;
        
        boolean fromLeft = true; // to check if we have to navigate from left side or right 
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(fromLeft) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            results.add(list);
            fromLeft = !fromLeft;
        }
        return results;
    }
}
