#include <iostream>
using namespace std;

typedef struct Node
{
    Node* next = NULL;
    Node* prev = NULL;
    int data = 0;
}Node;

Node* get_node()
{
    Node* node = (Node*)malloc(sizeof(Node));
    return node;
}

// insert in the beginning
void insert_node(Node** head, int data)
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

Node* reverse(Node** head, int k)
{
    int count = 0;
    Node* current = (*head);
    Node* next = NULL;
    Node* previous = NULL;
    
    while(current != NULL && count < k)
    {
        next = current->next;
        current->next = previous;
        current->prev = next;
        previous = current;
        current = next;
        ++count;
    }
    previous->prev = NULL;
    if(next != NULL)
    {
        Node* newNode = reverse(&next, k);
        (*head)->next = newNode;
        newNode->prev = (*head);
    }

    (*head) = previous;
    return (*head);
}

int main() 
{
	Node* head = NULL;
	insert_node(&head, 2);
	insert_node(&head, 4);
	insert_node(&head, 8);
	insert_node(&head, 10);
	insert_node(&head, 100);
	print_list(&head);
	int k = 2;
	reverse(&head, k);
	print_list(&head);
	return 0;
}
