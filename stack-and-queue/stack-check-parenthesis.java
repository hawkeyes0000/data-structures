/*
    Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
    For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.

    Example 1:

    Input:
    {([])}
    Output: 
    true
    Explanation: 
    { ( [ ] ) }. Same colored brackets can form balaced pairs, with 0 number of unbalanced bracket.

    Example 2:

    Input: 
    ()
    Output: 
    true
    Explanation: 
    (). Same bracket can form balanced pairs, and here only 1 type of bracket is present and in balanced way.

    Example 3:

    Input: 
    ([]
    Output: 
    false
    Explanation: 
    ([]. Here square bracket is balanced but the small bracket is not balanced and Hence , the output will be unbalanced.
    
*/

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();
        int strLen = x.length();
        for(int i = 0; i < strLen; i++)
        {
            char c = x.charAt(i);
            if(c == '[' || c == '{' || c == '(')
            {
                stack.push(c);
            }
            else
            {
                // if the first character itself is a closing brace
                if(stack.isEmpty())
                {
                    return false;
                }
                char topChar = stack.peek();
                if((c == ']' && topChar == '[') || (c == '}' && topChar == '{') || (c == ')' && topChar == '('))
                {
                    stack.pop();
                }
                else    // if the topChar isn't an opening brace for current char
                {
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
        {
            return false;
        }
        return true;
    }
}
