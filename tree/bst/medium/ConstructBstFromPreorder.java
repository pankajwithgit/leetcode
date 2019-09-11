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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode tree=null;
        for(int i=0;i < preorder.length;i++){
            tree = place(tree, preorder[i]);
        }
        return tree; 
    }
    
    private TreeNode place(TreeNode root, int element) {
        if(root == null) return new TreeNode(element);
        
        if(root.val > element) {
            root.left = place(root.left, element);
        } else {
            root.right = place(root.right, element);
        }
        return root;
    }
}
