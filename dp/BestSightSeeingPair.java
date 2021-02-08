class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        int len = A.length;
        int[] dp = new int[len];
        
        dp[len - 1] = A[len - 1] - (len - 1);
            
        for(int i = len - 2; i > 0; i--) {
            dp[i] = Math.max(dp[i + 1], A[i] - i);
        }
        
        for(int i = 0; i < len - 1; i++) {
            max = Math.max(max, A[i] + i + dp[i + 1]);
        }
        return max;
    }
}
