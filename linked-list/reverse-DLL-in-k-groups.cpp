/*
    Given a doubly linked list containing n nodes. The problem is to reverse every group of k nodes in the list.
    
    Input : 
    DLL: 10<->8<->4<->2 k = 2 
    Output : 8<->1O<->2<->4 
        
    Input : 1<->2<->3<->4<->5<->6<->7<->8 k = 3 
    Output : 3< - >2< - >1< - >6< - >5< - >4< - >8< - >7 
*/

#include <iostream>
using namespace std;

typedef struct Node
{
    Node* next = NULL;
    Node* prev = NULL;
    char int = 0;
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

Node* reverse(Node** head, int k)
{
    if(!(*head))
    {
        cout << "Empty LL!" << endl;
        return;
    }
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
    if(next != NULL)
    {
        Node* nextHead = reverse(next, k);    
        nextHead->prev = (*head);
        current->next = nextHead;
        
    }
    
    return (*head);
}

int main() 
{
	Node* head;
	insert_node(&head, 2);
	insert_node(&head, 4);
	insert_node(&head, 8);
	insert_node(&head, 10);
	
    int k = 2;
    reverse(&head, k);
    print_list(&head);
	return 0;
}
