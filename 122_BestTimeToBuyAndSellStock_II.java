public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int profit = 0;
		int minBuy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				profit += prices[i - 1] - minBuy;
				minBuy = prices[i];
			}
		}
		if (prices[prices.length - 1] > minBuy) {
			profit += prices[prices.length - 1] - minBuy;
		}
		return profit;
	}
}

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int profit = 0;
		int diff = 0;
		for (int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
}