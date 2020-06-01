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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        return getPath(root, new StringBuilder());
    }
    
    private List<String> getPath(TreeNode node, StringBuilder path) {
        List<String> paths = new ArrayList<>();
    
        path.append(String.valueOf(node.val));
        
        if(node.left != null) {
            StringBuilder leftString = new StringBuilder(path.toString());
            List<String> leftPaths = getPath(node.left, leftString.append("->"));
            paths.addAll(leftPaths);
        }
        
        if(node.right != null) {
            StringBuilder rightString = new StringBuilder(path.toString());
            List<String> rightPaths = getPath(node.right, rightString.append("->"));
            paths.addAll(rightPaths);
        }
        if(paths.size() == 0) {
            paths.add(path.toString());
        }
        return paths;
    }
}
