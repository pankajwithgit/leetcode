/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

To avoid using extra space, we flag which elements we've seen before by negating the value at indexed at that value in the array.
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            } else { 
                // means we have already seen this value.
                dups.add(Math.abs(nums[i]));
            }
        }
        return dups;
    }
}
