class Solution {
    public int removePalindromeSub(String s) {
        if(s == null || s.length()  == 0) {
            return 0;
        }
        if(isPalindrome(s)) return 1;
        return 2;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            } 
            start++;
            end--;
        }
        return true;
    }
}
