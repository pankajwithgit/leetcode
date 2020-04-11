// This is 2 pointer problem.
class Solution {
    public void moveZeroes(int[] nums) {
        // Base case
        if(nums == null || nums.length == 0) return;
        
        int p1 = 0; // Will iterate over all elements one-by-one
        int p2 = findNextNonZeroElement(nums, 0); // will iterate over all non-zero elements only.
        if(p2 == -1) return;
        while(p1 < nums.length) {
            //System.out.println("p1 = " + p1 + " p2: " + p2);
            if(nums[p1] == 0) {
                swap(nums, p1, p2);
            }
            p1++;
            p2 = findNextNonZeroElement(nums, p2 + 1);
            if(p2 == -1) return;
        }
    }
    
    private int findNextNonZeroElement(int[] nums, int start) {
        for(int i = start; i < nums.length; i++) {
            if(nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
