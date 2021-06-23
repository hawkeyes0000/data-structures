/*
    Implement Queue from scratch
*/

public class Main 
{
    // template of a queue node
    static class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int data)
        {
            this.data = data;
        }
    }
    // operations on queue
    static class QueueADT
    {
        QueueNode first = null;
        QueueNode last = null;

        void add(int data)
        {
            QueueNode temp = new QueueNode(data);
            if(last != null)
            {
                last.next = temp;
            }
            last = temp;
            if(first == null)
            {
                first = last;
            }
        }

        int remove()
        {
            if(first == null)
            {
                System.out.println("Empty Queue!");
                return -1;
            }
            int temp = first.data;
            first = first.next;
            if(first == null)
            {
                last = null;
            }
            return temp;
        }

        int peek()
        {
            if(first == null)
            {
                System.out.println("Empty Queue!");
                return -1;
            }
            return first.data;
        }

        boolean isEmpty()
        {
            return first == null;
        }    
    }
    
    public static void main(String[] args) 
    {
        QueueADT q = new QueueADT();
        q.add(100);
        System.out.println(q.peek());
        q.add(200);
        q.add(300);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        q.add(5);
        System.out.println(q.peek());
    }
}
