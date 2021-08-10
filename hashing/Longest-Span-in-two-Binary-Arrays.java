/*

    Given two binary arrays arr1[] and arr2[] of same size N. Find length of the longest common span [i, j] where j>=i 
    such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j]. 

    Example 1:

    Input:
    N = 6
    Arr1[] = {0, 1, 0, 0, 0, 0}
    Arr2[] = {1, 0, 1, 0, 0, 1}
    Output: 4
    Explanation: The longest span with same
    sum is from index 1 to 4 following zero 
    based indexing.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)

*/

class Solution 
{
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) 
    {
        int res = 0;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++)
        {
            int val1 = arr1[i] == true ? 1 : 0;
            int val2 = arr2[i] == true ? 1 : 0;
            temp[i] = val1 - val2;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += temp[i];
            if(map.containsKey(sum))
            {
                res = Math.max(res, i - map.get(sum));
            }
            else if(sum == 0)
            {
                res = Math.max(res, i + 1);
            }
            else if(!map.containsKey(sum))
            {
                map.put(sum, i);
            }
        }
        return res;
    }
}
