// Overall O(nlogk) time complexity and o(n) space complexity.
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Base case.
        if(nums == null) return null;
        
        // Build the frequency map first. It will take O(n) considering n is number of elements in array.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        // Prepare a comparator for frequency comparison.
        Comparator<Integer> freqComparator = new Comparator<>() {
            
            @Override
            public int compare(Integer n, Integer m) {
                return freqMap.get(n) - freqMap.get(m);
            }
        };
        
        // Build a priority queue to keep k elements. Priority queue will be ordered by smallest frequency first, so keep pushing out element to just maintain k elements only. It will take O(nlogk) time.
        PriorityQueue<Integer> q = new PriorityQueue<>(freqComparator);
        for(Integer n : freqMap.keySet()) {
            q.add(n);
            if(q.size() > k) {
                q.poll();
            }
        }
        
        // Now we have k elements in queue with highest frequency, move them to results list.
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            results.add(q.poll());
        } 
        return results;
    }
}
