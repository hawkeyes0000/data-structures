/*
    Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation 
    getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.

    Example 1:

    Input:
    Stack: 18 19 29 15 16
    Output: 15
    Explanation:
    The minimum element of the stack is 15.

*/

class GfG{
	public void push(int a,Stack<Integer> s)
	{
        s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        return s.pop();
	}
	public int min(Stack<Integer> s)
    {
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < s.size(); i++)
        {
            if(s.elementAt(i) < minVal)
            {
                minVal = s.elementAt(i);
            }
        }
        return minVal;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        return s.isEmpty();
	}
}
