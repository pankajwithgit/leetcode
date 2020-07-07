/*
Daily Coding Problem: Problem #81 [Easy]
Asked by Yelp.

*/
class Solution {
    Map<String, String> keys = new HashMap<>();
    
    public Solution() {
        keys.put("0", "");
        keys.put("1", "");
        keys.put("2", "abc");
        keys.put("3", "def");
        keys.put("4", "ghi");
        keys.put("5", "jkl");
        keys.put("6", "mno");
        keys.put("7", "pqrs");
        keys.put("8", "tuv");
        keys.put("9", "wxyz");
    }
    
    
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        //base cases
        if(digits == null || digits.length() == 0) return results;
        
        dfs(digits, 0, new StringBuffer(), results);
        return results;
    }
    
    // We will continue to process each digit of the input recursively. out variable will be a running string.
    private void dfs(String digits, int index, StringBuffer out, List<String> results) {
        // If we have crossed the last digit, we will add out to result set.
        if(index == digits.length()) {
            results.add(out.toString());
            return;
        }
        
        String digit = String.valueOf(digits.charAt(index));
        String chars = keys.get(digit);
        for(char c : chars.toCharArray()) {
            out.append(c);
            dfs(digits, index + 1, out, results);
            out.deleteCharAt(out.length() - 1); // This is backtracking step.
        }
    }
}
