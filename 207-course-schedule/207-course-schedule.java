class Solution {
    HashMap<Integer, List<Integer>> pre;
    List<Integer> visited;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        pre = new HashMap<Integer, List<Integer>>();
        
        for(int i=0; i<numCourses; i++){
            pre.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            for(int j=1; j<prerequisites[i].length; j++){
                List<Integer> list = pre.get(prerequisites[i][0]);
                list.add(prerequisites[i][j]);
                pre.put(prerequisites[i][0], list);
            }
        }
        
        visited = new ArrayList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(!dfs(i))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int num){
        if(visited.contains(num))
            return false;
        if(pre.get(num).isEmpty())
            return true;
        
        visited.add(num);
        for(int val: pre.get(num)){
            if(!dfs(val))
                return false;
        }
        if(visited.contains(num))
            visited.remove(new Integer(num));
        pre.put(num, new ArrayList<>());
        return true;
    }
}