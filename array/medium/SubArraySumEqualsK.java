// More details: https://leetcode.com/problems/subarray-sum-equals-k/discuss/337815/14ms-Java-Solution
// and https://leetcode.com/problems/subarray-sum-equals-k/discuss/301857/O(n)-time-Java-8-solution-with-the-clear-explanation
class Solution {
    public int subarraySum(int[] nums, int k) {
        // Store the sum frequencies in a Map.
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i = 0; i <= nums.length - 1; i++) {
            sum += nums[i];
            if(sum == k) ans++;
            if(map.containsKey(sum - k)) ans += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
