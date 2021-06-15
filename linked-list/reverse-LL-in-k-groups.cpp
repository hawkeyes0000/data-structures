struct node *reverse (struct node *head, int k)
{ 
    int count = 0;
    struct node* prev = NULL;
    struct node* current = head;
    struct node* next = NULL;
    while(current != NULL && count < k)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
        count++;
    }
    if(next != NULL)
    {
        head->next = reverse(next, k);
    }
    return prev;
}
