/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 // Locate the peak and first check the target on left side of peak because we need min index, if we do not find it there,  //check on the right.

//Locating peak can also be done using normal binary search pivoting based on mid element is on the rising slope or decliing slopse or is the peak.
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        if(mountainArr.get(peak) == target) {
            return peak;
        }
        int left = binarySearch(mountainArr, 0, peak-1, target);
        if(left != -1) {
            return left;
        }
        return revBinarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target);
    }
    
    private int binarySearch(MountainArray mountainArr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);
            if(val == target) {
                return mid;
            } else if(val > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            } 
        }
        return -1;
    }
    
    private int revBinarySearch(MountainArray mountainArr, int start, int end, int target) {        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);
            if(val == target) {
                return mid;
            } else if(val > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            } 
        }
        return -1;
    }
    
    private int findPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            int m1 = mountainArr.get(mid - 1);
            int m2 = mountainArr.get(mid);
            int m3 = mountainArr.get(mid+1);
            if(m1 < m2 && m2 > m3) {
                return mid;
            } else if(m1 < m2) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
