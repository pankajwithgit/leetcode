/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> existenceMap = new HashMap<>();
        return cloneDFS(node, existenceMap);
    }
    
    private Node cloneDFS(Node node, Map<Node,Node> existenceMap) {
        if(node == null) return null;
        
        if(existenceMap.containsKey(node)) return existenceMap.get(node);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        existenceMap.put(node, newNode);
        
        for(Node neighbor : node.neighbors) {
            if(existenceMap.containsKey(neighbor)) {
                newNode.neighbors.add(existenceMap.get(neighbor));
            } else {
                newNode.neighbors.add(cloneDFS(neighbor, existenceMap));
            }
        }
        return newNode;
    }
}
