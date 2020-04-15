/* This is a DP problem. We will take bottom-up approach. 
Consider a string "21312". Total number of ways would be ("2"  + decode("1312")) or ("21" + decode(312)). 
So, num_ways("21312") = num_ways("1312") + num_ways("312"). Here, we see a need to have DP solution. 
More info: https://www.youtube.com/watch?v=qli-JCrSwuk&t=872s
*/
class Solution {
    public int numDecodings(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n];
    dp[0] = s.charAt(0) != '0' ? 1 : 0;
    for(int i = 1; i < n; i++) {
      int first = Integer.valueOf(s.substring(i, i+1)); // case with one char
      int second = Integer.valueOf(s.substring(i-1, i+1)); // case with 2 chars, we can't have more than 2 chars, because max value can be 26.
      if(first >= 1 && first <= 9) {
        dp[i] += dp[i-1];
      }
      if(second >= 10 && second <= 26) {
        dp[i] += i >=2 ? dp[i-2] : 1;
      }
    }
    return dp[n-1];
  }
}
