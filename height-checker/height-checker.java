class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        PriorityQueue<Integer> sorted = new PriorityQueue<Integer>();
        int incorrect = 0;
        
        for(int i=0; i<n; i++){
            sorted.add(heights[i]);
        }
        
        for(int i=0; i<n; i++){
            if(sorted.poll()!=heights[i])
                incorrect++;
        }
        
        return incorrect;
    }
}