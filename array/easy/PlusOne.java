// One of Google question.
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if(digits[i] == 10) {
                digits[i] = 0; 
                // if it is first index, we need to expand the array.
                // A case of 999 + 1 = 1000
                if(i == 0) { 
                    return arrayCopy(digits);
                }
            } else {
                break;
            }
        }
        return digits;
    }
    
    private int[] arrayCopy(int[] digits) {
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
