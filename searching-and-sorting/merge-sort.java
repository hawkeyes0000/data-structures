/*

    Sort an array of integers using merge sort
    
    https://www.programiz.com/dsa/merge-sort

*/

public class Main 
{
    // recursively divides the array into smallest possible size, and then performs merge sort on them
    static void mergeSort(int[] arr, int low, int high)
    {
        if(high > low)
        {
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    
    // implements merge sort
    static void merge(int[] arr, int low, int mid, int high)
    {
        int n1 = (mid - low) + 1;
        int n2 = (high - mid);
        
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        
        for(int i = 0; i < n1; i++)
        {
            arr1[i] = arr[low + i];
        }
        for(int j = 0; j < n2; j++)
        {
            arr2[j] = arr[mid + j + 1];
        }
        
        int i = 0;
        int j = 0;
        int k = low;
        
        while(i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                arr[k] = arr1[i];
                i++;
            }
            else
            {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        while(i < n1)
        {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j < n2)
        {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
    
    // Takes random int input n times
    static void takeInput(int[] arr, int n)
    {
        int seed = 38;
        Random random = new Random(seed);
        for(int i = 0; i < n; i++)
        {
            arr[i] = random.nextInt(10000);
        }
    }
    
    // prints the array with specified message
    static void printArray(int[] arr, int n, String message)
    {
        System.out.println(message);
        for(int i = 0; i < n; i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    
    // driver function
    public static void main(String[] args) 
    {
        int n = 15;
        int arr[] = new int[n];
        takeInput(arr, n);
        printArray(arr, n, "Before sorting:");
        mergeSort(arr, 0, n-1);
        printArray(arr,n, "After sorting:");
    }
}
