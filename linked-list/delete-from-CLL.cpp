/*
    We will be given a node and our task is to delete that node from the circular linked list.

    Examples: 

    Input : 2->5->7->8->10->(head node)
            data = 5
    Output : 2->7->8->10->(head node)

    Input : 2->5->7->8->10->(head node)
             7
    Output : 2->5->8->10->2(head node)
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    struct Node* next;
    int data;
}Node;

Node* get_node()
{
    Node* node = (Node*)malloc(sizeof(Node));
    node->next = NULL;
    node->data = 0;
    return node;
}

void insert_node(Node** head, int data)
{
    if(*head == NULL)
    {
        *head = get_node();
        (*head)->data = data;
        (*head)->next = *head;
    }
    else
    {
        Node* temp = (*head);
        while(temp->next != (*head))
        {
            temp = temp->next;
        }
        Node* newNode = get_node();
        newNode->data = data;
        newNode->next = (*head);
        temp->next = newNode;
    }
}

void print_list(Node** head)
{
    if((*head) == NULL)
    {
        printf("Nothing to print...\n");
    }
    else
    {
        Node* temp = (*head);
        do
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }while(temp != (*head));
        printf("\n");
    }
}

void delete_node(Node** head, int data)
{
    if((*head) == NULL)
    {
        printf("No node found. Nothing to delete....\n");
        return;
    }
    else
    {
        Node* temp = (*head);
        Node* prev = NULL;
        
        if(temp->next == (*head) && temp->data == data)
        {
            (*head) = NULL;
            free(temp);
            return;
        }
        
        while(temp->data != data)
        {
            if(temp->next == (*head))
            {
                printf("No such node found....\n");
                return;
            }
            prev = temp;
            temp = temp->next;
        }
        if(temp->next == (*head))
        {
            prev->next = (*head);
            temp->next = NULL;
            free(temp);
        }
        else if(temp == (*head))
        {
            Node* node = temp;
            while(node->next != (*head))
            {
                node = node->next;
            }
            (*head) = (*head)->next;
            node->next = (*head);
            free(temp);
        }
        else
        {
            prev->next = temp->next;
            temp->next = NULL;
            free(temp);
        }
    }
}

int main() 
{
	Node* head = NULL;
	insert_node(&head, 45);
	insert_node(&head, 35);
	insert_node(&head, 55);
	insert_node(&head, 65);
	print_list(&head);
	
	delete_node(&head, 35);
	delete_node(&head, 65);
	delete_node(&head, 35);
	delete_node(&head, 45);
	delete_node(&head, 55);
	print_list(&head);
	
	insert_node(&head, 65);
	delete_node(&head, 65);
	print_list(&head);
}
