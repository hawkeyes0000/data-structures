/*
    
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    Example 2:

    Input: prices = [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

    Example 3:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e., max profit = 0.

    
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] > prices[i - 1])
            {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}

/*
    This solution works because for any array in ascendending order, arr[n] - arr[0] is same as arr[1] - arr[0] + arr[2] - arr[1] + .... + arr[n] - arr[n-1]. 
    In other words, difference of first and last element is same as sum of difference of all consecutive elements.
    To quote a comment I found of leetcode:-
    "@renanls Nope, I think you misunderstood the point of approach 3. Let's say a simple example [1,2,3,4], if you buy on day 1 & sell on day 2, buy on day 2 
    & sell on day 3, buy on day 3 & sell on day 4, this gives you maxprofit = 3. According to the question, this is not allowed, however, it doesn't matter. 
    Instead, you can simply buy on day 1 and only sell it on day 4, which gives you 3 as well.
    Here is the point, when you think about it in terms of math, day 4 - day 1 = day 4 - day 3 + day 3 - day 2 + day 2 - day 1, notice all the inner cancellations? 
    that's a clever way to calculate, and is easily applied in a for loop, so in approach 3 we have the code: maxprofit += prices[i] - prices[i - 1]. 
    So in short, it's just a clever way to achieve the same effect, which doesn't mean you have to buy on day 1 & sell on day 2, buy on day 2 & sell on day 3, etc. 
    Hope this helps!"
*/
