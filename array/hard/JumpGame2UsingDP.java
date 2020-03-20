// It's a DP problem. We will continue to maintain and use min jumps required to reach
// each element and ultimately find out steps to reach last index. 
// O(n^2) time and O(n) space
class Solution {
    public int jump(int[] nums) {
        if(nums == null) return 0;
        
        int len = nums.length;
        if(len < 2) return 0;

        // We need to prepare a parallel array to maintain min jumps required to reach each element.
        int[] minJumps = new int[len];
        
        for(int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(isInRange(nums[j], j, i)) {
                    min = Math.min(min, minJumps[j] + 1);
                }
            }
            minJumps[i] = min;
        }
        return minJumps[len - 1];
    }
    
    // To check and see if current index can be reached from a particular index or not.
    private boolean isInRange(int fromElement, int fromIndex, int targetIndex) {
        return fromIndex + fromElement >= targetIndex;
    }
}
