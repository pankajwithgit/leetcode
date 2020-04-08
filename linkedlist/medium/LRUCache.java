/**
 * LRU cache. When cache is full, evict stalest entry.
 *  
 * The cache itself is a doubly linked list where items at the tail get evicted first.
 * So new items are inserted into the head of the list.
 * 
 * Need a hash table mapping keys to Nodes for quick lookup.
 * 
 * Can't use java's LinkedList because for efficient removal we must update pointers
 * directly on Nodes returned from the map.
 */
class LRUCache {
    private int capacity;
    private Map<Integer, Node> data; // For O(1) retreival for get(key) operation.
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        this.head = new Node(-1, -1); // dummy head
        this.tail = new Node(-1, -1); // dummy tail
        this.head.next = tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(!data.containsKey(key)) return -1;
        
        Node node = data.get(key);
        promoteToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // check if key/value already exists. Capacity will not change in this case. Just the value update will happen.
        if(data.containsKey(key)) {
            Node node = data.get(key);
            node.val = value;
            promoteToHead(node);
            return;
        }
        
        if(data.size() == capacity) {
            Node nodeToBeRemoved = tail.prev;
            remove(nodeToBeRemoved);
            data.remove(nodeToBeRemoved.key);
        }
        
        Node newNode = new Node(key, value);
        data.put(key, newNode);
        addToFront(newNode);
    }
    
    // Will remove the node from linked list and add it again in front.
    private void promoteToHead(Node node) {
        if(head != node) {
            remove(node);
            addToFront(node);
        }
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    public void printCache() throws Exception {
		if( head.next == tail ) {
			throw new Exception("empty cache!");
		}
		Node n = head.next;
		System.out.print("[ ");
		while( n != tail ) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println("]");
	}
    
    private class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
