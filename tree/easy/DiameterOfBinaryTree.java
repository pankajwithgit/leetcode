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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        
        int depth = lDepth + rDepth;
        
        // Return the max depth between root, left and right
        return Math.max(depth, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
    
    private int depth(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
