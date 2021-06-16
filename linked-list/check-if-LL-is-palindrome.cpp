/*
    Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
    
    Input:
    N = 3
    value[] = {1,2,1}
    Output: 1
    
    Explanation: The given linked list is 1 2 1 , which is a palindrome and Hence, the output is 1.
    NOTE - The challenge is to use O(1) auxiliary space
*/

class Solution{
  public:
    //Function to check whether the list is palindrome.
    bool isPalindrome(Node *head)
    {
        if(head->next == NULL)
        {
            return true;
        }
        Node* slow = head;
        Node* fast = head;
        
        // find middle element
        while(fast->next != NULL && fast->next->next != NULL)
        {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        Node* middle = slow;

        // reverse the list from slow->next to tail
        Node* current = middle->next;
        Node* previous = NULL;
        Node* next = NULL;
        while(current != NULL)
        {
            next = current->next;
            current->next = previous;
            previous = current;
            current = next;
        }
        
        // compare both LL
        Node* temp = head;
        middle->next = NULL;
        while(temp != NULL && previous != NULL)
        {
            if(temp->data != previous->data)
            {
                return false;
            }
            temp = temp->next;
            previous = previous->next;
        }
        return true;
        // we also need to reconstruct back the LL to its original form, but i have skipped that part for time being.
    }
};
