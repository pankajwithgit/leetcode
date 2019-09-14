class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        int maxLength;
        boolean even = false;
        
        if(totalLen % 2 == 0) {
            maxLength = (totalLen / 2) + 1; 
            even = true;
        } else {
            maxLength = (totalLen + 1) / 2;
        }

        int[] arr = new int[maxLength];
        int index1 = 0;
        int index2 = 0;
        int curIndex = 0;
        
        while(curIndex < maxLength) {
            if(index1 < len1 && index2 < len2){
                if(nums1[index1] > nums2[index2]) {
                    arr[curIndex] = nums2[index2];
                    index2++;
                } else {
                    arr[curIndex] = nums1[index1];
                    index1++;
                }
            } else if(index1 == len1) {
                arr[curIndex] = nums2[index2];
                index2++;
            } else if(index2 == len2) {
                arr[curIndex] = nums1[index1];
                index1++;
            }
            
            curIndex++;
        }
        
        if(even){
            return (double)(arr[maxLength - 1] + arr[maxLength - 2]) / 2;
        } else {
            return (double) arr[maxLength - 1];
        }
    }
}
