/*package whatever //do not write package name here */

import java.io.*;

class GFG 
{
    
    static void towerOfHanoi(int n, String a, String b, String c)
    {
        if(n == 1)
        {
            System.out.println("Move " + n + " from " + a + " to " + c);
            return;
        }
        towerOfHanoi(n-1, a, c, b);
        System.out.println("Move " + n + " from " + a + " to " + c);
        towerOfHanoi(n-1, b, a, c);
    }
    
	public static void main (String[] args) 
	{
		int n = 4;
		towerOfHanoi(n, "a", "b", "c");
	}
}
