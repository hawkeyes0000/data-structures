/*
    Create a data structure kQueues that represents k queues. Implementation of kQueues should use only one array, i.e., k queues should use the 
    same array for storing elements. Following functions must be supported by kQueues.
    enqueue(int x, int qn) –> adds x to queue number ‘qn’ where qn is from 0 to k-1 
    dequeue(int qn) –> deletes an element from queue number ‘qn’ where qn is from 0 to k-1 
*/

public class Main 
{
    static class KQueues
    {
        int k;          // number of queues
        int n;          // total size of array
        int[] front;    // stores the front index of k queues
        int[] rear;     // stores the rear undex
        int[] next;     // stores the next index of ith queue
        int[] arr;      // stores the actual elements
        int free = 0;   // keeps track of current index number in arr 
        
        KQueues(int n, int k)
        {
            this.n = n;
            this.k = k;
            this.front = new int[k];
            this.rear = new int[k];
            this.next = new int[n];
            this.arr = new int[n];
            
            // initialize front and rear
            for(int i = 0; i < k; i++)
            {
                front[i] = rear[i] = -1;
            }
            // initialize next 
            for(int i = 0; i < n; i++)
            {
                next[i] = i + 1;
            }
            next[n - 1] = -1;   // end of the queue
        }
        
        void enqueue(int data, int q)
        {
            if(isFull())
            {
                System.out.println("Queue full!");
                return;
            }
            int nextFree = next[free];
            arr[free] = data;
            if(front[q] == -1)
            {
                front[q] = rear[q] = free;
            }
            else
            {
                next[rear[q]] = free;
                rear[q] = free;
            }
            next[free] = -1;
            free = nextFree;
        }
        
        int dequeue(int q)
        {
            if(isEmpty(q))
            {
                System.out.println("Empty queue!");
                return -1;
            }
            int frontIndex = front[q];
            front[q] = next[frontIndex];
            next[frontIndex] = free;
            free = frontIndex;
            
            return arr[frontIndex];
        }
        
        boolean isEmpty(int q)
        {
            return front[q] == -1;
        }
        
        boolean isFull()
        {
            return free == -1;
        }
    }
    
    
    public static void main(String[] args) 
    {
        int k = 3, n = 10;
        KQueues ks=  new KQueues(n, k);
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
         
        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0) );   
    }
}
