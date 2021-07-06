/*

    Given an array of integers. Find the Inversion Count in the array. 

    Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. 
    If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
    Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


    Example 1:

    Input: N = 5, arr[] = {2, 4, 1, 3, 5}
    Output: 3
    Explanation: The sequence 2, 4, 1, 3, 5 
    has three inversions (2, 1), (4, 1), (4, 3).

    Example 2:

    Input: N = 5
    arr[] = {2, 3, 4, 5, 6}
    Output: 0
    Explanation: As the sequence is already 
    sorted so there is no inversion count.

    Example 3:

    Input: N = 3, arr[] = {10, 10, 10}
    Output: 0
    Explanation: As all the elements of array 
    are same, so there is no inversion count.

    Expected Time Complexity: O(NLogN).
    Expected Auxiliary Space: O(N).

*/

class Solution
{

    static long inversionCount(long arr[], long N)
    {
        int n=(int)N;
        return mergeSort(arr,0,n-1);
    }
    
    static long mergeSort(long arr[], int l, int r)
    {
        if (l < r) 
        {
            int m =l+ (r-l)/2;
            return mergeSort(arr, l, m)+mergeSort(arr, m + 1, r)+merge(arr, l, m, r);
        }
        else
        {
            return 0;  
        } 
    }
    
    static long merge(long arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        long inversion=0;
        /* Create temp arrays */
        long L[] = new long[n1];
        long R[] = new long[n2];
    
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
        {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
        }
            
    
        /* Merge the temp arrays */
    
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
    
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else 
            {
                inversion+=n1-i;
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return inversion;
    }
}
