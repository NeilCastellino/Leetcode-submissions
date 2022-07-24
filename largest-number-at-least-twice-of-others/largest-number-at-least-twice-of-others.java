class Solution {
    public int dominantIndex(int[] nums) {
        int maxValue = 0;
        int largestIndex = -1;
        int secondMaxValue = 0;
        
        for(int i=0; i<nums.length; i++){
            if(maxValue < nums[i]){
                secondMaxValue = maxValue;
                maxValue = nums[i];
                largestIndex = i;
            }else if(secondMaxValue < nums[i])
                secondMaxValue = nums[i];
        }
        
        return (secondMaxValue <= maxValue/2)? largestIndex:-1;
    }
}