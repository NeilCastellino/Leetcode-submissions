class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length && nums[i]<=0; i++){
            if(i==0 || nums[i-1]!=nums[i]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> res){
        int low = i+1;
        int high = nums.length-1;
        while(low<high){
            if(nums[i]+nums[low]+nums[high]<0)
                low++;
            else if(nums[i]+nums[low]+nums[high]>0)
                high--;
            else{
                res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low<high && nums[low] == nums[low-1])
                    low++;
            }
        }
    }
}