// It's a backtracking problem. 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Base case
        if(nums == null || nums.length == 0) return res;
        
        for(int i = 0; i < nums.length; i++) {}
        helper(nums, 0, new ArrayList<Integer>(), res);
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] nums, int start, List<Integer> out, List<List<Integer>> res) {
        if(start == nums.length) { // Boundary case.
            return;
        }
        for(int i = start; i < nums.length; i++) {
            out.add(nums[i]);
            res.add(new ArrayList<Integer>(out));
            helper(nums, i + 1, out, res); // Call recursively.
            out.remove(out.size() - 1); // Backtrack.
        }
    }
}
