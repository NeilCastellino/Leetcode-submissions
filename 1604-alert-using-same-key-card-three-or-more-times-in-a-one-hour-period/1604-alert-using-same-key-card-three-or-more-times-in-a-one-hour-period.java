import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        List<String> ans = new ArrayList<String>();
        
        for(int i=0; i<keyName.length; i++){
            String name = keyName[i];
            String[] timeSplit = keyTime[i].split(":");
            int time = Integer.parseInt(timeSplit[0])*60 + Integer.parseInt(timeSplit[1]);
            if(!hm.containsKey(name)){
                hm.put(name, new ArrayList<Integer>());
            }
            hm.get(name).add(time);
        }
        
        for(Map.Entry<String, ArrayList<Integer>> entry : hm.entrySet()){
            ArrayList<Integer> times = entry.getValue();
            Collections.sort(times);
            
            for(int i=0; i+2<times.size(); i++){
                if(times.get(i+2)-times.get(i)<61){
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}