// Here are the steps we will follow :
// 1. Find the frequency of each number for each array and populate their frequency maps respectively.
// 2. Prepare a priority queue with elements from both maps and sort in decending order of their frequencies.
// 3. Process each element in queue to find min rotations.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> aFreqMap = new HashMap<>();
        Map<Integer, Integer> bFreqMap = new HashMap<>();
        
        // Find frequencies for all numbers in both arrays.
        for(int i = 0; i < A.length; i++) {
            aFreqMap.put(A[i], aFreqMap.getOrDefault(A[i], 0) + 1);
            bFreqMap.put(B[i], bFreqMap.getOrDefault(B[i], 0) + 1);
        }
        
        PriorityQueue<DominoData> queue = new PriorityQueue<DominoData>((a,b) -> b.freq - a.freq);
        
        // Move maps data to queue
        for(Map.Entry<Integer, Integer> e : aFreqMap.entrySet()) {
            queue.add(new DominoData(1, e.getKey(), e.getValue()));
        }
        
        for(Map.Entry<Integer, Integer> e : bFreqMap.entrySet()) {
            queue.add(new DominoData(2, e.getKey(), e.getValue()));
        }
        
        while(!queue.isEmpty()) {
            boolean moveToNext = false;
            int rotations = 0;
            int response = 0;
            DominoData element = queue.poll();
            response = (element.row == 1) ? scanThrough(element, A, B) : scanThrough(element, B, A);
            if(response != -1) return response;
        }
        return -1;
    }
    
    // Scans through one array to find min number of rotations needed.
    private int scanThrough(DominoData data, int[] arrayToBeScaned, int[] otherArray) {
        int rotations = 0;
        int val = data.val;
        for(int i = 0; i < arrayToBeScaned.length; i++) {
            if(arrayToBeScaned[i] == val) continue;
        
            if(otherArray[i] == val) {
                rotations++;
            } else {
                return -1;
            }
        }
        return rotations;
    }
    
    // Will contain row (A or B), number and it's frequency.
    public class DominoData {
        int row;
        int val;
        int freq;
        
        public DominoData(int row, int val, int freq) {
            this.row = row;
            this.val = val;
            this.freq = freq;
        }
    }
}
