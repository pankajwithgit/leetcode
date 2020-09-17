class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int fillIndex = nums1.length - 1;
        
        while(index1 >= 0 && index2 >= 0) {
            if(nums1[index1] > nums2[index2]) {
                nums1[fillIndex--] = nums1[index1];
                index1--;
            } else {
                nums1[fillIndex--] = nums2[index2];
                index2--;
            }
        }
        while(index2 >= 0) {
            nums1[fillIndex--] = nums2[index2];
            index2--;
        }
        
        System.out.println(Arrays.toString(nums1));
    }
}
