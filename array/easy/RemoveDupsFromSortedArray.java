// This will be a two pointer solution, one slow and one fast. 
class Solution {
    public int removeDuplicates(int[] nums) {
        // Base cases
        if(nums == null) return 0;
        if(nums.length == 1) return 1;
        
        int len = nums.length;
        int p1 = 0;
        int p2 = 1;
        
        while(p2 < len) {
            if(nums[p2] != nums[p1]) { // As soon as we find distinct element, copy it to next position to P1 and increment p1.
                p1++;
                nums[p1] = nums[p2];
            } else { // look at the next element
                p2++;
            }
        }
        return p1 + 1; // length would be 1 more than p1 index.
    }
}
