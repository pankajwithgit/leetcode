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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // edge case
        if(root == null || p == null) return null;
        
        TreeNode node = null;
        
        // check if p has a right node, if yes; leftmost node on right tree will be result.
        if(p.right != null) {
            node = p.right;
            while(node.left != null) { // go as far left as possible
                node = node.left;
            }
            return node;
        } else { 
            // if there is no right child for p; means result is somewhere up in the tree.
            return inorderTraversal(root, p);
        }
    }
    
    /* Start from tree root and perform inorder traversal. The idea is to keep just one     
    previous node during the inorder traversal. If that previous node is equal to p, then 
    the current node is a successor of p.
    */
    private TreeNode inorderTraversal(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        int inorder = Integer.MIN_VALUE;
        
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(inorder == p.val) {
                return root;
            }
            inorder = root.val;
            
            // go one step right
            root = root.right;
        }
        
        // no successor found
        return null;
    }
}
