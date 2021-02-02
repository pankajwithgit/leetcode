class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toBeRemoved = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                // If stack is empty, means that ')' is invalid and needs to be removed.
                if(stack.isEmpty()) { 
                    toBeRemoved.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        // Add all (if any left out) stack elements to tobeRemoved set
        while(!stack.isEmpty()) { 
            toBeRemoved.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(!toBeRemoved.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
}
