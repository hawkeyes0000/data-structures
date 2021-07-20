/*

    Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} 
    valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.

    Example 1:

    Input: V = 30, M = 3, coins[] = {25, 10, 5}
    Output: 2
    Explanation: Use one 25 cent coin
    and one 5 cent coin

    Example 2:

    Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
    Output: 2 
    Explanation: Use one 6 cent coin
    and one 5 cent coin

    Expected Time Complexity: O(V*M)
    Expected Auxiliary Space: O(V)

    Constraints:
    1 ≤ V*M ≤ 106
    All array elements are distinct

*/

class Solution
{
	public int minCoins(int coins[], int M, int V) 
	{ 
        int[] minV = new int[V+1];
        Arrays.fill(minV, Integer.MAX_VALUE);
        minV[0] = 0;	// maintains the minimum coins required to make ith amount
        for(int i = 0; i < M; i++)	// traverses each coin
        {
            for(int j = 1; j <= V; j++)	// traverses 1 to V for each coin
            {
                if(coins[i] <= j)	// if the coin value is less current sum
                {
                    int diff = minV[j - coins[i]];	
                    if(diff != Integer.MAX_VALUE && diff + 1 < minV[j])
                    {
                        minV[j] = diff + 1;
                    }
                }
            }
        }
        if(minV[V] == Integer.MAX_VALUE)
        {
            return -1;
        }
        return minV[V];
	} 
}
