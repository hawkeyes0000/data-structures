/*
    Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

    Input:
    LinkList1 = 3->6->9->common
    LinkList2 = 10->common
    common = 15->30->NULL
    Output: 15
    
    Auxiliary Space: O(1)
*/

int intersectPoint(Node* head1, Node* head2)
{
    int head1Len = 0;
    int head2Len = 0;
    // find lengths of both LL
    Node* temp1 = head1;
    while(temp1 != NULL)
    {
        ++head1Len;
        temp1 = temp1->next;
    }
    Node* temp2 = head2;
    while(temp2 != NULL)
    {
        ++head2Len;
        temp2 = temp2->next;
    }
    // get their difference
    int diff = abs(head1Len - head2Len);
    
    // find the longer LL
    Node* longerLLHead = NULL;
    Node* shorterLLHead = NULL;
    if(head1Len >= head2Len)
    {
        longerLLHead = head1;
        shorterLLHead = head2;
    }
    else
    {
        longerLLHead = head2;
        shorterLLHead = head1;
    }
    
    // skip the "diff" number of nodes from the longer LL, so that both the LL are of same size
    while(diff-- > 0)
    {
        longerLLHead = longerLLHead->next; 
    }
    
    // compare the nodes of both the LLs (not their values). If a same (intersection between the LLs) node is found, return its data
    while(longerLLHead != NULL && shorterLLHead != NULL)
    {
        if(longerLLHead == shorterLLHead)
        {
            return longerLLHead->data;
        }
        longerLLHead = longerLLHead->next;
        shorterLLHead = shorterLLHead->next;
    }
    
    // no intersection found
    return -1;
}

