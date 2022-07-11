class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0)
            return;
        
        int i=0, j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j])
                i++;
            else{
                swapElements(nums1, i);
                nums1[i] = nums2[j];
                m++;
                j++;
                i++;
            }
        }
        
        if(j<n){
            while(i<nums1.length && j<n){
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
    }
    
    private void swapElements(int[] arr, int pos){
        for(int i=arr.length-1; i>pos; i--)
            arr[i] = arr[i-1];
    }
}