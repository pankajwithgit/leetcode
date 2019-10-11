/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Complexities:
Push = o(n)
pop = o(1)
top = o(1)
*/
class MyStack {
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        this.q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i++) {
            int top = q.remove();
            q.add(top);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        if(empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
