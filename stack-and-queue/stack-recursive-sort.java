/*
    Given a stack, the task is to sort it such that the top of the stack has the greatest element.

    Example 1:

    Input:
    Stack: 3 2 1
    Output: 3 2 1

    Example 2:

    Input:
    Stack: 11 2 32 3 41
    Output: 41 32 11 3 2

*/

class GfG
{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    if(!s.isEmpty())
	    {
	        int top = s.pop();
	        sort(s);
	        sortStack(s, top);
	    }
	    return s;
	}
	
	static Stack<Integer> sortStack(Stack<Integer> s, int top)
	{
	    if(s.isEmpty() || top > s.peek())
	    {
	        s.push(top);
	        return s;
	    }
	    else
	    {
            int temp = s.pop();
            sortStack(s, top);
            s.push(temp);
	    }
	    return s;
	}
}
