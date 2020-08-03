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
 *
 * For each node that we process, we have to find out 2 things: 
 * a) What is the max path sum if we just include that node and both of it's children and we keep updating global 'max' variable
 * b) return the path from that node, either left or right, because if that node has to be part of result path, then either it's left 
 * child will be considered or the right child (whichever gives max sum).
 *
 */
class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        
        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        
        // Update max sum
        max = Math.max(max, leftSum + rightSum + root.val);
        
        return root.val + Math.max(leftSum, rightSum);
    }
}
