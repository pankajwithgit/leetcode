// We will use Priority Queue to return the node with max freq. We will also maintain a map to keep frequency for each node.
class FreqStack {
    private PriorityQueue<Node> q;
    private Map<Integer, Integer> freqMap;
    private int pushIndex;

    public FreqStack() {
        pushIndex = 0;
        // Instantiate queue with a comparator to sort nodes in decending order first on the basis of freq. If freq
        // is same, sort on the basis of push index.
        q = new PriorityQueue<Node>((a,b) -> (b.freq != a.freq) ? b.freq - a.freq: b.pushIndex - a.pushIndex);
        freqMap = new HashMap<>();
    }
    
    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1); // Increment the frequency
        Node n = new Node(x, freqMap.get(x), pushIndex++);
        q.add(n);
    }
    
    public int pop() {
        Node n = q.poll();
        freqMap.put(n.val, freqMap.getOrDefault(n.val, 0) - 1); // decrement the frequency
        return n.val;
    }
    
    public class Node {
        int val;
        int freq;
        int pushIndex; // will keep push index of the elements.
        
        public Node(int val, int freq, int pushIndex) {
            this.val = val;
            this.freq = freq;
            this.pushIndex = pushIndex;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
