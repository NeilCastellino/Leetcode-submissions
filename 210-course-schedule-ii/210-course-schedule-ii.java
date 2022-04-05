class Solution {
    HashMap<Integer, List<Integer>> pre;
    List<Integer> visited;
    List<Integer> courseList;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        pre = new HashMap<>();

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

        visited = new ArrayList<>();
        courseList = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            if(!dfs(i))
                return new int[]{};
        }
        return courseList.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int num){
        if(visited.contains(num))
            return false;
        if(pre.get(num).isEmpty()) {
            if(!courseList.contains(num))
                courseList.add(num);
            return true;
        }

        visited.add(num);
        for(int val: pre.get(num)){
            if(!dfs(val))
                return false;
        }
        if(visited.contains(num)){
            visited.remove(new Integer(num));
            if(!courseList.contains(num))
                courseList.add(num);
        }

        pre.put(num, new ArrayList<>());
        return true;
    }
}