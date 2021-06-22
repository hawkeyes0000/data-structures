/*
    Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
    NOTE: Length of smallest the valid substring ( ) is 2.

    Example 1:

    Input: S = "(()("
    Output: 2
    Explanation: The longest valid 
    substring is "()". Length = 2.

    Example 2:

    Input: S = "()(())("
    Output: 6
    Explanation: The longest valid 
    substring is "()(())". Length = 6.
    
*/

/*
    STEP 1:
        Declare a Stack<Integer> stack. 
        stack.push(-1)  // provides base for next valid string
        Declare count = 0   // count for the valid string length
    STEP 2:
        For i = 0 to strLen:
            if char at str[i] is '('
                push i on the stack
            else
                pop from stack
                if stack becomes empty
                    push i on the stack
                else
                    set diff = i - stack.top()
                    if diff > count
                        set count = diff
    STEP 3:
        return count
*/

class Solution 
{
    static int findMaxLen(String S) 
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            if(c == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                if(stack.isEmpty())
                {
                    stack.push(i);
                }
                else
                {
                    int diff = i - stack.peek();
                    if(diff > count)
                    {
                        count = diff;
                    }
                }
            }
        }
        return count;
    }
};
