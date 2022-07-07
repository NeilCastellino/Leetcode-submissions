class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<String, Integer> count = new HashMap<>();
        
        for(char c: magazine.toCharArray()){
            if(!count.containsKey(String.valueOf(c))){
                count.put(String.valueOf(c), 1);
            }else{
                int val = count.get(String.valueOf(c)) + 1;
                count.put(String.valueOf(c), val);
            }
        }
        
        for(char c: ransomNote.toCharArray()){
            if(!count.containsKey(String.valueOf(c))){
                return false;
            }else{
                int val = count.get(String.valueOf(c));
                if(val<=0)
                    return false;
                count.put(String.valueOf(c), val-1);
            }
        }
        
        return true;
    }
}