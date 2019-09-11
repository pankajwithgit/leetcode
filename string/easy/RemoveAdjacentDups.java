class Solution {
    public String removeDuplicates(String S) {
        boolean hasDuplicates = true;
        
        while(hasDuplicates) {
            boolean foundDup = false;
            StringBuilder sb = new StringBuilder(S);
            for(int i = 0; i< S.length() - 1; i++) {
                if(S.charAt(i) == S.charAt(i+1)) {
                    sb.deleteCharAt(i+1);
                    sb.deleteCharAt(i);
                    S = sb.toString();
                    foundDup = true;
                }
            }
            if(!foundDup) {
                hasDuplicates = false;
            }
        }
        return S;
    }    
}
