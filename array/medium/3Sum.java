/*
Brute force is to have 3 loops and complexity would be o(n^3).
But if we sort the array i.e. 0(nlogn) to begin with and then we can do this in O(n^2).
*/
class Solution {    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
		int sum = 0, temp = 0;
		Arrays.sort(nums); // sorting would take nlogn time
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // make sure we skip iterating over same elements again and again.
				sum = 0 - nums[i];
				int x = i + 1, y = nums.length - 1; // Take two running pointers in opposite directions.
				while (x < y) {
					if (nums[x] + nums[y] == sum) {
						result.add(Arrays.asList(nums[x], nums[y], nums[i]));
						while (x < y && nums[x] == nums[x + 1])
							x++;
						while (x < y && nums[y] == nums[y - 1])
							y--;
						x++;
						y--;
					} else if (nums[x] + nums[y] < sum) {
						x++;
					} else
						y--;
				}
			}
		}
		return result;
    }
}
