class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a ,b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> results = new LinkedList<>();
                
        for(int[] interval : intervals) {
            if(results.isEmpty() || results.getLast()[1] < interval[0]) {
                results.add(interval);
            } else {
                results.getLast()[1] = Math.max(results.getLast()[1], interval[1]);
            }
        }
        return results.toArray(new int[results.size()][2]);
    }
}
