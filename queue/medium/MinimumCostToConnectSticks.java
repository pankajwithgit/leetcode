class Solution {
    public int connectSticks(int[] sticks) {
        Queue<Integer> q = new PriorityQueue<>();
        int cost = 0;
        
        for(int i : sticks) {
            q.add(i);
        }
        
        while(q.size() != 1) {
            int x = q.poll();
            int y = q.poll();
            System.out.println("x: " + x + " y: " + y + " cost: " + cost);
            cost += x + y;
            q.add(x + y);
        }
        return cost;
    }
}
