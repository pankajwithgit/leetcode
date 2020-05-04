/*
Asked on pramp as well: https://www.pramp.com/challenge/yZm60L6d5juM7K38KYZ6

*/
import java.io.*;
import java.util.*;

class Solution {

  static int getNumberOfIslands(int[][] binaryMatrix) {
    int rows = binaryMatrix.length;
    int cols = binaryMatrix[0].length;
    int count = 0;
    
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        if(binaryMatrix[i][j] == 1) {
          bfs(binaryMatrix, i, j);
          count++;
        }
      }
    }
    return count;
  }
  
  private static void bfs(int[][] binaryMatrix, int i, int j) {
    int rows = binaryMatrix.length;
    int cols = binaryMatrix[0].length;
    Queue<int[]> q  = new LinkedList<>();
    binaryMatrix[i][j] = 2;
    q.add(new int[]{i, j});
    
    while(!q.isEmpty()) {
      int[] indexes = q.poll();
      int row = indexes[0];
      int col = indexes[1];
      if(row - 1 >= 0 && binaryMatrix[row - 1][col] == 1) {
        binaryMatrix[row - 1][col] = 2;
        q.add(new int[]{row - 1,col});
      }
      if(row + 1 < rows && binaryMatrix[row + 1][col] == 1) {
        binaryMatrix[row + 1][col] = 2;
        q.add(new int[]{row + 1,col});
      }
      if(col - 1 >= 0 && binaryMatrix[row][col - 1] == 1) {
        binaryMatrix[row][col - 1] = 2;
        q.add(new int[]{row,col - 1});
      }
      if(col + 1 < cols && binaryMatrix[row][col + 1] == 1) {
        binaryMatrix[row][col + 1] = 2;
        q.add(new int[]{row,col + 1});
      }
    }
  } 

  public static void main(String[] args) {

  }

}

/*
[ [0,    1,    0,    1,    0],
  [0,    0,    1,    1,    1],
  [1,    0,    0,    1,    0],
  [0,    1,    1,    0,    0],
  [1,    0,    1,    0,    1] ]

*/
