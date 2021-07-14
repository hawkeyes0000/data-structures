/*

    The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either 
    move only to right or down.

    Example 1:

    Input: m = 2, n = 2
    Output: 2 
    Explanation: Two possible ways are
    RD and DR.  


    Example 2:

    Input: m = 3, R = 3
    Output: 6
    Explanation: Six possible ways are
    RRDD, DDRR, RDDR, DRRD, RDRD, DRDR. 

    Expected Time Complexity: O(m*n)
    Expected Auxiliary Space: O(m*n)

    Constraints:
    1 <= m <=100
    1 <= n <=100  

*/


/*
    We can either move down or right. Thus, we reduce the matrix as (m-1, n) and (m, n-1) until it becomes (1,1) and return 1 in that case.
    
                                             [3]
											(2,3)
						
						 [1]									 [2]
						(1,3)									(2,2)						

				 [0]			 [1]					 [1]				 [1] (1,2) = (2,1)
				(0,3)			(1,2)					(1,2)				(2,1)
			
							 [0]	 [1]
							(0,2)	(1,1)					   		 
							
    [n] indicates return value from that function call
*/


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        return numberOfPathsUtil(m, n, new HashMap<String, Long>());
    }
    
    static long numberOfPathsUtil(int m, int n, HashMap<String, Long> map)
    {
        if(m == 0 || n == 0)
        {
            return 0;
        }
        if(m == 1 && n == 1)
        {
            return 1;
        }
        if(map.containsKey(m + "," + n))
        {
            return map.get(m + "," + n);
        }
        map.put(m + "," + n, (numberOfPathsUtil(m - 1, n, map) + numberOfPathsUtil(m, n-1, map)) % 1000000007);
        map.put(n + "," + m, map.get(m + "," + n));
        return map.get(m + "," + n);
    }
}
