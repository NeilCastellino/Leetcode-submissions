class Solution {
    public int maxArea(int[] height) {
        int maxVolume = 0;
        int low = 0; 
        int high = height.length - 1;
        
        while(low<high){
            int minHeight = (height[low]<height[high])? height[low]:height[high];
            int area = (high-low) * minHeight;
            maxVolume = Math.max(maxVolume, area);
            
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        
        return maxVolume;
    }
}