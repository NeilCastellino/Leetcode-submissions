class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex]>0)
                nums[newIndex]*=-1;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }

        return list;
    }
}