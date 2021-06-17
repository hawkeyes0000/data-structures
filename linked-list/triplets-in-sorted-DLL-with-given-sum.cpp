/*
    Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. Count triplets in the list that sum up to a given value x.

    Input : DLL: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9 x = 17 
    Output : 2 
    The triplets are: (2, 6, 9) and (4, 5, 8) 

    Input : DLL: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9 x = 15 
    Output : 5 
*/

#include<iostream>
using namespace std;
 
// structure of node of doubly linked list
struct Node
{
    int data;
    struct Node *next, *prev;
};
 
void tripletSum(struct Node *head, int x)
{
    // if less than 3 nodes
    if(head == NULL || head->next == NULL || head->next->next == NULL)
    {
        cout << "Not enough nodes..." << endl;
        return;
    }
    Node *first = head;
    Node *last = head;
    while(last->next != NULL)
    {
        last = last->next;
    }
    Node *secondLast = last->prev;
    
    // iterate till 3*greatest element has a value greater than x,
    // for all the other cases, the sum will always be less than x
    while(last->data * 3 > x)
    {
        // if sum 
        if(last->data + secondLast->data + first->data == x)
        {
            cout << "(" << first->data << "," << secondLast->data << "," << last->data << ")" << endl;
            first = first->next;
            secondLast = secondLast->prev;
        }
        else if(last->data + secondLast->data + first->data < x)
        {
            first = first->next;
        }
        else
        {
            secondLast = secondLast->prev;
        }
        if(secondLast->data < first->data || first->data > secondLast->data || first->data == secondLast->data)
        {
            last = last->prev;
            secondLast = last->prev;
            first = head;
        }
    }
}
 
// insert in the beginning
void insert(struct Node **head, int data)
{
    struct Node *temp = new Node;
    temp->data = data;
    temp->next = temp->prev = NULL;
    if (!(*head))
        (*head) = temp;
    else
    {
        temp->next = *head;
        (*head)->prev = temp;
        (*head) = temp;
    }
}
 
void print_list(Node **head)
{
    Node *temp = *head;
    while(temp != NULL)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}
 
int main()
{
    struct Node *head = NULL;
    insert(&head, 9);
    insert(&head, 8);
    insert(&head, 6);
    insert(&head, 5);
    insert(&head, 4);
    insert(&head, 2);
    insert(&head, 1);
    
    print_list(&head);
    int x = 15;
 
    tripletSum(head, x);
    
    return 0;
}
