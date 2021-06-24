/*
    Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

    Only following standard operations are allowed on queue.

        enqueue(x) : Add an item x to rear of queue
        dequeue() : Remove an item from front of queue
        size() : Returns number of elements in queue.
        front() : Finds front item.

    Example 1:
    Input:
    5 3
    1 2 3 4 5
    Output: 
    3 2 1 4 5
    Explanation: 
    After reversing the given input from the 3rd position the resultant output will be 3 2 1 4 5.

    Example 2:
    Input:
    4 4
    4 3 2 1
    Output: 
    1 2 3 4
    Explanation: 
    After reversing the given input from the 4th position the resultant output will be 1 2 3 4.

    Expected TIme Complexity : O(n)
    Expected Auxilliary Space : O(n)
    
*/

class GfG
{
    //Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> stack = new Stack<>();   // to hold the k elements
        Queue<Integer> reversedQueue = new LinkedList<>();  // final queue
        // push k elements into stack
        while(k-- > 0)
        {
            stack.push(q.remove());
        }
        // enqueue from stack to queue
        while(!stack.isEmpty())
        {
            reversedQueue.add(stack.pop());
        }
        // enqueue rest of the elements from original queue
        while(!q.isEmpty())
        {
            reversedQueue.add(q.remove());
        }
        return reversedQueue;
    }
}
