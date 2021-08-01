/*

    Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

    Input:
    First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most 
    k positions away from its target position respectively. Second line of every test case consists of elements of array.

    Output:
    Single line output to print the sorted array.

    Constraints:
    1<=T<=100
    1<=N<=100
    1<=K<=N

    Example:
    Input:
    2
    3 3
    2 1 3
    6 3
    2 6 3 12 56 8
    Output:
    1 2 3
    2 3 6 8 12 56

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    while(T-- > 0)
	    {
	        int N = sc.nextInt();
	        int K = sc.nextInt();
	        int[] arr = new int[N];
	        for(int i = 0; i < N; i++)
	        {
	            arr[i] = sc.nextInt();
	        }
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        for(int i = 0; i < K; i++)
	        {
	            minHeap.add(arr[i]);
	        }
	        int index = 0;
	        for(int i = K; i < N; i++)
	        {
	            arr[index++] = minHeap.poll();
	            minHeap.add(arr[i]);
	        }
	        while(!minHeap.isEmpty())
	        {
	            arr[index++] = minHeap.poll();
	        }
	        for(int i = 0; i < N; i++)
	        {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}
}
