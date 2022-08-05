class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        
        for(int i=0; i<list.size(); i++){
            list.set(i,new StringBuilder(list.get(i)).reverse().toString());
        }
        return String.join(" ", list);
    }
}