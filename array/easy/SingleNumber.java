class Solution {
    public int singleNumber(int[] nums) {
        // Base case
        if(nums == null || nums.length == 0) return -1;
        
        // Populate frequency map first.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        // Iterate over map and return the element with single occurance.
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
