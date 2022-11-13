class Solution {
    public int maxArea(int[] height) {
        int maxVolume = 0;
        int low = 0; 
        int high = height.length - 1;
        
        while(low<high){
            maxVolume = Math.max(maxVolume, (high-low) * Math.min(height[low],height[high]));
            
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        
        return maxVolume;
    }
}