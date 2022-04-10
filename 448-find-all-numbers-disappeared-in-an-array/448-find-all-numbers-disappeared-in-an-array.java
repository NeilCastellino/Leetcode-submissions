class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            arr[nums[i]-1] = 1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(arr[i]!=1)
                list.add(i+1);
        }
        
        return list;
    }
}