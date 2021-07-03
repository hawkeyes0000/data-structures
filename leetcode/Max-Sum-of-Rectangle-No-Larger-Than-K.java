/*

    Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

    It is guaranteed that there will be a rectangle with a sum no larger than k.



    Example 1:

    Input: matrix = [[1,0,1],[0,-2,3]], k = 2
    Output: 2
    Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).

    Example 2:

    Input: matrix = [[2,2,-1]], k = 3
    Output: 3



    Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -100 <= matrix[i][j] <= 100
        -105 <= k <= 105

*/

class Solution 
{
    public int maxSumSubmatrix(int[][] matrix, int k) 
    {
        if(matrix.length == 0)
        {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int desiredSum = Integer.MIN_VALUE;
        
        for(int l = 0; l < cols; l++)
        {
            int[] sum = new int[rows];
            for(int r = l; r < cols; r++)
            {
                // fill sum
                for(int i = 0; i < rows; i++)
                {
                    sum[i] += matrix[i][r];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currentSum = 0;
                
                for(int s = 0; s < sum.length; s++)
                {
                    currentSum += sum[s];
                    Integer n = set.ceiling(currentSum - k);
                    if(n != null)
                    {
                        desiredSum = Math.max(desiredSum, currentSum - n);
                    }
                    set.add(currentSum);
                }
            }
        }
        return desiredSum;
    }
}
