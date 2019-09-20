/*
Challenge is to solve this in-place.

Time Complexity :  O(M×N)
Space Complexity : O(1)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        //check for length first (as boundary condition)
        if(matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean rowZero = false;
        boolean colZero = false;
        
        // Check if any value on first row is 0
        for(int i : matrix[0]) {
            if(i == 0) { 
                rowZero = true;
                break;
            }
        }
        
        // Check if any value on first column is 0
        for(int[] i : matrix) {
            if(i[0] == 0) {
                colZero = true;
                break;
            }
        }
        
        // Now start from matrix[1][1] location, scan all items, set first row element and first column element to 0 for each item you find as 0;
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Now for each item on first column (except on first row), wherever you find a 0, update all elements on that row to 0
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Now for each item on first row (except first column), wherever you find a 0, update all elements on that column to 0
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Now comes the turn for first row, use rowZero variable to see if first row should also be updated to 0 or not
        if(rowZero) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Now comes the turn for first column, use colZero variable to see if first column should also be updated to 0 or not
        if(colZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
