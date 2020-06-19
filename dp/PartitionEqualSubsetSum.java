/* DP solution. Explanation: https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
We can start with 2D array DP and eventually optimize it to 1D array DP.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if (sum % 2 != 0) {
        return false;
    }
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    
    for (int num : nums) {
        for (int i = sum; i > 0; i--) {
            if (i >= num) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
    }
    
    return dp[sum];        
    }
    
}
