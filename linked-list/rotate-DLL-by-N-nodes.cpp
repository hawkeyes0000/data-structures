/*
    Given a doubly linked list, rotate the linked list counter-clockwise by N nodes. Here N is a given positive integer and is smaller than the count of nodes in linked list. 
    Input : a  b  c  d  e   N = 2
    Output : c  d  e  a  b 

    Input : a  b  c  d  e  f  g  h   N = 4
    Output : e  f  g  h  a  b  c  d 
*/

#include <iostream>
using namespace std;

typedef struct Node
{
    Node* next = NULL;
    Node* prev = NULL;
    char data = '\0';
}Node;

Node* get_node()
{
    Node* node = (Node*)malloc(sizeof(Node));
    return node;
}

// insert in the beginning
void insert_node(Node** head, char data)
{
    Node* newNode = get_node();
    if(!(*head))
    {
        *head = newNode;
        (*head)->data = data;
    }
    else
    {
        newNode->next = (*head);
        (*head)->prev = newNode;
        newNode->data = data;
        (*head) = newNode;
    }
}

void print_list(Node** head)
{
    Node* temp = (*head);
    while(temp != NULL)
    {
        cout << temp->data <<" ";
        temp = temp->next;
    }
    cout << endl;
}

void rotate(Node** head, int k)
{
    if(!(*head))
    {
        cout << "Empty list!" << endl;
        return;
    }
    
    Node* temp = (*head);
    while(k-- > 0)
    {
        temp = temp->next;
    }
    Node* newHead = temp;
    Node* lastNode = temp->prev;
    lastNode->next = NULL;
    temp->prev = NULL;
    
    while(temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = (*head);
    (*head)->prev = temp;
    (*head) = newHead;
}

int main() 
{
	Node* head;
	insert_node(&head,'e');
	insert_node(&head,'d');
	insert_node(&head,'c');
	insert_node(&head,'b');
	insert_node(&head,'a');
	print_list(&head);
    
    int k = 2;
    rotate(&head, k);
    print_list(&head);
	return 0;
}
