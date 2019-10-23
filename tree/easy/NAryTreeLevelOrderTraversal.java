/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            // Approach level by level
            int totalSiblings = q.size();
            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < totalSiblings; i++) {
                Node node = q.poll();
                nodes.add(node.val);
                if(node.children != null && !node.children.isEmpty()) {
                    q.addAll(node.children);
                }
            }
            results.add(nodes);
        }
        return results;
    }
}
