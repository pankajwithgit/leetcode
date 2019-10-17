/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
Idea: In the first pass,copy just all the elements first. Then in second pass, grab and set both the next and random references.
This solution is O(N) time and O(N) space. We can even do this in O(N) time and O(1) constant space:
See: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43632/Java-very-simple-and-clean-solution-with-O(n)-time-O(1)-space-(with-algorithm)
https://www.youtube.com/watch?v=OvpKeraoxW0
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        while(current != null) {
            Node newNode = new Node();
            newNode.val = current.val;
            map.put(current, newNode);
            current = current.next;
        }
        
       for (Map.Entry<Node, Node> entry : map.entrySet()) {
            final Node newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        
        return map.get(head);
    }
}
