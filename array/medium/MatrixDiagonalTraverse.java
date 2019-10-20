/*
We will go upwards and downwards alternatively checking the boundaries. We also have to consider that this is not square matrix.
*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null) return null; // if input is null, return null.
        int rows = matrix.length;
        if(rows == 0) return new int[0]; // check if array has eny element or not, return empty result if input is empty.
        int cols = matrix[0].length;
        
        List<Integer> resultList = new ArrayList<>();
        
        // We will start will upwards direction first.
        goUp(resultList, matrix, rows, cols, 0, 0);
        int[] result = resultList.stream().mapToInt(i->i).toArray();
        return result;
    }
    
    /* We will have 2 conditions while going up.
    *  First condition: currentRow can go out of bounds.
    *  Second condition: currentCol can also go out of bounds.
    */
    private void goUp(List<Integer> result, int[][] matrix, int rows, int cols, int currentRow, int currentCol) {
        //System.out.println("goUp: currRow: " + currentRow + " currCol: " + currentCol);
        if(currentRow < 0 || currentCol >= cols) return; // If element at matrix[currentRow][currentCol] is non-existent, return immidiately. 
        
        while(currentRow >= 0 && currentCol < cols) {
            result.add(matrix[currentRow][currentCol]);
            // System.out.println(result);
            currentRow--;
            currentCol++;
        }
        
        if(currentCol >= cols) { // case where both row and column are out of bounds.
            comeDown(result, matrix, rows, cols, currentRow + 2, currentCol - 1);
        }
        else if(currentRow < 0) { // case where only row is out of bounds.
            comeDown(result, matrix, rows, cols, currentRow + 1, currentCol);
        } 
    }
    
   /* We will have 2 conditions while going up.
    *  First condition: currentCol can go out of bounds.
    *  Second condition: currentRow can also go out of bounds.
    */
    private void comeDown(List<Integer> result, int[][] matrix, int rows, int cols, int currentRow, int currentCol) {
        //System.out.println("comeDown: currRow: " + currentRow + " currCol: " + currentCol);
        if(currentRow >= rows || currentCol < 0) return; // If element at matrix[currentRow][currentCol] is non-existent, return immidiately.
        
        while(currentRow < rows && currentCol >= 0) {
            result.add(matrix[currentRow][currentCol]);
            // System.out.println(result);
            currentRow++;
            currentCol--;
        }
        if(currentRow >= rows) {
            goUp(result, matrix, rows, cols, currentRow - 1, currentCol + 2);
        } else if(currentCol < 0) {
            goUp(result, matrix, rows, cols, currentRow, currentCol + 1);
        }
    }
}
