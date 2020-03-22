// Brute force would be to have 4 nested loops, which will be O(n^4). 
// But if we sort the array i.e. 0(nlogn) to begin with and then we can do this in O(n^3).
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        
        Arrays.sort(nums); // sort array first.
        int sum = 0;
        for(int i = 0; i < nums.length - 3; i++) {
            // Ensure we only process unique i values.
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    int nextIndex = i + 1;
                    // Ensure we only process unique j values.
                    if(j == nextIndex || (j > nextIndex && nums[j] != nums[j - 1])) {
                        sum = target - nums[i] - nums[j];
                        // Now start processing rest of element using 2 pointers, one from front and another from back. 
                        int x = j + 1;
                        int y = nums.length - 1;
                        while (x < y) {
                            if(sum == nums[x] + nums[y]) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                                // Skip dups for x.
                                while(x < y && nums[x] == nums[x + 1]) {
                                    x++;
                                }
                                // Skip dups for 
                                while(y > x && nums[y] == nums[y - 1]) {
                                    y--;
                                }
                                x++;
                                y--;
                            } else if(nums[x] + nums[y] > sum) {
                                y--;
                            } else {
                                x++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
