class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // edge cases
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        boolean found = false;
        
        // Start iterating over the rows.
        for(int i = 0; i < matrix.length; i++) {
            
            // check if boundary values are matching the target.
            if(matrix[i][0] == target || matrix[i][matrix[i].length - 1] == target) return true;
            // If target is out of bounds for a row, skip that row.
            if(matrix[i][0] > target || matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            
            // Now, perform binary search on a row
            found = binarySearch(matrix[i], target);
            if(found) {
                return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
       
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] == target) return true;
            if(row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
