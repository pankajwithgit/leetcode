/*
Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

This is a recursion problem and has O(n!) complexity. We will scan each element, swap it with peer, recurse and revert swap.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results; 
    }
    
    private void permute(int[] nums, int start, List<List<Integer>> results) {
        if(start >= nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            results.add(list);
        }
        else {
            for(int i=start; i<nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start+1, results);
                swap(nums, start, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
