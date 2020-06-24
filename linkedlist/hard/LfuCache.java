/*
O(1) for both get and put using 2 maps and a custom doubly linked list.

Daily Coding Problem: Problem #67 [Hard]. asked by Google.

*/
class LFUCache {
    private int capacity;
    private int size;
    private int minFreq; // keep track of min freq, will be used for eviction
    private Map<Integer, Node> nodeMap; // will be handy to return a node with O(1)
    private Map<Integer, DLList> countMap; // Maintains doubly linkedlist per freq count in a map

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) return -1; // if not there in map
        updateNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        
        if(nodeMap.containsKey(key)) { // if found already, just update the value and frequency
            Node node = nodeMap.get(key);
            node.val = value;
            updateNode(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            if(size == capacity) { // capacity check, if full, evict
                DLList lst = countMap.get(minFreq);
                nodeMap.remove(lst.removeFromLast().key);
                size--;
            }
            size++;
            minFreq = 1; // min freq will reset to 1
            DLList newList = countMap.getOrDefault(node.count, new DLList());
            newList.add(node);
            countMap.put(node.count, newList);
        }
    }
    
    // Updates a node by moving it to appropriate doubly linkedlist as per new freq for it. 
    private void updateNode(Node node) {
        DLList oldList = countMap.get(node.count);
        oldList.remove(node);
        if(node.count == minFreq && oldList.size == 0) minFreq++; // Check if we need to update the min freq variable.
        node.count++;
        DLList newList = countMap.getOrDefault(node.count, new DLList());
        newList.add(node);
        countMap.put(node.count, newList);
    }
    
    // Class to maintain node info.
    class Node {
        int key;
        int val;
        int count;
        Node next;
        Node prev;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }
    
    // Custom doubly linked list class
    class DLList {
        Node head;
        Node tail;
        int size;
        
        public DLList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public Node removeFromLast() {
            if(size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
