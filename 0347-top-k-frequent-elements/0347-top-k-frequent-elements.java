class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums)
            map.put(num, map.getOrDefault(num,0)+1);
        
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i=0; i<bucket.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }
        
        for(Map.Entry<Integer, Integer> elem: map.entrySet()){
            bucket[elem.getValue()].add(elem.getKey());
        }
        
        List<Integer> flattenedList = new ArrayList<>();
        for(int i=bucket.length-1; i>=0; i--){
            for(int num: bucket[i]){
                flattenedList.add(num);
            }
        }
        
        int[] finalArr = new int[k];
        for(int i=0; i<k; i++){
            finalArr[i] = flattenedList.get(i);
        }
        
        return finalArr;
    }
}