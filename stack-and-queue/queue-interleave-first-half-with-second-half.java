/*  
    Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.

    Only a single stack can be used as an auxiliary space.

    Examples:

    Input :  1 2 3 4
    Output : 1 3 2 4

    Input : 11 12 13 14 15 16 17 18 19 20
    Output : 11 16 12 17 13 18 14 19 15 20

*/

/*
    STEP 1:
        Push the first half in stack
    STEP 2:
        Enqueue them back into queue
    STEP 3:
        *** Dequeue the first half and enqueue back immediately ***
    STEP 4:
        Push the first half again into the stack
    STEP 5:
        Finally, interleave the elements, first from stack then from queue.
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
        
        int size()
        {
            QueueNode temp = first;
            int count = 0;
            while(temp != null)
            {
                ++count;
                temp = temp.next;
            }
            return count;
        }
        
        void interleave(QueueADT q)
        {
            Stack<Integer> stack = new Stack<>();   
            int size = q.size();
            
            // push the first half
            for(int i = 0; i < size/2; i++)
            {
                stack.push(q.remove());
            }
            // enqueue the first half
            while(!stack.isEmpty())
            {
                q.add(stack.pop());
            }
            // push the first half of queue, and enqueue immediately
            for(int i = 0; i < size/2; i++)
            {
                stack.push(q.remove());
                q.add(stack.pop());
            }
            // push first half again
            for(int i = 0; i < size/2; i++)
            {
                stack.push(q.remove());
            }
            // interleave
            while(!stack.isEmpty())
            {
                q.add(stack.pop());
                q.add(q.remove());
            }
        }
        
        void printQueue(QueueADT q)
        {
            QueueNode temp = q.first;
            while(temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("");
        }
    }   
    
    public static void main(String[] args) 
    {
        QueueADT q = new QueueADT();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        System.out.println("Before interleave: ");
        q.printQueue(q);
        q.interleave(q);
        System.out.println("After interleave: ");
        q.printQueue(q);
        
    }
}
