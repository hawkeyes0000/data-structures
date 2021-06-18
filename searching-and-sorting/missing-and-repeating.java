/*

    Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. 
    Find these two numbers.

    Example 1:

    Input:
    N = 2
    Arr[] = {2, 2}
    Output: 2 1
    Explanation: Repeating number is 2 and 
    smallest positive missing number is 1.

    Example 2:

    Input:
    N = 3
    Arr[] = {1, 3, 3}
    Output: 3 2
    Explanation: Repeating number is 3 and 
    smallest positive missing number is 2.

*/

class Solve 
{
    int[] findTwoElement(int arr[], int n) 
    {
        int[] result = new int[2];
        // traverse array, if the value at the arr[value] index i.e. arr[arr[value]] is not negative, make it negative,
        // else, if it already negative, that value is the repeating value.
        for(int i = 0; i < n; i++)
        {
            if(arr[Math.abs(arr[i]) - 1] > 0)
            {
                arr[Math.abs(arr[i]) - 1] = -1 * arr[Math.abs(arr[i]) - 1];
            }
            else
            {
                result[0] = Math.abs(arr[i]); // repeating number
            }
        }
        
        // find the first positive value, that value is the missing value
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > 0)
            {
                result[1] = i + 1; // missing number
            }
        }
        
        return result;
    }
}
