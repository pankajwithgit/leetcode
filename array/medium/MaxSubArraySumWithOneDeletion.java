//It is easy to calculate the max subarray sum using DP.
//This problem is like a follow up to the max subarray problem.
//There are two case in the final result:

//case 1, we don't delete anything, which can be solved by max subarray problem
//case 2, we only delete one element.
//And There is one fact we need to know first:

//If we delete one element from array, this element must be a negative one. Why? because if we delete a positive one, it can be added back and make the sum larger.
//Therefore, we only need to check negative number in the final loop.
//We need two dp array, dp1 to store the max subarray ended with positive i. dp2 to store max subarray started at positive i.
//So the max sum of deleting arr[i] is dp[i-1] + dp[i+1].
class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 1) return arr[0];
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        dp1[0] = arr[0];
        dp2[n-1] = arr[n-1];
        int max = arr[0];
        
        for(int i=1; i<n; i++){
            dp1[i] = dp1[i-1] > 0 ? dp1[i-1] + arr[i] : arr[i];
            max = Math.max(max, dp1[i]);
        }
        for(int i=n-2; i>=0; i--){
            dp2[i] = dp2[i+1] > 0 ? dp2[i+1] + arr[i] : arr[i];
        }
        
        for(int i=1; i<n-1; i++){ 
            if(arr[i] < 0){
                max = Math.max(max, dp1[i-1] + dp2[i+1]); 
            }
        }
        return max;
    }
}
