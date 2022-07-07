class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> count = new HashMap<>();
        
        for(char c: magazine.toCharArray()){
            if(!count.containsKey(c)){
                count.put(c, 1);
            }else{
                int val = count.get(c) + 1;
                count.put(c, val);
            }
        }
        
        for(char c: ransomNote.toCharArray()){
            if(!count.containsKey(c)){
                return false;
            }else{
                int val = count.get(c);
                if(val<=0)
                    return false;
                count.put(c, val-1);
            }
        }
        
        return true;
    }
}