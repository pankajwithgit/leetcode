/*
time O(nlogn), space O(n)
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //base case
        if(intervals == null || intervals.length == 0) return 0;
        
        // We will need to sort the meetings based on their start time in order to process them.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // We will use a priority queue to identify the first ending meeting so that we can find out
        // whether we need to allocate new room to next meeting or an existing meeting is getting over
        // and it's room can be reused.
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a - b);
        
        // Add end time of first meeting to queue
        queue.add(intervals[0][1]);
        
        // Process rest of the meetings.
        for(int i = 1; i < intervals.length; i++) {
            
            // If existing meeting is over by now, release that room.
            if(intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
            queue.add(intervals[i][1]);
        }
        
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return queue.size();
    }
}
