class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        
        while(start<end){
            int sum = nums[start]+nums[end];
            if(sum<k){
                max = Math.max(sum, max);
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}