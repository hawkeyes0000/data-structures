// Given a linked list of N nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.

bool detectLoop(Node* head)
{
    Node* slow = head;  
    Node* fast = head;  // this will move twice as fast

    while(fast != NULL && slow != NULL && fast->next != NULL)
    {
        fast = fast->next->next;
        slow = slow->next;
        if(fast == slow)
        {
            return true;
        }
    }

    return false;
}
