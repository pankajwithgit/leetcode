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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.right != null) {
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        } 
        return root;
    }
    
    public TreeNode successor(TreeNode node) {
        TreeNode curr = node.right;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    public TreeNode predecessor(TreeNode node) {
        TreeNode curr = node.left;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    
}
