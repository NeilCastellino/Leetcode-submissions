class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length-1;
        int[] ans = new int[n+1];
        int left = 0;
        int right = n;
        
        for(int i=n; i>=0; i--){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                ans[i] = nums[left]*nums[left];
                left++;
            }else{
                ans[i] = nums[right]*nums[right];
                right--;
            }
        }
        
        return ans;
    }
}