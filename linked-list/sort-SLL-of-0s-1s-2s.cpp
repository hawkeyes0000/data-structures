/*
    Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list 
    such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

    Example 1:
    Input:
    N = 8
    value[] = {1,2,2,1,2,0,2,2}
    Output: 0 1 1 2 2 2 2 2
    Explanation: All the 0s are segregated
    to the left end of the linked list,
    2s to the right end of the list, and
    1s in between.
    
    Input:
    N = 4
    value[] = {2,2,0,1}
    Output: 0 1 2 2
    Explanation: After arranging all the
    0s,1s and 2s in the given format,
    the output will be 0 1 2 2.

*/

// The approach doesn't actually sort the nodes, but changes their values. For a proper "sort", moves the zero-valued nodes to front, and two-valued to the end. 
// Don't move one-valued nodes.

class Solution
{
    public:
    //Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate(Node *head) 
    {
        if(head == NULL || head->next == NULL)
        {
            return head;
        }
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node* temp = head;
        while(temp != NULL)
        {
            if(temp->data == 0)
            {
                ++zeroCount;
            }
            else if(temp->data == 1)
            {
                ++oneCount;
            }
            else
            {
                ++twoCount;
            }
            temp = temp->next;
        }
        
        Node* t = head;
        while(t != NULL)
        {
            if(zeroCount > 0)
            {
                t->data = 0;
                --zeroCount;
            }
            else if(oneCount > 0)
            {
                t->data = 1;
                --oneCount;
            }
            else
            {
                t->data = 2;
                twoCount--;
            }
            t = t->next;
        }
        
        return head;
    }
};
