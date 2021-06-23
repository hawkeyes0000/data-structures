/*
    How to implement a stack which will support following operations in O(1) time complexity? 
    1) push() which adds an element to the top of stack. 
    2) pop() which removes an element from top of stack. 
    3) findMiddle() which will return middle element of the stack. 
    4) deleteMiddle() which will delete the middle element. 
     
*/

// use DLL
// NOTE - node.next represents the element just "below" the top, and node.prev represents the element just "above" the node.

public class Main 
{
    static class StackNode
    {
        int data;
        StackNode next;
        StackNode prev;
        StackNode(int data)
        {
            this.data = data;
        }
    }
    static class Stack
    {
        StackNode top;
        StackNode mid;
        int count;
        Stack()
        {
            this.count = 0;
            top = null;
            mid = null;
        }
        void push(Stack s, int data)
        {
            StackNode node = new StackNode(data);
            node.prev = null;
            if(s.top == null)
            {
                s.top = node;
                s.top.next = null;
            }
            else
            {
                node.next = s.top;
                s.top.prev = node;
                s.top = s.top.prev;
            }
            s.count++;
            if(s.count == 1)
            {
                s.mid = node;
            }
            else
            {
                if(s.count % 2 != 0)
                {
                    s.mid = s.mid.prev;
                }
            }
        }
        int pop(Stack s)
        {
            if(s.count == 0)
            {
                System.out.println("Empty stack!");
                return -1;
            }
            StackNode tempTop = s.top;
            s.count--;
            s.top = s.top.next;
            if(s.top != null)
            {
                s.top.prev = null;
            }
            if(s.count % 2 == 0)
            {
                s.mid = s.mid.next;
            }
            return tempTop.data;
        }
        boolean isEmpty(Stack s)
        {
            return s.count == 0;   
        }
        int mid(Stack s)
        {
            if(s.count == 0)
            {
                System.out.println("Empty stack!");
                return -1;
            }
            return s.mid.data;
        }
    }
    
    
    public static void main(String[] args) 
    {
        Stack s = new Stack();
        s.push(s, 100);
        s.push(s, 200);
        s.push(s, 300);
        s.push(s, 400);
        s.push(s, 500);
        s.push(s, 600);
        s.push(s, 700);
        s.pop(s);
        s.pop(s);
        s.pop(s);
        s.pop(s);
        s.pop(s);
        s.pop(s);
        s.pop(s);
        s.push(s, 700);
        s.push(s, 500);
        s.push(s, 200);
        System.out.println(s.mid(s));
    }
}
