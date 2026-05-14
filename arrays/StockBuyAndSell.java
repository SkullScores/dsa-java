// LC 121 - Best Time to Buy and Sell Stock
// Approach 1: Track current_min + current_max, update max_profit at each step
// Approach 2 (Cleaner): Track minPrice only; profit = prices[i] - minPrice at each step
// Time: O(n) | Space: O(1)

public class StockBuyAndSell
{

    // Best time to buy & sell stock
    // Approach: Maintaning multiple states + Invariant thinking

    //1st Approach
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int current_min = -1;
        int current_max = -1;
        int max_profit = 0;

        for(int i=0; i<n; i++)
        {
            if(current_min == -1)
            {
                current_min = prices[i];
            }
            else
            {
                if(prices[i] <= current_min)
                {
                    current_min = prices[i];
                    current_max = -1;
                }
                else //prices[i] > min
                {
                    current_max = Math.max(current_max, prices[i]);
                    if(max_profit == 0)
                    {
                        max_profit = current_max - current_min;
                    }
                    else
                    {
                        max_profit = Math.max(max_profit, current_max - current_min);
                    }
                }
            }
        }

        return max_profit;
    }


    // Most clean approach: No need to keep current_max
    // bcoz whenever you're at day i, you can directly calculate: prices[i] - current_min

    public int maxProfit2(int[] prices)
    {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices)
        {
            minPrice = Math.min(price, minPrice);
            int profit = price - minPrice;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
