
/* Optimal way is to solve this problem with DP approach. We make a 2D array to solve small problem of same kind. Rules would be:
a) If two chars are equal, take the left diagonal value because there won't be any change in answer. For cell at (i, j), copy value
from cell (i-1, j-1).
b) If two chars are not equal, find min value from either top or left. For cell (i,j), find min of cell (i-1, j) and cell (i, j-1) because
we are interested in min number of steps to match the strings.
c) Keep first first indexes for edge case where both/either strings are blank.

Eg:
  - e a t
- 0 1 2 3
s 1 2 3 4
e 2 1 2 3
a 3 2 1 2(answer)

Asked on pramp as well: https://www.pramp.com/challenge/61ojWAjLJbhob2nP2q1O
*/
class Solution {
    public int minDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    
        for(int i = 0; i <= str1.length(); i++) {
          for(int j = 0; j <= str2.length(); j++) {
            if(i == 0) { // first row
              dp[i][j] = j;
              continue;
            } 
            if(j == 0) { // first col
              dp[i][j] = i;
              continue;
            }
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
              dp[i][j] = dp[i - 1][j - 1];
            } else {
              dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
          }
        }
        return dp[str1.length()][str2.length()];
    }
}
