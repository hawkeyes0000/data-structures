/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG 
{
    static int subsetSum(int[] arr, int sum, int currSum, int n)
    {
        if(currSum == sum)
        {
            return 1;
        }
        if(currSum > sum || n < 0)
        {
            return 0;
        }
        //     include                                      don't include
        return subsetSum(arr, sum, currSum + arr[n], n-1) + subsetSum(arr, sum, currSum, n-1);
    }
	public static void main (String[] args) 
	{
	    int[] arr = new int[] { 10, 20, 15, 5, 10 };
	    int sum = 25;
	    System.out.println(subsetSum(arr, sum, 0, arr.length - 1));
	}
}
