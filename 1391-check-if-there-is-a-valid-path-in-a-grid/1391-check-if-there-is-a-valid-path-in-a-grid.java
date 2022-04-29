class Solution {
    int[][][] dirs = {
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{0, 1}, {-1, 0}}
};
    public boolean hasValidPath(int[][] grid) {
        int m=grid.length, n =grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> front = new LinkedList<>();
        front.add(new int[]{0,0});
        visited[0][0] = 1;
        while(!front.isEmpty()){
            int[] pos = front.poll();
            
            int num = grid[pos[0]][pos[1]]-1;
            for(int[] dir:dirs[num]){
                int nr = dir[0]+pos[0], nc=dir[1]+pos[1];
                
                if(nr<0 || nr>=m || nc<0 || nc>=n || visited[nr][nc]==1) continue;
                for(int[] backdir:dirs[grid[nr][nc]-1]){
                    if(nr+backdir[0] == pos[0] && nc+backdir[1]==pos[1]){
                        
                        visited[nr][nc] = 1;
                        front.add(new int[]{nr,nc});
                    }
                }

            }
        }
        return visited[m-1][n-1]==1;
    }
}