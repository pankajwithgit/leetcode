class Solution {
    public int maxSubArray(int[] arr) {
    if(arr == null || arr.length == 0) {
      return 0;
    }
    if(arr.length == 1) {
      return arr[0];
    }
    int max = arr[0];
    int runningSum = arr[0];

    for(int i = 1; i < arr.length; i++) {
      // If running sum is < 0, reset to 0 because there is no fun keeping -ve value further.
      if(runningSum < 0) {
        runningSum = 0;
      }
      runningSum += arr[i];
      
      // Also keep track of max value so far.
      if(runningSum > max) {
        max = runningSum;
      }
    }
    return max;
    }
}
