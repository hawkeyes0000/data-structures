/*

    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b



    Example 1:

    Input: arr = [1,2,3,4,5], k = 4, x = 3
    Output: [1,2,3,4]

    Example 2:

    Input: arr = [1,2,3,4,5], k = 4, x = -1
    Output: [1,2,3,4]



    Constraints:

        1 <= k <= arr.length
        1 <= arr.length <= 104
        arr is sorted in ascending order.
        -104 <= arr[i], x <= 104
    
*/

class Solution 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> list = new ArrayList<>();
        int arrLen = arr.length;
        if(x < arr[0])
        {
            for(int i = 0; i < k; i++)
            {
                list.add(arr[i]);
            }
        }
        else if(x > arr[arrLen - 1])
        {
            for(int i = arrLen - k; i < arr.length; i++)
            {
                list.add(arr[i]);
            }
        }
        else
        {
            int start = 0;
            int end = arrLen - 1;
            while((end - start) + 1 != k)
            {
                if(Math.abs(x - arr[start]) > Math.abs(x - arr[end]))
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
            for(int i = start; i <= end; i++)
            {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
