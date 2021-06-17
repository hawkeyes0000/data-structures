/*
    Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value x, 
    without using any extra space? 

    Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
            x = 7
    Output: (6, 1), (5,2)
*/

#include<iostream>
using namespace std;
 
// structure of node of doubly linked list
struct Node
{
    int data;
    struct Node *next, *prev;
};
 
void pairSum(struct Node *head, int x)
{
    if(head->next == NULL)
    {
        cout << "Only one node found..." << endl;
        return;
    }
    Node *first = head;
    Node *last = head;
    while(last->next != NULL)
    {
        last = last->next;
    }
    
    while(first != last && first->prev != last && last->next != first)
    {
        if(first->data + last->data == x)
        {
            cout << "(" << first->data << "," << last->data << ")" << endl;
            first = first->next;
            last = last->prev;
        }
        else if(first->data + last->data > x)
        {
            last = last->prev;
        }
        else
        {
            first = first->next;
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
    insert(&head, 7);
    insert(&head, 6);
    insert(&head, 5);
    insert(&head, 5);
    insert(&head, 3);
    insert(&head, 1);
    
    print_list(&head);
    int x = 10;
 
    pairSum(head, x);
    
    return 0;
}
