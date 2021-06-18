/*
    Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
    
    Example 1:
    Input:
    N = 2
    LinkedList: 1->2->3->4->5->6->7->8->9
    Output: 8
    Explanation: In the first example, there
    are 9 nodes in linked list and we need
    to find 2nd node from end. 2nd node
    from end os 8.  
    
    Example 2:
    Input:
    N = 5
    LinkedList: 10->5->100->5
    Output: -1
    Explanation: In the second example, there
    are 4 nodes in the linked list and we
    need to find 5th from the end. Since 'n'
    is more than the number of nodes in the
    linked list, the output is -1.
    
*/

// idea is to find the required element only in one pass. use the runner-walker concept

int getNthFromLast(Node *head, int n)
{
    Node* walker = head;
    Node* runner = head;
    // move the runner node n spaces from walker
    for(int i = 0; i < n; i++)
    {
        if(runner == NULL)
        {
            return -1;
        }
        runner = runner->next;
    }
    
    // when the runner becomes null, we'll be at the nth node from end.
    while(runner != NULL)
    {
        runner = runner->next;
        walker = walker->next;
    }
    return walker->data;
}

