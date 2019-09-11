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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        
        while(!stack1.isEmpty()) {
            TreeNode top = stack1.pop();
            stack2.push(top);
            if(top.left != null) stack1.push(top.left);
            if(top.right != null) stack1.push(top.right);
        }
        
        while(!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
