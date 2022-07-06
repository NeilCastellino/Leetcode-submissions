class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0)
                runningSum[i] = nums[i];
            else
                runningSum[i] += nums[i] + runningSum[i-1];
        }
        return runningSum;
    }
}