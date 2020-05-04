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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSum(root, sum, currentPath, results);
        return results;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> results) {
        if(root == null) return;
        currentPath.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum) {
            results.add(new ArrayList<Integer>(currentPath));
            return;
        }
        if(root.left != null) {
            pathSum(root.left, sum - root.val, currentPath, results);
            currentPath.remove(currentPath.size() - 1); // remove the left element that we added in recursive call in line 33
        }
        
        if(root.right != null) {
            pathSum(root.right, sum - root.val, currentPath, results);
            currentPath.remove(currentPath.size() - 1); // remove the right element that we added in recursive call in line 38
        }
    }
}
