/*
    Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given circular 
    linked list then out of the resulting two halved lists, first list should have one node more than the second list. The resultant lists 
    should also be circular lists and not linear lists.
    
    Input: 
    Circular LinkedList: 1->5->7
    
    Output:
    1 5
    7
*/

void splitList(Node *head, Node **head1_ref, Node **head2_ref)
{
    if(head->next == NULL)
    {
        return;
    }
    Node* slow = head;
    Node* fast = head;
    
    // find the middle element
    while(fast->next->next != head && fast->next != head)
    {
        fast = fast->next->next;
        slow = slow->next;
    }
    *head1_ref = head;
    *head2_ref = slow->next;
    
    slow->next = head;  // first half will point back to head
    Node* temp = *head2_ref;  
    
    // traversing to the end of LL
    while(temp->next != head)
    {
        temp = temp->next;
    }
    temp->next = *head2_ref;    // setting the tail of second CLL to its head
}
