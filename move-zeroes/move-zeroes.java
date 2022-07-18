class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        for(int p2 = 1; p2<nums.length; p2++){
            if(nums[p1]==0 && nums[p2]!=0){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1++;
            }else if(nums[p1]!=0 && (nums[p2]!=0 || nums[p2]==0)){
                p1++;
            }
        }
    }
}