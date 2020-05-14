/*
The idea is to get the window from the words which can fit in a line.

while getting this window, we also keep following track:
len : len for the window from start to end including one space as minimum req
Example len = 10 for "THIS IS AN"
count : keeps track of space holders in the string. Initial kept to -1.
Example count = 2 for "THIS IS AN"
Upon getting the window, we now call a function addLine() which creates a line keeping track of 4 things
same : The equals spaces every word pair will have between them
extra : The extra ones, which are given one by one from left and decremented every time
trail : For cases such as last line OR only one word in the line, we need to append trail number of spaces to the line.
Time Complexity : O(N*maxWidth) : N is number of lines
Space Complexity : O(maxWidth) : Space for a single line

*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = -1;
        int spaceCount = -1;
        int start = 0;
        for(int i = 0; i < words.length; i++) {
            if(len + words[i].length() + 1 <= maxWidth) {
                len += words[i].length() + 1;
                spaceCount++;
            } else {
                res.add(addLine(words, maxWidth, start, i - 1, len, spaceCount, false));
                len = -1;
                spaceCount = -1;
                start = i;
                i--;
            }
        }
        // Send last line to be added.
        res.add(addLine(words, maxWidth, start, words.length - 1, len, spaceCount, true));
        return res;
     }
    
    private String addLine(String[] words, int maxWidth, int start, int end, int len, int spaceCount, boolean isLast) {
        StringBuilder str = new StringBuilder();
        int totalSpaces = maxWidth - len;
        totalSpaces += spaceCount;
        
        int sameSpaces = (isLast || (spaceCount == 0)) ? 0: totalSpaces / spaceCount;
        int extraSpaces = (isLast || (spaceCount == 0)) ? spaceCount : totalSpaces % spaceCount;
        int trailSpaces = (isLast || spaceCount == 0) ? maxWidth - len : 0;
        
        while(start <= end) {
            str.append(words[start]);
            
            // Add same spaces after each word
            for(int i = 0; i < sameSpaces && start != end; i++) {
                str.append(" ");
            }
            
            // Add extra space if it is still not 0.
            if(extraSpaces > 0) {
                str.append(" ");
                extraSpaces--;
            }
            start++;
        }
        
        // Add trail spaces if we have them
        while(trailSpaces > 0) {
            str.append(" ");
            trailSpaces--;
        }
        return str.toString();
    }
}
