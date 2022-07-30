class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int i=0;
        
        while(i<nums.length){
            if(nums[i]==0){
                max = Math.max(max, count);
                count = 0;
            }else
                count++;
            i++;
        }
        max = Math.max(max, count);
        
        return max;
    }
}