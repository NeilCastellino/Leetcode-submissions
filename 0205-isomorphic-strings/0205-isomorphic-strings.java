class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int[] mapSToT = new int[256];
        int[] mapTToS = new int[256];
        
        for(int i=0; i<mapTToS.length; i++){
            mapSToT[i] = -1;
            mapTToS[i] = -1;
        }
        
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(mapSToT[c1] == -1 && mapTToS[c2] == -1){
                mapSToT[c1] = c2;
                mapTToS[c2] = c1;
            }else if(c2 != mapSToT[c1] && c1 != mapTToS[c2])
                return false;
        }
        
        return true;
    }
}