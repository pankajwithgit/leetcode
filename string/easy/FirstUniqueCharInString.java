class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] charArr = s.toCharArray();
        
        for(int c : charArr) {
            arr[c - 'a']++;
        }
        
        for(int i = 0 ; i < charArr.length; i++) 
        {
            if(arr[charArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
