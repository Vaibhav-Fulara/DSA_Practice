class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        int minPrice = prices[0];
        for(int price:prices){
            if(minPrice > price) minPrice = price;
            else max = Math.max(max, price - minPrice);
        }
        return max;
    }
}