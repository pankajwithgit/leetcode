/*
Sort the array. Ascend on first element in the pair. Find the longest increasing subsequence.
Ref: https://leetcode.com/problems/longest-increasing-subsequence/
*/
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        
        int i, j, max = 0, n = pairs.length;
        int dp[] = new int[n];
      
        for (i = 0; i < n; i++) dp[i] = 1;
        
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        for (i = 0; i < n; i++) if (max < dp[i]) max = dp[i];
        
        return max;
    }
}
