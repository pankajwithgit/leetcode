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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return pathSum(root, sum, false);
    }
    
    // tamperedSum means that whether sum has been reduced by root.val or not.
    private int pathSum(TreeNode root, int sum, boolean tamperedSum) {
        int path = 0;
        
        // if we have the match.
        if(root.val == sum)
            path = 1;

        if(root.left == null && root.right == null)
            return path;

        if(root.left != null){
            path += pathSum(root.left, sum - root.val, true);
            if (!tamperedSum)
                path += pathSum(root.left, sum, false);
        }   
        if(root.right != null){
            path += pathSum(root.right, sum - root.val, true);
            if (!tamperedSum)
                path += pathSum(root.right, sum, false);
        }   
        return path;
    }
}
