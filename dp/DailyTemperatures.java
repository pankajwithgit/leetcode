/*
This is a DP solution. Sweeping backwards, for each index, we have to find the index of bigger number that follows the 
current number. Then using this cache, we can find the warmer temps.
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // Base case
        if(T == null || T.length == 0) return null;
        
        int len = T.length;
        int[] biggerToFollow = new int[len];
        int[] output = new int[len];
        
        biggerToFollow[len - 1] = -1;
        for(int i = len - 2; i >= 0; i--) {
            
            // Start to find warmerIndex for current index i. First scan very next element, then refer to it's cache for next
            // bigger number index.
            int warmerIndex = i + 1;
            while(T[i] >= T[warmerIndex]) {
                warmerIndex = biggerToFollow[warmerIndex];
                if(warmerIndex == -1) { // if we have reached a number, which doesn't have  any following bigger number.
                    biggerToFollow[i] = -1;
                    break;
                }
            }
            biggerToFollow[i] = warmerIndex;
        }
        
        // Scan through cache and find the warmer temprature at each index.
        for(int i = 0; i < biggerToFollow.length; i++) {
            if(biggerToFollow[i] == -1) {
                output[i] = 0;
            } else {
                output[i] = biggerToFollow[i] - i;
            }
        }
        return output;
    }
}
