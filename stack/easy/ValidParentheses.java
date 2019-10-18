import java.util.Collection;
/*
Classic problem to be solved using Stack. Iterate String char by char, if we find opening bracket, push to stack, if we find
closing brackets, pop a char from stack and compare if they match. If not, return false immidiately.
*/
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Set<Character> keys = map.keySet();
        Collection<Character> values = map.values();
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(values.contains(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                
                if(stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
