/*
    You are given a string S, the task is to reverse the string using stack.
    
    Example 1:
    Input: S="GeeksforGeeks"
    Output: skeeGrofskeeG
*/

class Solution {
    
    public String reverse(String S)
    {
        int strLen = S.length();
        Stack<Character> stack = new Stack<>();
        String reversedString = "";
        
        for(char c : S.toCharArray())
        {
            stack.push(c);
        }
        
        while(!stack.isEmpty())
        {
            reversedString += String.valueOf(stack.peek());
            stack.pop();
        }
        return reversedString;
    }
}
