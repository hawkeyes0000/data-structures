class HeapSort
{
    int[] arr;
    int size;
    HeapSort(int[] arr, int size)
    {
        this.arr = arr;
        this.size = size;
    }
    
    private int left(int index) { return (index*2) + 1; }   // left child index
    private int right(int index) { return (index*2) + 2; }  // right child index 
    private int parent(int index) { return (index-1) / 2; } // parent index
    
    // heapify from top to bottom
    private void heapify(int index)
    {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if(left < size && arr[left] > arr[largest])
        {
            largest = left;
        }
        if(right < size && arr[right] > arr[largest])
        {
            largest = right;
        }
        if(largest != index)
        {
            swap(arr, largest, index);
            heapify(largest);
        }
    }
    
    // creates a max-heap out of an array
    private void buildHeap()
    {
        for(int i = (size-2)/2; i >= 0; i--)
        {
            heapify(i);
        }
    }
    
    // performs the heap-sort by calling all the utility functions
    void sort()
    {
        buildHeap();
        for(int i = size - 1; i > 0; i--)
        {
            swap(arr, i, 0);
            size--;
            heapify(0);
        }
    }
    
    private void swap(int[] arr, int largest, int index)
    {
        int temp = arr[largest];
        arr[largest] = arr[index];
        arr[index] = temp;
    }
    
    void print(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    int[] arr = new int[] {10, 52, 1, 12, 33, -213123, 33};
	    int size = arr.length;
	    HeapSort hs = new HeapSort(arr, size);
	    System.out.println("*** BEFORE SORT ***");
	    hs.print(arr);
	    System.out.println("*** AFTER SORT ***");
	    hs.sort();
	    hs.print(arr);
	}
}
