/*
    Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the array in 
    order of their appearance in the array.
    Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
    If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater 
    of the last element is always -1.

    Example 1:

    Input: 
    N = 4, arr[] = [1 3 2 4]
    Output:
    3 4 4 -1
    Explanation:
    In the array, the next larger element 
    to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
    since it doesn't exist, it is -1.

    Example 2:

    Input: 
    N = 5, arr[] [6 8 0 1 3]
    Output:
    8 -1 1 3 -1
    Explanation:
    In the array, the next larger element to 
    6 is 8, for 8 there is no larger elements 
    hence it is -1, for 0 it is 1 , for 1 it 
    is 3 and then for 3 there is no larger 
    element on right and hence -1.
*/

/*
    STEP 1: 
        Initialize the final array (int[] finalArray) of size n, and also a stack.
    STEP 2:
        Traverse the array in reverse order, until the index >= 0, and do the following for each value:
            a.  Retrieve the top value from stack. 
                If top is empty (empty stack) - set finalyArray[i] = -1, 
                else 
                if top > arr[i] - set finalArray[i] = top,
                else - while stack is not empty and top element is less than arr[i], pop the stack. if stack is non-empty after the while-block, 
                set finalArray[i] = top, else finalyArray[i] = -1
    STEP 3:
        push arr[i] to the stack
            
*/

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] finalArray = new long[n];
        Stack<Long> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--)
        {
            if(stack.isEmpty())
            {
                finalArray[i] = -1;
            }
            else
            {
                if(arr[i] < stack.peek())
                {
                    finalArray[i] = stack.peek();
                }
                else
                {
                    while(!stack.isEmpty() && stack.peek() < arr[i])
                    {
                        stack.pop();
                    }
                    if(!stack.isEmpty())
                    {
                        finalArray[i] = stack.peek();
                    }
                    else
                    {
                        finalArray[i] = -1;
                    }
                }    
            }
            
            stack.push(arr[i]);
        }
        return finalArray;
    } 
}
