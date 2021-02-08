class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        
        for(char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        
        int result = 0;
        char[] balloonArr = new char[] {'b','a', 'l','l','o','o','n'};
        
        while(true) {
            for(char c : balloonArr) {
                counts[c - 'a']--;
                if(counts[c - 'a'] == -1) {
                    return result;
                }
            }
            result++;
        }
    }
}
