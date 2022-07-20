class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        
        while(right<nums.length){
            if(nums[right] == 0){
                zeros++;
            }
            
            if(zeros==2){
                while(nums[left]!=0){
                    left++;
                }
                left++;
                zeros--;
            }
            
            max = Math.max(right-left+1, max);
            right++;
        }
        
        return max;
    }
}