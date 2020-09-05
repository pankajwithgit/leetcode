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
    public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }
    
    private double[] helper(TreeNode root) {
        if(root == null) return new double[] {0, 0, 0};
        
        double[] left = helper(root.left);
        double[] right = helper(root.right);
        
        double sum = root.val + left[0] + right[0];
        double count = 1 + left[1] + right[1];
        double avg = sum / count;
        double maxAvg = Math.max(left[2], Math.max(right[2], avg));
        return new double[] {sum, count, maxAvg};
    }
}
