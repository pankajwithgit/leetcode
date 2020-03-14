// Solution would be to find out maximum values on each side for all elements. Then min(leftMax, rightMax) - height[i] would give us water level 
// at that element.
class Solution {
    public int trap(int[] height) {
        // Base cases.
        if(height == null) return 0;
        if(height.length == 0) return 0;
        
        int totalWater = 0;
        
        int len = height.length;
        
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        
        // Prepare leftMax value for each element.
        int maxFromLeft = 0;
        leftMax[0] = 0;
        for(int i = 1; i < len; i++) {
            if(height[i-1] > maxFromLeft) {
                maxFromLeft = height[i-1];
            }
            leftMax[i] = maxFromLeft;
        }
        
        // Prepare rightMax value for each element.
        int maxFromRight = 0;
        rightMax[len - 1] = 0;
        for(int i = len - 2; i >= 0; i--) {
            if(height[i + 1] > maxFromRight) {
                maxFromRight = height[i + 1];
            }
            rightMax[i] = maxFromRight;
        }
        
        // Calculate total water.
        for(int i = 0; i < len; i++) {
            int waterHeight = Math.min(leftMax[i], rightMax[i]) - height[i];
            
            totalWater += (waterHeight > 0)? waterHeight: 0;
        }
        
        return totalWater;
    }
}
