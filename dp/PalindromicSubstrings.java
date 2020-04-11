// It's a DP problem. 
//More details: https://leetcode.com/problems/palindromic-substrings/discuss/497599/Java-DP-intuitive-explanation-%2B-reasoning
class Solution {
    public int countSubstrings(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int numSub = 0;
    for (int i = 0; i < s.length(); i++) {
      // 1 char strings (always true)
      dp[i][i] = true;
      numSub++;      
      // 2 char strings
      if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1) ) {
        dp[i][i+1] = true;
        numSub++;
      }
    }
	// d is the distance from the current char, allows diagonal traversal
    for (int d = 2; d <= s.length(); d++) {
      for (int i = 0; i+d < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i+d) && dp[i+1][i+d-1]) {
          dp[i][i+d] = true;
          numSub++;
        }
      }
    }
    return numSub;
  }
}
