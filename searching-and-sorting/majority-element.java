/*
    Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears 
    more than N/2 times in the array. 

    Example 1:
    Input:
    N = 3 
    A[] = {1,2,3} 
    Output:
    -1
    Explanation:
    Since, each element in {1,2,3} appears only once so there is no majority element.

    Example 2:
    Input:
    N = 5 
    A[] = {3,1,3,3,2} 
    Output:
    3
    Explanation:
    Since, 3 is present more than N/2 times, so it is the majority element.

*/

// Moore’s Voting Algorithm
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) 
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) 
            {
                maj_index = i;
                count = 1;
            }
        }
        int cand = a[maj_index];
        count = 0;
        for (i = 0; i < size; i++) 
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return cand;
        else
            return -1;
    }
}
