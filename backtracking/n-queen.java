/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG 
{
    
    static boolean isSafe(int[][] res, int N, int i, int j)
    {
        // check column
        for(int n = i-1; n >= 0; n--)
        {
            if(res[n][j] == 1)
            {
                return false;
            }
        }
        // check left diagonal
        for(int n = i-1, m = j-1; n >= 0 && m >= 0; n--, m--)
        {
            if(res[n][m] == 1)
            {
                return false;
            }
        }
        // check right diagonal
        for(int n = i-1, m = j+1; n >= 0 && m < N; n--, m++)
        {
            if(res[n][m] == 1)
            {
                return false;
            }
        }
        
        // everything OK. 
        return true;
    }
    
    static boolean nQueen(int[][] res, int N, int i)
    {
        // if we overshoot N, it means we have found a solution
        if(i == N)
        {
            return true;
        }
        for(int j = 0; j < N; j++)
        {
            // safe to place queen at current position?
            if(isSafe(res, N, i, j))
            {
                // place the queen
                res[i][j] = 1;
                // is a solution possible with current configuration?
                if(nQueen(res, N, i+1))
                {
                    // yes it is, return true
                    return true;
                }
                // solution not possible with current configuration
                res[i][j] = 0;
            }
        }
        // searched all the columns... solution is not possible.
        return false;
    }
    
    static void printMatrix(int[][] res, int N)
    {
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
	public static void main (String[] args) 
	{
	    int N = 10;
	    int[][] res = new int[N][N];
	    System.out.println(nQueen(res, N, 0));
	    printMatrix(res, N);
	}
}
