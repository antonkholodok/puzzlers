/**
 * https://www.interviewcake.com/question/java/stock-price
 *
 * Writing programming interview questions hasn't made me rich yet ...
 * So I might give up and start trading Apple stocks all day instead.
 * First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.
 *
 * So I grabbed Apple's stock prices from yesterday and put them in a list called stock_prices, where:
 * - The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
 * - The values are the price (in US dollars) of one share of Apple stock at that time.
 *
 * So if the stock cost $500 at 10:30am, that means stock_prices[60] = 500.
 *
 * Write an efficient function that takes stock_prices and returns the best profit I could have made from
 * one purchase and one sale of one share of Apple stock yesterday.
 *
 * For example:
 * stock_prices = [10, 7, 5, 8, 11, 9]
 * get_max_profit(stock_prices) - returns 6 (buying for $5 and selling for $11)
 *
 * No "shorting"— you need to buy before you can sell.
 * Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 */
public class AppleStock {

    public static int getMaxProfit(int[] prices) {

        int count = prices.length;
        if (count < 2) {
            throw new IllegalArgumentException("prices size should be greater than 1");
        }

        // min price we observed so far
        int minPrice = prices[0];
        // max profit we gained so far
        int maxProfit = prices[1] - prices[0];

        for (int i = 1; i < count; ++i) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(profit, maxProfit);

            // swap min price if needed
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
