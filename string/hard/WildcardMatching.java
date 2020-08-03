/*
DP solution. Details: https://leetcode.com/problems/wildcard-matching/discuss/370736/Detailed-Intuition-From-Brute-force-to-Bottom-up-DP
*/
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; 

        dp[0][0] = true;
        
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j <= p.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = p.charAt(j - 1) == '*' && dp[i][j - 1];
                } else if(j == 0) {
                    dp[i][j] = false;
                } else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; 
                } else if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }    
        }
        return dp[s.length()][p.length()];
	}
}
