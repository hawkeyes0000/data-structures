/*
    Implement stack using Linked List
*/

#include<iostream>
using namespace std;

class Stack
{
    public:
    int data;
    Stack* next;
    Stack(int data)
    {
        data = data;
        next = NULL;
    }
};

class StackUsingLL
{
    private:
    Stack* top;
    
    public:
    StackUsingLL()
    {
        top = NULL;
    }
    void push(int data)
    {
        Stack* temp = new Stack(data);
        if(top == NULL)
        {
            top = temp;
        }
        else
        {
            temp->next = top;
            top = temp;
        }
        top->data = data;
    }
    void pop()
    {
        if(top == NULL)
        {
            cout<<"Empty Stack!\n";
            return;
        }
        Stack* temp = top;
        top = top->next;
        temp->next = NULL;
    }
    int peek()
    {
        if(top == NULL)
        {
            cout<<"Empty stack!\n";
            return -1;
        }
        return top->data;
    }
    bool isEmpty()
    {
        return top == NULL;
    }
};

int main()
{   
    StackUsingLL s;
    s.push(100);
    cout<<s.peek()<<endl;
    s.push(101);
    s.push(102);
    s.push(103);
    cout<<s.peek()<<endl;
    s.pop();
    cout<<s.peek()<<endl;
    s.pop();
    s.pop();
    s.pop();
    cout<<s.peek()<<endl;
}
