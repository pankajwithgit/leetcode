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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode findTree(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(inStart > inEnd || preIndex > preorder.length - 1) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = findTree(preIndex + 1, inStart, inIndex - 1, preorder,inorder);
        root.right = findTree(preIndex + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }  
}
