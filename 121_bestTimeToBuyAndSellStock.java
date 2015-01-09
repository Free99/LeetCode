public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profits = 0;
        int minBuy = prices[0];
        for (int i=1; i<prices.length; i++) {
            minBuy = Math.min(minBuy,prices[i]);
            profits = Math.max(profits,prices[i]-minBuy);
        }
        return profits;
    }
}