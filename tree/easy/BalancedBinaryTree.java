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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(getHeight(root) > -1) return true;
        
        return false;
    }
    
    // returning height as -1 will signify sub tree is not balanced.
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        if(leftHeight == -1 || rightHeight == -1) return -1;
        
        
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
