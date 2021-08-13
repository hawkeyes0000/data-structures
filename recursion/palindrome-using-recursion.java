/*package whatever //do not write package name here */

import java.io.*;

class GFG 
{
    static boolean palindrome(String str)
    {
        int len = str.length();
        return palindromeUtil(str, 0, len);
    }
    
    static boolean palindromeUtil(String str, int start, int end)
    {
        if(start >= end - 1)
        {
            return true;
        }
        
        return  (str.charAt(start) == str.charAt(end-1) &&
                 palindromeUtil(str, start + 1, end - 1));
    }
    
	public static void main (String[] args) 
	{
	    String str = "tatstarrattat";
		System.out.println(palindrome(str));
	}
}
