/*
    
    Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first and last occurrences 
    of an element x in the given array.

    Example 1:

    Input:
    n=9, x=5
    arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
    Output:  2 5
    Explanation: First occurrence of 5 is at index 2 and last
                 occurrence of 5 is at index 5. 



    Example 2:

    Input:
    n=9, x=7
    arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
    Output:  6 6 


    Expected Time Complexity: O(logN)
    Expected Auxiliary Space: O(1).

 
*/

class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> list = new ArrayList<>();
        if(n == 0)
        {
            list.add((long)-1);
            list.add((long)-1);
            return list;
        }
        
        list.add(binarySearch(arr, x, "start"));
        list.add(binarySearch(arr, x, "end"));
        return list;
    }
    
    static long binarySearch(long[] arr, int x, String pos)
    {
        int l = 0;
        int r = arr.length - 1;
        long result = -1;
        while(r >= l)
        {
            int m = (l + r)/2;
            if(arr[m] == x && pos == "start")
            {
                result = m;
                r = m - 1;
            }
            else if(arr[m] == x && pos == "end")
            {
                result = m;
                l = m + 1;
            }
            else if(x < arr[m])
            {
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
        return result;
    }
}
