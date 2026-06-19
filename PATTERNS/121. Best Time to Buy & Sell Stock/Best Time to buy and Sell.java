// TC = O(n)
// SC = O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bestBuy = prices[0];
        // int currProfit = 0;

        for(int price : prices){
            if(price > bestBuy){
                // currProfit = price -bestBuy;
                maxProfit = Math.max(maxProfit, price -bestBuy);
            }else{
                bestBuy = Math.min(bestBuy, price);
            }            
        }
        return maxProfit;
    }
}
