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
    private int depthX;
    private int depthY;
    private TreeNode parentX;
    private TreeNode parentY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return depthX == depthY && parentX != parentY;
    }
    
    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent)  {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        } else if (root.val == y) {
            depthY =depth;
            parentY = parent;
        }
        helper(root.left, x, y, depth + 1, root);
        helper(root.right, x, y, depth + 1, root);
    }
}
