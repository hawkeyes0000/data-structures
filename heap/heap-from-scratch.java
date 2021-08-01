class MinHeap
{
    int[] arr;
    int capacity;
    int size;
    
    MinHeap(int capacity)
    {
        arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    
    int left(int i) { return (i*2) + 1; }
    int right(int i) { return (i*2) + 2; }
    int parent(int i) { return (i-1) / 2; }
    
    void insert(int element)
    {
        if(size == capacity)
        {
            System.out.println("OVERFLOW!");
            return;
        }
        size++;
        arr[size - 1] = element;
        int currIndex = size - 1;
        while(currIndex != 0 && arr[parent(currIndex)] > arr[currIndex])
        {
            this.swap(parent(currIndex), currIndex);
            currIndex = parent(currIndex);
        }
    }
    
    void heapify(int index)
    {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int smallest = index;
        
        if(leftIndex < size && arr[leftIndex] < arr[smallest]) { smallest = leftIndex; }
        if(rightIndex < size && arr[rightIndex] < arr[smallest]) { smallest = rightIndex; }
        
        if(smallest != index) 
        {
            swap(smallest, index);
            heapify(smallest);
        }
    }
    
    int extractMin()
    {
        if(size == 0)
        {
            return -1;
        }
        size--;
        int min = arr[0];
        if(size == 0)
        {
            return min;
        }
        arr[0] = arr[size];
        heapify(0);
        return min;
    }
    
    void decreaseKey(int key, int value)
    {
        if(key > size || value > arr[key])
        {
            System.out.println("Invalid operation!");
            return;
        }
        arr[key] = value;
        while(key != 0 && arr[parent(key)] > arr[key])
        {
            swap(parent(key), key);
            key = parent(key);
        }
    }
    
    void delete(int index)
    {
        if(index > size)
        {
            System.out.print("Invalid operation!");
            return;
        }
        this.decreaseKey(index, Integer.MIN_VALUE);
        this.extractMin();
        // size--;
        // if(size != 0)
        // {
        //     arr[index] = arr[size];
        //     heapify(index);
        // }
    }
    
    void printHeap(int[] arr)
    {
        if(size == 0)
        {
            System.out.println("Empty Heap!");
            return;
        }
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    
    void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

public class Main
{
	public static void main(String[] args) 
	{
		MinHeap heap = new MinHeap(10);
		heap.insert(10);
		heap.insert(50);
		heap.insert(100);
		heap.insert(1);
		heap.insert(7458);
		heap.insert(52);
		heap.insert(66);
		heap.insert(7);
		heap.printHeap(heap.arr);
		heap.delete(4);
		heap.printHeap(heap.arr);
		heap.delete(6);
		heap.printHeap(heap.arr);
		heap.delete(0);
		heap.printHeap(heap.arr);
		heap.insert(1);
		heap.printHeap(heap.arr);
	}
}
