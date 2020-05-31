class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minSoFar = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(minSoFar < prices[i]) {
                if(maxProfit < prices[i] - minSoFar) {
                    maxProfit = prices[i] - minSoFar;    
                }
            } else {
                minSoFar = prices[i];
            }
        }
        return maxProfit;
    }
}
