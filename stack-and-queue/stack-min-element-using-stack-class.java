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


// ALTERNATE APPROACH WITH LINEAR TIME AND SPACE
// While pushing, if element < min, push(2*element - m)
// While popping, if element < min, set min = 2*min - poppedElement, and return previous min.
class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
       if(s.isEmpty())
       {
           return -1;
       }
       return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    if(s.isEmpty())
	    {
	        return -1;
	    }
	    int elePopped = s.pop();
	    if(elePopped < minEle)
	    {
	        int tempMinEle = minEle;
	        minEle = minEle*2 - elePopped;
	        return tempMinEle;
	    }
	    return elePopped;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    if(s.isEmpty())
	    {
	        s.push(x);
	        minEle = x;
	    }
	    else if(x < minEle)
	    {
	        s.push(2*x - minEle);
	        minEle = x;
	    }
	    else
	    {
	        s.push(x);
	    }
    }	
}

