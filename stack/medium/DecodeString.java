class Solution {
    public String decodeString(String s) {
        StringBuilder output = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        if(s == null || s.length() == 0) return s;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            
            //if you find a closing ] then retrieve the string it encapsulates
            if(arr[i] == ']') {
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.insert(0, st.pop());
                }
                String str = sb.toString(); //this is the string contained in [ ]
                
                st.pop(); //Discard the '['
                
                //after that, get the number of times it should repeat from stack
                sb = new StringBuilder(); 
                while(!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb.insert(0, st.pop());
                }
                Integer number = Integer.valueOf(sb.toString());
                
                //repeat the string within the [ ] count number of times and push it back into stack
                while(number > 0) {
                    for(char c : str.toCharArray()) {
                        st.push(c);
                    }
                    number--;
                }
            } else {
                st.push(arr[i]);
            }
        }
        
        // final fetching and returning the value in stack 
        while(!st.isEmpty())
            output.insert(0, st.pop());
        
        return output.toString();
    }
}
