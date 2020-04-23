class Solution {
    public List<Integer> spiralOrder(int[][] inputMatrix) {
    List<Integer> output = new LinkedList<>();
    
    // base case
    if(inputMatrix == null || inputMatrix.length == 0) return output;
        
    int rows = inputMatrix.length;
    int cols = inputMatrix[0].length;
    
    int maxRow = rows - 1;
    int minRow = 0;
    int maxCol = cols - 1;
    int minCol = 0;

    while(minRow <= maxRow && minCol <= maxCol) {
      //System.out.println("minRow: " + minRow + " maxRow: " + maxRow + " minCol: " + minCol + " maxCol: " + maxCol);
      for(int i = minCol; i <= maxCol; i++) { // From left to right
        output.add(inputMatrix[minRow][i]);
      }
      minRow++; // push minRow out of scope
      for(int i = minRow; i <= maxRow; i++) { // from top to bottom
        output.add(inputMatrix[i][maxCol]);
      }
      maxCol--; // push maxCol out of scope
      if(minRow <= maxRow) {
          for(int i = maxCol; i >= minCol; i--) { // from right to left
            output.add(inputMatrix[maxRow][i]);
          }
      }
      maxRow--; // push maxRow out of scope
      if(minCol <= maxCol) {
          for(int i = maxRow; i >= minRow; i--) { // from bottom to up
            output.add(inputMatrix[i][minCol]);
          }
      }
      minCol++; // push minCol out of scope
      //System.out.println("minRow: " + minRow + " maxRow: " + maxRow + " minCol: " + minCol + " maxCol: " + maxCol);
    }
    return output;
    }
}
