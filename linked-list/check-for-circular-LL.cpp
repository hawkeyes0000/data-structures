/*
    Given a singly linked list, find if the linked list is circular or not. A linked list is called circular if it not NULL terminated and all nodes 
    are connected in the form of a cycle. An empty linked list is considered as circular.
*/

bool isCircular(Node *head)
{
    Node* node = head;
    while(node != NULL)
    {
        if(node->next == head)
        {
            return true;
        }
        node = node->next;
    }
    return false;
}
