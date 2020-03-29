// We would prefer using stack to solve this problem. 
class Solution {
    public int clumsy(int N) {
        if(N <= 2) return N;
        int answer;
        
        // Create an array for operations.
        char[] op = {'*', '/', '+', '-'};
        int opIndex = 0;
        Stack<Integer> stack = new Stack<>();
        int number = N;
        stack.push(number--);
        // We will apply operations in sequence till number becomes 1.
        while(number > 0) {
            switch (op[opIndex]) {
                // * and ? operations will be applied immidiately because they needs to be prioritized.
                case '*': stack.push(stack.pop() * number--); break;
                case '/': stack.push(stack.pop() / number--); break;
                case '+': stack.push(number--); break;
                case '-': stack.push(-1 * (number--)); break;
                //default;
            }
            opIndex++;
            opIndex = opIndex % 4;
        }
        int sum = 0;
        // we now need to add all nodes from the stack.
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
