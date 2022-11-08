class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] arr = new int[26];
        
        for(String s:strs){
            Arrays.fill(arr, 0);
            
            for(char c: s.toCharArray()){
                arr[c-'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(arr[i]);
            }
            String key = sb.toString();
            
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(s);
        }
        
        List<List<String>> finalList = new ArrayList<>();
        for(Map.Entry<String, List<String>> mapElement: map.entrySet()){
            finalList.add(mapElement.getValue());
        }
        
        return finalList;
    }
}