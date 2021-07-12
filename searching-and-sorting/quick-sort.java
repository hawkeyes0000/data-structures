/*
    
    Given an array of integers, sort it using quick sort.
    https://www.programiz.com/dsa/quick-sort
    
*/

/*
    Pivot = high
*/
public class Main 
{
    static void quickSort(int[] arr, int low, int high)
    {
        if(high > low)
        {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);   
        }
    }
    
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low; 
        int j = low;
        while(j < high)
        {
            if(arr[j] < pivot)
            {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, i, high);
        return i;
    }
    
    
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void takeInput(int[] arr, int n)
    {
        Random random = new Random();
        for(int i = 0; i < n; i++)
        {
            arr[i] = random.nextInt(100000);
        }
    }
    
    static void printArray(int[] arr, int n, String message)
    {
        System.out.println(message);
        for(int i = 0; i < n; i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) 
    {
        int n = 15;
        int arr[] = new int[n];
        takeInput(arr, n);
        printArray(arr, n, "Before sorting:");
        quickSort(arr, 0, n-1);
        printArray(arr,n, "After sorting:");
    }
}
