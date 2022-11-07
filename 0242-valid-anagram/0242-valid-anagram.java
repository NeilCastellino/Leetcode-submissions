class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    
    public boolean isAnagram(String s, String t) {
        for(char c:s.toCharArray()){
            addToMap(Character.toString(c));
        }
        
        for(char c:t.toCharArray()){
            removeFromMap(Character.toString(c));
        }
        
        return isMapEmpty();
    }
    
    private void addToMap(String key){
        int value = map.getOrDefault(key,0);
        map.put(key, value+1);
    }
    
    private void removeFromMap(String key){
        int value = map.getOrDefault(key,-1);
        
        if(value == -1){
            addToMap(key);
        }else if(value == 1){
            map.remove(key);
        }else if(value>1){
            map.put(key, value-1);
        }
    }
    
    private boolean isMapEmpty(){
        return map.size()==0;
    }
}