class HitCounter {
    private LinkedList<Second> q;
    private int hits;
    private int duration;

    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
        duration = 300;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        // clear seconds which are out of scope now.
        while(!q.isEmpty() && (timestamp - q.peek().timestamp > 299)) {
            hits -= q.peek().count;
            q.poll();
        }
        
        // check if this timestamp already exists
        if(!q.isEmpty() && q.peekLast().timestamp == timestamp) {
            q.peekLast().addCount();
            hits++;
        } else {
            q.offer(new Second(timestamp));
            hits++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && (timestamp - q.peek().timestamp > 299)) {
            hits -= q.peek().count;
            q.poll();
        }
        return hits;
    }
    
    // An object to store timestamp along with # of hits for that timestamp;
    public class Second {
        int timestamp;
        int count;
        
        public Second(int timestamp) {
            this.timestamp = timestamp;
            this.count = 1;
        }
        
        public void addCount() {
            count++;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
