// O(nlogk) time complexity.
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // edge case
        if (nums == null || nums.length == 0) return new double[]{};
        
        double[] res = new double[nums.length - k + 1];

        TreeSet<Integer> left = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[b], nums[a]));
        TreeSet<Integer> right = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        
        for (int i = 0; i < nums.length; i++) {
            left.add(i);
            right.add(left.pollFirst());
            if (left.size() < right.size()) {
                left.add(right.pollFirst());
            }
            
            if (left.size() + right.size() == k) { // find the median
                double median;
                if (left.size() == right.size()) {
                    median = ((double)nums[left.first() ] + (double)nums[right.first()]) / 2;
                } else {
                    median = (double)nums[left.first()];
                }
                
                int start = i - k + 1;
                res[start] = median;
                if (!left.remove(start)) {
                    right.remove(start);
                }
            }
        }
        return res;
    }
}
