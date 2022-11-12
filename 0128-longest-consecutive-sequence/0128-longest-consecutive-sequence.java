class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);
        
        int longestStreak = 1;
        for(int num: set){
            if(!set.contains(num-1)){
                int current_num = num;
                int streak = 1;
                while(set.contains(current_num+1)){
                    current_num+=1;
                    streak+=1;
                }
                longestStreak = Math.max(longestStreak, streak);
            }
        }
        
        return longestStreak;
    }
}