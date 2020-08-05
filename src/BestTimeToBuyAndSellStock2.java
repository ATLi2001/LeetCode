public class BestTimeToBuyAndSellStock2 {

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    // (i.e., buy one and sell one share of the stock multiple times).
    // Note: You may not engage in multiple transactions at the same time
    // (i.e., you must sell the stock before you buy again).
    private static int maxProfit(int[] prices) {
        // strategy - every local min buy, every local max sell
        int maxProfit = 0;
        // track buy prices
        int tmpBuy = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            // special situation for end cases
            // first price will be local min if less than next day
            if(i == 0) {
                if (prices[i] < prices[i + 1])
                    tmpBuy = prices[i];
            }
            // last price will be local max if greater than previous day
            else if(i == prices.length - 1) {
                if (prices[i] > prices[i - 1])
                    if (tmpBuy < prices[i])
                        maxProfit += prices[i] - tmpBuy;
            }
            // general case
            else{
                // find local min and set the buy price there
                if(prices[i] <= prices[i-1] && prices[i] <= prices[i+1])
                    tmpBuy = prices[i];
                // find local max and sell
                if(prices[i] >= prices[i-1] && prices[i] >= prices[i+1])
                    if(tmpBuy < prices[i]){
                        maxProfit += prices[i] - tmpBuy;
                        // reset tmpBuy
                        tmpBuy = Integer.MAX_VALUE;
                    }
            }

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stock1 = new int[]{7,1,5,3,3,6,4};
        // expected 7
        System.out.println("stock1: " + maxProfit(stock1));

        int[] stock2 = new int[]{7,6,4,3,1};
        // expected 0
        System.out.println("stock2: " + maxProfit(stock2));

        int[] stock3 = new int[]{1,2,3,4,5};
        // expected 4
        System.out.println("stock3: " + maxProfit(stock3));
    }
}
