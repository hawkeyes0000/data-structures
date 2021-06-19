/*
    Implement stack using arrays
*/

#include <iostream>
#define n 5
using namespace std;

class CustomStack
{
    private:
        int s[n];
        int top;
    public:
        CustomStack()
        {
            top = -1;
        }
        void push(int data)
        {
            if(top == n - 1)
            {
                cout << "Stack full!\n";
                return;
            }
            top++;
            s[top] = data;
        }

        int pop()
        {
            if(top == -1)
            {
                return -1;
            }
            else
            {
                int temp = s[top];
                --top;
                return temp;
            }
        }

        int peek()
        {
            if(top == -1)
            {
                cout<<"Stack empty!\n";
                return -1;
            }
            return s[top];
        }

        bool isEmpty()
        {
            return top == -1;
        }
};


int main() 
{
    CustomStack s;
    cout << s.peek() << endl;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    cout<<s.peek()<<endl;
    s.push(100);
    s.pop();
    cout<<s.peek()<<endl;
    s.push(100);
    cout<<s.peek()<<endl;
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    cout<<s.peek()<<endl;
}
