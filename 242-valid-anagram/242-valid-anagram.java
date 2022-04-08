class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int[] alp = new int[26];
        for(char c:s.toCharArray()){
            alp[c-'a']++;
        }
        for(char c:t.toCharArray()){
            alp[c-'a']--;
        }
        for(int val:alp){
            if(val!=0)
                return false;
        }
        return true;
    }
}