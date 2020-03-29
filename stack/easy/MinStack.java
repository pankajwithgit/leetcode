class MinStack {
    
    public class Node {
        int value;
        Node next;
        int min;
        
        public Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    Node top;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(top == null) {
            top = new Node(x, x, null);
        } else {
            top = new Node(x, Math.min(top.min, x), top);
        }
    }
    
    public void pop() {
        if(top == null) throw new NullPointerException();
        top = top.next;
    }
    
    public int top() {
        if(top == null) throw new NullPointerException();
        return top.value;
    }
    
    public int getMin() {
        if(top == null) throw new NullPointerException();
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
