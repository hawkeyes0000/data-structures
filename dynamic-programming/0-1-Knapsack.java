/*

    You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
    Note that we have only one quantity of each item.
    In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. 
    Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this 
    subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

    Example 1:

    Input:
    N = 3
    W = 4
    values[] = {1,2,3}
    weight[] = {4,5,1}
    Output: 3

    Example 2:

    Input:
    N = 3
    W = 3
    values[] = {1,2,3}
    weight[] = {4,5,6}
    Output: 0

    Expected Time Complexity: O(N*W).
    Expected Auxiliary Space: O(N*W)

    Constraints:
    1 ≤ N ≤ 1000
    1 ≤ W ≤ 1000
    1 ≤ wt[i] ≤ 1000
    1 ≤ v[i] ≤ 1000

*/

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i <= n; i++) 
        {
            for(int j = 0; j <= W; j++) 
            {
                if(i == 0 || j == 0) 
                {
                    dp[i][j] = 0;
                    continue;
                }
                if(wt[i-1] <= j) 
                {
                    int previousValue = dp[i-1][j];
                    int includingCurrent = val[i-1] + dp[i-1][j-wt[i-1]];
                    dp[i][j] = Math.max(previousValue, includingCurrent);
                }
                else
                {
                    // item weight is greater that current W, so copy i-1th value
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 
}
