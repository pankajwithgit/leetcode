/*
In-place solution. Asked by dropbox.
*/
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLive = 0;
                for (int p = Math.max(i-1,0); p < Math.min(i+2,m); p++) {
                    for (int q = Math.max(j-1,0); q < Math.min(j+2,n); q++) {
                        if (board[p][q]==2||board[p][q]==1) countLive++;//count status 0 is live
                    }
                }
                countLive -= board[i][j];
                if (board[i][j] == 0 && countLive == 3) board[i][j] = 3; //status 0 is dead,next status is live
                if (board[i][j] == 1 && (countLive < 2 || countLive > 3)) board[i][j] = 2; //status 0 is live,next status is dead
                
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
