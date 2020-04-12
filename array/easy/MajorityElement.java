class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
        }
        
        int threshold = nums.length / 2;
        for(Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if(entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
