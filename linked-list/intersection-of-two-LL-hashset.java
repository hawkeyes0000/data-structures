/*
    Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
    Input:
    LinkList1 = 3->6->9->common
    LinkList2 = 10->common
    common = 15->30->NULL
    Output: 15    

    If there are no space constraints, we can go wild and use HashSet
*/

int intersectPoint(Node head1, Node head2)
{
    HashSet<Node> set = new HashSet<>();
    Node temp1 = head1;
    while(temp1 != null)
    {
        set.add(temp1);
        temp1 = temp1.next;
    }

    Node temp2 = head2;
    while(temp2 != null)
    {
        if(set.contains(temp2))
        {
            return temp2.data;
        }
        temp2 = temp2.next;
    }
    return -1;
}
