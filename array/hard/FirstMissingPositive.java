/*
We can assert the answer must be in [1, len + 1], the len is the length of input array. Because if the answer is greater than len + 1, then [1, 2, ...., len + 1] must be in the array, but the array of len length only can store [1, 2, ..., len]. 
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // Iterate all -ve and 0 numbers and modify them to have len + 1 as value. We want to ignore these numbers.
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        
        // Now for each number n, go to corresponding index (n - 1, because index will be 1 less) and mark the number at that index as -ve.
        // This will ensure that the index is visited and we can ignore this now.
        for (int i = 0; i < len; i++) {
            int n = Math.abs(nums[i]);
            if (n <= len && nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            }
        }
        
        // now find the positive number and that would our result.
        int first = len + 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                first = i + 1;
                break;
            }
        }
        
        return first;
    }
}
