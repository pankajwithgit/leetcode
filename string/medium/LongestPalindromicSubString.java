class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String maxSubstring = "";

        int arrayLen = s.length();
        for (int i = 0; i < arrayLen; i++) {
            StringBuilder substring = new StringBuilder();
            for (int j = i; j < arrayLen; j++) {
                substring.append(s.charAt(j));

                int substringLength = substring.length();
                if (max == s.length()) break;

                String inString = substring.toString();
                if (substringLength > max && isPalindrome(inString)) {
                    max = substringLength;
                    maxSubstring = inString;
                }

            }
        }
        return maxSubstring;
    }

    public boolean isPalindrome(String s) {
        int strlen = s.length();

        boolean stillTrue = true;
        for (int i = 0; i < strlen / 2; i++) {
            char startChar = s.charAt(i);
            char endChar = s.charAt(strlen - 1 - i);

            if (startChar == endChar) {
                stillTrue = true;
            } else {
                stillTrue = false;
                break;
            }
        }

        return stillTrue;
    }
}
