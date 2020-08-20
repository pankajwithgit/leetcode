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
 
 Complexity Analysis

Time complexity : O(m*n). In worst case(skewed tree) traverse function takes O(m*n) time.

Space complexity : O(n). The depth of the recursion tree can go upto n. n refers to the number of nodes in s.
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    private boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
    
    private boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null){
            return false;
        }
        
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
}
