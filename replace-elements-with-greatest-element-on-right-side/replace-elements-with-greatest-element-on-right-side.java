class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            arr[i] = findMax(arr, i);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
    
    private int findMax(int[] arr, int pos){
        int max = 0;
        for(int i=pos+1; i<arr.length; i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
}