class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int num: nums){
            hashmap.put(num, hashmap.getOrDefault(num, 0)+1);
        }
        
        for(int num: nums){
            int complement = k-num;
            if(hashmap.getOrDefault(num,0)>0 && hashmap.getOrDefault(complement,0)>0){
                if(num == complement && hashmap.get(num)<2)
                    continue;
                hashmap.put(num, hashmap.get(num)-1);
                hashmap.put(complement, hashmap.get(complement)-1);
                count++;
            }
        }
        
        return count;
    }
}