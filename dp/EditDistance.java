/*
DP solution. O(n * m) time complexity. Visualize the DP as a 2D array. For word1 = "horse", word2 = "ros":

  - r o s
- 0 1 2 3
h 1 1 2 3 
o 2 2 1 2     
r 3 2 2 2 
s 4 3 3 2
e 5 4 4 3

Remember that we start from dp[0][0], which is an empty string to an empty string.
This problem was asked by Google. Daily Coding Problem: Problem #31 [Easy]
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        
        for(int i = 1; i <= len1; i++) {
            char a = word1.charAt(i - 1);
            for(int j = 1; j <= len2; j++) {
                char b = word2.charAt(j - 1);
                if(a == b) {
                    dp[i][j] = dp[i - 1][j - 1];    
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
