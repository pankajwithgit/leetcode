/* We can't rob any two subsequent houses. Hence, for every house, we have to skip robbing very next house. This is a typical
DP problem. So, for a index i, we have to skip i+1 index and rob either i+2 or i+3 index houses, whichever is max. We will
start to build cache from back end to the front.
*/
class Solution {
    public int rob(int[] nums) {
        // base case
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        if(len == 1) return nums[0];
                
        int[] cache = new int[len]; // cache for DP
                
        for(int i = len - 1; i >= 0; i--) {
            int firstOption = 0;
            if(i + 2 < len) {
                firstOption = cache[i + 2];
            }
            int secondOption = 0;
            if(i + 3 < len) {
                secondOption = cache[i + 3];
            }
            cache[i] = nums[i] + Math.max(firstOption, secondOption);
        }
        return Math.max(cache[0], cache[1]); // because either first or second index will have max value.
    }
}
