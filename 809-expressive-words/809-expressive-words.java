class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(String word: words){
            if(check(s, word)){
                count++;
            }
        }
        return count;
    }
    
    private boolean check(String s, String word){
        int i=0, j=0;
        
        while(i<s.length() && j<word.length()){
            if(s.charAt(i)!=word.charAt(j))
                return false;
            else{
                int lenS = getLength(s, i);
                int lenWord = getLength(word, j);
                
                if(lenS==lenWord || (lenS>lenWord && lenS>=3)){
                    i+=lenS;
                    j+=lenWord;
                    continue;
                }else{
                    return false;
                }
            }
        }
        
        return i==s.length() && j==word.length();
    }
    
    private int getLength(String s, int i){
        int length = 1;
        i++;
        for(;i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1))
                length++;
            else
                break;
        }
        
        return length;
    }
}