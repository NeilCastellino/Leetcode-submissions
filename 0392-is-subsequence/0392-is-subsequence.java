class Solution {
    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        
        for(char c: s.toCharArray())
            queue.add(c);
        
        for(char c: t.toCharArray()){
            if(!queue.isEmpty() && queue.peek() == c)
                queue.poll();
        }
        
        if(queue.isEmpty())
            return true;
        
        return false;
    }
}