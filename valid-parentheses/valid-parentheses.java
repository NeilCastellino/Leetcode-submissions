class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        Stack<Character> stack = new Stack<>();
        
        for(char letter:s.toCharArray()){
            if(map.containsKey(letter) && !stack.isEmpty()){
                if(stack.peek() == map.get(letter)){
                    stack.pop();
                }else
                    return false;
            }else{
                stack.push(letter);
            }
        }
        
        if(stack.isEmpty())
            return true;
        return false;
    }
}