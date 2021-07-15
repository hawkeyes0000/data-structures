/*
    Find number of ways to create the target string from an array of strings
*/

import java.util.*;
public class Main
{
    static int canConstruct(String target, String[] arr, HashMap<String, Integer> map)
    {
        if(target.equals(""))
        {
            return 1;
        }
        if(map.containsKey(target))
        {
            return map.get(target);
        }
        int totalCount = 0;
        for(String s : arr)
        {
            if(target.startsWith(s))
            {
                totalCount += canConstruct(target.substring(s.length()), arr, map);
            }
        }
        map.put(target, totalCount);
        return totalCount;
    }
    
	public static void main(String[] args) 
	{
	    System.out.println( canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
	                        new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeeeee", "eeeeeeeee", "ef"}, 
	                        new HashMap<String, Integer>()) );	
	   System.out.println( canConstruct("abcdef", 
	                        new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}, 
	                        new HashMap<String, Integer>())  );	
	}
}
