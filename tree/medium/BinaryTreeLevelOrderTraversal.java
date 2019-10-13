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
    // Solve this as BFS using a queue. Challenge is to break results by subLists.
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            // Find number of nodes at each level
            int nodeCount = q.size();
            //Remove all nodes at a level one by one and parallely prepare nodes for next level.
            for(int i = 0; i < nodeCount; i++) {
                TreeNode node = q.remove();
                subList.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(subList);
        }
        return result;
    }
}
