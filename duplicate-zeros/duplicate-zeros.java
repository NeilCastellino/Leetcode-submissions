class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]==0){
                i+=1;
                swapElements(arr, i);
                arr[i]=0;
            }
        }
    }
    
    private void swapElements(int[] arr, int pos){
        for(int i=arr.length-1; i>pos; i--)
            arr[i] = arr[i-1];
    }
}