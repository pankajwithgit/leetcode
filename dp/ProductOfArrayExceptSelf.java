// Challenge in this problem is to just use O(1) extra space and we can't use division operator.
// We will first build product on the left side for each index and then later update it to also include product on right side of each index.
class Solution {
    public int[] productExceptSelf(int[] nums) {        
        int len = nums.length;
        int[] res = new int[len]; // Output array. This array will be used to initially to prepare left product total and then will be updated
        // to include right product.
        
        res[0] = 1;
        
        // First, let's prepare the total product value on the left at each index.
        for(int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int rightProd = 1; // We will keep total product on right side as a running variable.
        for(int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * rightProd;
            rightProd = rightProd * nums[i]; // Keep updating the right prod total.
        }
        return res;
    }
}
