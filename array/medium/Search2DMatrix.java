class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int width = matrix[0].length;
        
        if(width == 0){
            return false;
        }
        
        for(int i = 0; i < rows; i++) {                                               
            // Check if element is out of bounds for matrix.
            if(matrix[i][0] > target) {
                return false;
            }
            // Check if element is in current array in iteration, is yes, do binary search. 
            if(matrix[i][0] < target && matrix[i][width - 1] > target) {
                return binarySearch(matrix[i], target);
            }
            if(matrix[i][0] == target || matrix[i][width - 1] == target){
                return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == target){
                return true;
            }
            if(array[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
