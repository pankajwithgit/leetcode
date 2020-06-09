/*
Sort the array. Ascend on width and descend on height if width are same. Find the longest increasing subsequence based on height.
Ref: https://leetcode.com/problems/longest-increasing-subsequence/
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(envelopes.length == 0) return 0;
        Comparator<int[]> comp = new Comparator<int[]>() { 
            public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       }
        };
        
        Arrays.sort(envelopes, comp);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
    
        return max;
    }
  
}
