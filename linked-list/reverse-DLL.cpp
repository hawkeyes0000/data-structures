/*
    Given a doubly linked list of n elements. The task is to reverse the doubly linked list.

    Example 1:
    Input:
    LinkedList: 3 <--> 4 <--> 5
    Output: 5 4 3

    Example 2:
    Input:
    LinkedList: 75 <--> 122 <--> 59 <--> 196
    Output: 196 59 122 75

*/

Node* reverseDLL(Node* head)
{
    //Your code here
    if(head->next == NULL)
    {
        return head;
    }
    Node* current = head;
    Node* previous = NULL;
    Node* nextNode = NULL;
    while(current != NULL)
    {
        nextNode = current->next;
        current->prev = nextNode;
        current->next = previous;
        previous = current;
        current = nextNode;
    }
    head = previous;
    return head;
}
