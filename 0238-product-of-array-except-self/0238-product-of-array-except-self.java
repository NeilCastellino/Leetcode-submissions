class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            if(i==0)
                answer[i] = 1;
            else
                answer[i] = answer[i-1] * nums[i-1];
        }
        
        int right = 1;
        for(int i=nums.length-1; i>=0; i--){
            answer[i] *= right;
            right *= nums[i];
        }
        
        return answer;
    }
}