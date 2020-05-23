/*
DP problem. 
More details:
https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
https://www.youtube.com/watch?v=_nCsPn7_OgI&t=386s
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        // Edge case
        if(s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // A string with len 1 will always be palindromic, hence fill 1 in diagonal cells.
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // here L denotes length of string. 
        for(int l = 2; l <= n; l++) {
            // find longest palindromic subsequence's length for each string size
            for(int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                
                if(s.charAt(i) == s.charAt(j)) {
                    if(l == 2) { // there are only 2 chars in string 
                        dp[i][j] = 2;    
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
