class MovingAverage {
    private Queue<Integer> q;
    private int size;
    private double total = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        addToQueue(val);
        return total / q.size();
    }
    
    private void addToQueue(int val) {
        if(q.size() == size) {
            Integer extract = q.poll();
            total -= extract;
        }   
        q.add(val);
        total += val;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
