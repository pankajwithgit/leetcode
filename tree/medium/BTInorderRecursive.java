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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode next = stack.pop();
                list.add(next.val);
                root = next.right;
            }
        }
        return list;
    }
}
