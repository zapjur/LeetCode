class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for(int price : prices) {
            if(buy >= price) {
                buy = price;
            }
            else {
                profit = (price - buy) > profit ? price - buy : profit;
            }
        }

        return profit;
    }
}