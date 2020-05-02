// DP problem. Explaination: https://www.youtube.com/watch?v=J2eoCvk59Rc
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
			return -1;

		if (amount <= 0)
			return 0;

        // This DP solution can be best visualized as a 2D cache solution, but 1D array is sufficient here! 
		int dp[] = new int[amount + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE; // keep dp[0] = 0, no need to fill it.
		}

		for (int am = 1; am < dp.length; am++) {
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= am) { // Only if the coin can be used.
					int sub = dp[am - coins[i]];
					if (sub != Integer.MAX_VALUE)
						dp[am] = Math.min(sub + 1, dp[am]);
				}
			}
		}
		return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
} 
