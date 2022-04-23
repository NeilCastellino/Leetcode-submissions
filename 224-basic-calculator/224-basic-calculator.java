class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int operand = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                operand = operand*10 + (int) (ch-'0');
            }else if(ch=='+'){
                result+=operand*sign;
                sign = 1;
                operand = 0;
            }else if(ch=='-'){
                result+=operand*sign;
                sign = -1;
                operand = 0;
            }else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(ch==')'){
                result+=operand*sign;
                result*=stack.pop();
                result+=stack.pop();
                operand = 0;
            }
        }
        return result+(sign*operand);
    }
}