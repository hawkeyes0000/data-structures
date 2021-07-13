/*
    
    A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top. As the answer will be large find the answer modulo 1000000007.

    Example 1:

    Input:
    N = 1
    Output: 1

    Example 2:

    Input:
    N = 4
    Output: 7
    Explanation:Below are the 7 ways to reach
    4
    1 step + 1 step + 1 step + 1 step
    1 step + 2 step + 1 step
    2 step + 1 step + 1 step
    1 step + 1 step + 2 step
    2 step + 2 step
    3 step + 1 step
    1 step + 3 step

    Your Task:
    Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(1).
    
*/



/*
    Approach 1:- Recursive Memoization (no base values stored)
*/
class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        return countWaysUtil(n, new long[n+1]);
    }
    static long countWaysUtil(int n, long[] dp)
    {
        if(n < 0)
        {
            return 0;
        }
        if(n == 0 || n == 1)
        {
            return 1;
        }
        if(dp[n] != 0)
        {
            return dp[n];
        }
        
        dp[n] = (countWaysUtil(n - 1, dp) + countWaysUtil(n - 2, dp) + countWaysUtil(n - 3, dp)) % 1000000007;
        return dp[n];
    }
}


/*
    Approach 2:- Iterative Memoization with dp[0], dp[1], dp[2] specified. Iterate from 3 to n and calculate the ith value as the sum of last three numbers
    Space complexity - O(n)
*/
class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long[] dp = new long[n+1];
        dp[0] = 1;
        if(n >= 1)
            dp[1] = 1;
        if(n >= 2)
            dp[2] = 2;
        for(int i = 3; i <= n; i++)
        {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000007;
        }
        return dp[n];
    }
}




/*
    Approach 3:- Uses constant space. Initialize an array of size 3 and during each iteration, update the i%3th value
*/

class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long[] dp = new long[3];
        dp[0] = 1;
        if(n >= 1)
            dp[1] = 1;
        if(n >= 2)
            dp[2] = 2;
        for(int i = 3; i <= n; i++)
        {
            dp[i % 3] = (dp[(i-1) % 3] + dp[(i-2) % 3] + dp[(i-3) % 3]) % 1000000007;
        }
        return dp[n%3];
    }
}
