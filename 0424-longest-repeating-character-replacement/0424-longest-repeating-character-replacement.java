class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        
        for(int e = 0; e<s.length(); e++){
            map.put(s.charAt(e), map.getOrDefault(s.charAt(e), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(e)));
            
            if(e-start+1-maxFreq>k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                maxFreq = findMax(map);
                start++;
            }
            
            max = Math.max(max, e-start+1);
        }
        
        return max;
    }
    
    private int findMax(Map<Character, Integer> map){
        int max = 0;
        for(int val:map.values()){
            max = Math.max(max, val);
        }
        return max;
    }
}