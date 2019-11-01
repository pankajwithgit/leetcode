class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        char[] arrNum1 = num1.toCharArray();
        char[] arrNum2 = num2.toCharArray();
        
        // Result would be almost double the size of length of inputs combined.
        int[] resultArr = new int[arrNum1.length + arrNum2.length];    

        int counter = 0;
        for(int i = arrNum1.length - 1; i >= 0; i--) {
            for(int j = arrNum2.length - 1; j >= 0; j--) {
                int x = Character.getNumericValue(arrNum1[i]);
                int y = Character.getNumericValue(arrNum2[j]);
                
                resultArr[i+j+1] = resultArr[i+j+1] + (x * y);
                resultArr[i+j] = resultArr[i+j] + resultArr[i+j+1] / 10;
                resultArr[i+j+1] = resultArr[i+j+1] % 10;
            }
        }
        
        // There may be some zeros left out in the beginning, get rid of those.
        int firstNotZero = 0;
        while(firstNotZero < resultArr.length && resultArr[firstNotZero] == 0) {
            ++firstNotZero;
        }
        
        // Prepare result.
        StringBuilder result = new StringBuilder();
        for(int i = firstNotZero; i < resultArr.length; i++) {
            result.append(resultArr[i]);
        }
        return result.toString();
    }
}
