class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is bigger, return.
        if(s1.length() > s2.length()) return false;
        
        int[] s1Cache = new int[26];
        int[] s2Cache = new int[26];
        
        // start to maintain the frequency data structure for both strings. 
        for(int i = 0; i < s1.length(); i++) {
            s1Cache[s1.charAt(i) - 'a']++;
            s2Cache[s2.charAt(i) - 'a']++;
        }

        // now for each substring (equal to size of s1), try to match frequency map with s1.
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            if(matches(s1Cache, s2Cache)) return true;
            
            // remove initial char and add next char.
            s2Cache[s2.charAt(i + s1.length()) - 'a']++;
            s2Cache[s2.charAt(i) - 'a']--;
        }
        return matches(s1Cache, s2Cache);
    }
    
    private boolean matches(int[] cache1, int[] cache2) {
        for(int i = 0; i < 26; i++) {
            if(cache1[i] != cache2[i]) return false;
        }
        return true;
    }
    
}
