// DP solution
// Detailed explanation: https://leetcode.com/problems/longest-palindromic-substring/discuss/151144/Bottom-up-DP-Logical-Thinking
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        
        int longestPalindromeStart = 0, longestPalindromeLength = 1;
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (longestPalindromeLength < end - start + 1) {
                            longestPalindromeStart = start;
                            longestPalindromeLength = end - start + 1;
                        }
                    }
                }

            }
        }
        
        return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
    }
}
