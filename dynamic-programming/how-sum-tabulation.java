/*
    Given an array of integers and a targetSum, return a combination of interger whose sum yield the targetSum. Return null if sum is not possible
*/

import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
        int sum = 41;
        int[] arr = {5, 3, 4, 11};
        int arrLen = arr.length;
        
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        while(dp.size() < sum + 1) dp.add(null);
        dp.set(0, new ArrayList<Integer>());
        
        for(int i = 0; i <= sum; i++)
        {
            if(dp.get(i) != null)
            {
                for(int j = 0; j < arrLen; j++)
                {
                    if(i + arr[j] <= sum)
                    {
                        ArrayList<Integer> temp = new ArrayList<>(dp.get(i));   // need to create a new object 
                        temp.add(arr[j]);
                        dp.set(i + arr[j], temp);
                    }
                }
            }
        }
        System.out.println(dp.get(sum));
        // System.out.println(dp[sum]);
	}
}
