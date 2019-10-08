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
    TreeNode next = null;
    
    // We will start building linked list from back side and eventually build it backwords. 
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }    
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }
}
