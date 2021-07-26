class MinHeap
{
    int[] arr;
    int capacity;
    int hPtr;
    
    MinHeap(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        hPtr = 0;
    }
    void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    int parent(int i) { return arr[(i-1)*2]; }
    int left(int i) { return arr[(i*2) + 1]; }
    int right(int i) { return arr[(i*2) + 2]; }
    void insert(int data)
    {
        if(hPtr == capacity)
        {
            System.out.println("OVERFLOW!\n");
            return;
        }
        
        hPtr++;
        int index = hPtr - 1;
        arr[index] = data;
        
        while(index > 0 && arr[parent(index)] > arr[index])
        {
            swap(parent(index), index);
            index = parent(index);
        }
        
    }
    int getMin()
    {
        // if(hPtr == 0)
        // {
        //     return -1;
        // }
        return arr[hPtr];
    }
}


public class Main
{
	public static void main(String[] args) 
	{
		MinHeap heap = new MinHeap(20);
		heap.insert(10);
// 		heap.insert(4);
// 		heap.insert(1);
		System.out.println(heap.getMin());
	}
}
