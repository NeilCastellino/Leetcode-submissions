class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        int n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();
        
        while(idx<n && intervals[idx][0]<newInterval[0])
            output.add(intervals[idx++]);
        
        int[] interval = new int[2];
        if(output.isEmpty() || output.getLast()[1]<newInterval[0])
            output.add(newInterval);
        else{
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newInterval[1]);
            output.add(interval);
        }
        
        while(idx<n){
            interval = intervals[idx++];
            int start = interval[0];
            int end = interval[1];
            if(output.getLast()[1]<start)
                output.add(interval);
            else{
                interval = output.removeLast();
                interval[1] = Math.max(end, interval[1]);
                output.add(interval);
            }
        }
        
        return output.toArray(new int[output.size()][2]);
    }
}