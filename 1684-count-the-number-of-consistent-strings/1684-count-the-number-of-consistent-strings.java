class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allow = new HashSet<>();
        for(char s: allowed.toCharArray())
            allow.add(s);
        
        int count = 0;
        for(String word: words){
            count++;
            for(char letter:word.toCharArray()){
                if(!allow.contains(letter)){
                    count--;
                    break;
                }
            }
        }
        
        return count;
    }
}