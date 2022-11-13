class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int low = Integer.MAX_VALUE;
        
        for(int price: prices){
            if(price<low)
                low = price;
            else if(price-low > maxProfit)
                maxProfit = price - low;
        }
        
        return maxProfit;
    }
}