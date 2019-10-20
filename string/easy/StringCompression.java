/*
In-place solution. Expected solution is to return length (len) of modified array and first len characters of array should
be correct.
*/
class Solution {
    public int compress(char[] chars) {
        if(chars == null) return 0;
        if(chars.length <= 1) return chars.length;
        
        int index = 0;
        int start = 0;
        int len = chars.length;
        
        while(start < len) {
            char ch = chars[start];
            int end = start;
            
            // Advance end pointer till next to last matching char.
            while(end < len && chars[start] == chars[end]) { // chars[i..j - 1] are ch.
                end++;
            }
            int frequency = end - start;
            chars[index++] = ch;
            if(frequency > 1) {
                if(frequency < 10) {
                    chars[index++] = (char)(frequency + '0');
                } else {
                    String freqString = String.valueOf(frequency);
                    for(char c : freqString.toCharArray()) {
                        chars[index++] = c;
                    }
                }
            }
            // reset start with end value.
            start = end;
        }
        return index;
    }
}
