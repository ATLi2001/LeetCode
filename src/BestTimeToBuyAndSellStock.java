public class BestTimeToBuyAndSellStock {

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
    // design an algorithm to find the maximum profit.
    // Note that you cannot sell a stock before you buy one.
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        // track change in price each day
        int[] priceDiff = new int[prices.length - 1];
        for(int i = 0; i < priceDiff.length; i++)
            priceDiff[i] = prices[i+1] - prices[i];

        // similar to maximum subarray problem
        // aggregate temporary profit
        int tmpProfit = 0;
        for(int i = 0; i < priceDiff.length; i++){
            tmpProfit += priceDiff[i];
            if(tmpProfit > maxProfit)
                maxProfit = tmpProfit;
            // if tmpProfit ever goes below 0, reset
            if(tmpProfit <= 0)
                tmpProfit = 0;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stock1 = new int[]{7,1,5,3,6,4};
        // expected 5
        System.out.println("stock1: " + maxProfit(stock1));

        int[] stock2 = new int[]{7,6,4,3,1};
        // expected 0
        System.out.println("stock2: " + maxProfit(stock2));
    }
}
