/*
    Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new list should be made 
    with its own memory — the original lists should not be changed.

    Input:
    L1 = 1->2->3->4->6
    L2 = 2->4->6->8
    Output: 2 4 6
    Explanation: For the given first two linked list, 2, 4 and 6 are the elements in the intersection.
*/

Node* findIntersection(Node* head1, Node* head2)
{
    Node* finalList = (Node*)malloc(sizeof(Node));  // head of the finalList
    // finalList->next = NULL;
    
    Node* temp1 = head1;    // temp variable to traverse head1
    Node* temp2 = head2;    // temp variable to traverse head2
    Node* finalTemp = NULL; // temp variable to traverse finalList
    
    while(temp1 != NULL && temp2 != NULL)
    {
        if(temp1->data == temp2->data)
        {
            if(finalTemp == NULL)   // we use this condition because we only want to create new nodes as they are detected
            {
                finalTemp = finalList;
            }
            else
            {
                Node* newNode = (Node*)malloc(sizeof(Node));
                finalTemp->next = newNode;
                finalTemp = finalTemp->next;
            }
            finalTemp->data = temp1->data;

            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        else if(temp1->data < temp2->data)
        {
            temp1 = temp1->next;
        }
        else
        {
            temp2 = temp2->next;
        }
    }
    
    return finalList;
}
