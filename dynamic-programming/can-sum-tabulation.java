/*
  Use tabulation to find if it is possible to create a sum using a group of numbers
*/

import java.util.*;
public class Main
{
    
	public static void main(String[] args) 
	{
        int sum = 8;
        int[] arr = {5, 3, 4};
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;   // always possible to create a sum of 0
        
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                if(dp[i] == true && (i + arr[j] < sum+1)) // if we can create a sum within specified bound
                {
                    dp[i+arr[j]] = true;
                }
            }
        }
        System.out.println(dp[sum]);
	}
}
