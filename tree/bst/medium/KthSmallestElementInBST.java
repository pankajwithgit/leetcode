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
 * kth smallest element can be reached by inorder traversing the tree iteratively. 
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int counter = 0;
        
        
        while(!stack.isEmpty() || root!= null) {
            while(root != null) { // keep going left
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // pop the element if no more left element exists
            counter++;
            if(counter == k) { // check if we are at k
                return root.val;
            }
            root = root.right; // take one right turn
        }
        return -1; // if k'th smallest element is not found
    }
}
