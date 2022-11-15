class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        for(int end = 0; end<s.length(); end++){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
            }else{
                max = Math.max(max, end-start);
                while(set.contains(s.charAt(end))){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
            }
        }
        
        max = Math.max(max, s.length()-start);
        return max;
    }
}