class Solution {
    PriorityQueue<Order> buyQ;
    PriorityQueue<Order> sellQ;
    
    public int getNumberOfBacklogOrders(int[][] orders) {
        buyQ = new PriorityQueue<Order>((a,b)->(b.price-a.price));
        sellQ = new PriorityQueue<Order>((a,b)->(a.price-b.price));
        int MOD = (int) Math.pow(10,9)+7;
        
        for(int[] order: orders){
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];
            
            if(orderType == 0){
                handleBuy(new Order(amount, price));
            }else if(orderType == 1){
                handleSell(new Order(amount, price));
            }
        }
        long count = 0L;
        while(!buyQ.isEmpty()){
            count+=buyQ.poll().amount;
            count %= MOD;
        }
        while(!sellQ.isEmpty()){
            count+=sellQ.poll().amount;
            count %= MOD;
        }

        return (int)(count%MOD);
    }
    
    private void handleBuy(Order order){
        if(sellQ.isEmpty()){
            buyQ.add(order);
            return;
        }
        
        while(!sellQ.isEmpty() && sellQ.peek().price <= order.price && order.amount>0){
            Order sell = sellQ.poll();
            
            if(sell.amount <= order.amount){
                order.amount -= sell.amount;
                sell.amount = 0;
            }else{
                sell.amount -= order.amount;
                order.amount = 0;
                sellQ.add(sell);
            }
        }
        
        if(order.amount>0)
            buyQ.add(order);
    }
    
    private void handleSell(Order order){
        if(buyQ.isEmpty()){
            sellQ.add(order);
            return;
        }
        
        while(!buyQ.isEmpty() && buyQ.peek().price >= order.price && order.amount>0){
            Order buy = buyQ.poll();
            
            if(order.amount >= buy.amount){
                order.amount -= buy.amount;
                buy.amount = 0;
            }else{
                buy.amount -= order.amount;
                order.amount = 0;
                buyQ.add(buy);
            }
        }
        
        if(order.amount>0)
            sellQ.add(order);
    }
}

class Order{
    int amount;
    int price;
    
    public Order(int amount, int price){
        this.amount = amount;
        this.price = price;
    }
}