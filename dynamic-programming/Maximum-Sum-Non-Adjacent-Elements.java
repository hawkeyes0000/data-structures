/*
    
    Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule 
    when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. 
    The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum 
    money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

    Example 1:

    Input:
    n = 6
    a[] = {5,5,10,100,10,5}
    Output: 110
    Explanation: 5+100+5=110

    Example 2:

    Input:
    n = 3
    a[] = {1,2,3}
    Output: 4
    Explanation: 1+3=4

    Your Task:
    Complete the function FindMaxSum() which takes an array arr[] and n as input which returns the maximum money he can get following the rules

    Expected Time Complexity: O(N).
    Expected Space Complexity: O(N).

    Constraints:
    1 ≤ n ≤ 104
    1 ≤ a[i] ≤ 104
        
*/

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int[] dp = new int[10001];
        int ans = Math.max(FindMaxSumUtil(arr, n, 0, dp), FindMaxSumUtil(arr, n, 1, dp));
        return ans;
    }
    static int FindMaxSumUtil(int[] arr, int n, int index, int[] dp)
    {
        if(index >= n) return 0;
        if(dp[index] != 0) return dp[index];
        dp[index] = arr[index] + Math.max(FindMaxSumUtil(arr, n, index + 2, dp), FindMaxSumUtil(arr, n, index + 3, dp));
        return dp[index];
    }
}
