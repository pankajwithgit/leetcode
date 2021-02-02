// See leetcode solution for understanding the solution.
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0, maxDiff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int t = dist(nut, tree);
            int s = dist(nut, squirrel);
            sum += 2*t;
            maxDiff = Math.max(maxDiff, t - s);
        }

        return sum - maxDiff;
    }

    public int dist(int[] num1, int[] num2) {
        return Math.abs(num1[0] - num2[0]) + Math.abs(num1[1] - num2[1]);
    }
}
