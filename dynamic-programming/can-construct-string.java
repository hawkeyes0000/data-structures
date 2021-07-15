/*
    Given a target string and an array of strings, find out if the target string can be formed by a combination of array strings. Reuse of array strings
    is allowed.
*/

import java.util.*;
public class Main
{
    
    static boolean canConstruct(String target, String[] arr, HashMap<String, Boolean> map)
    {
        if(target.equals(""))
        {
            return true;
        }
        if(map.containsKey(target))
        {
            return map.get(target);
        }
        for(String s : arr)
        {
            if(target.startsWith(s))
            {
                map.put(target, canConstruct(target.substring(s.length()), arr, map));
                if(map.get(target) == true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) 
	{
	    System.out.println( canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
	                        new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeeeee", "eeeeeeeee"}, 
	                        new HashMap<String, Boolean>()) );	
	}
}
