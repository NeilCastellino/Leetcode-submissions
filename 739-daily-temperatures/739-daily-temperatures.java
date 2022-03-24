class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            int currTemp = temperatures[i];
            while(!stack.isEmpty() && currTemp>temperatures[stack.peek()]){
                int prevDay = stack.pop();
                arr[prevDay] = i-prevDay;
            }
            stack.push(i);
        }
        
        return arr;
    }
}