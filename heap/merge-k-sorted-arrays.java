/*

    Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
    Example 1:

    Input:
    K = 3
    arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
    Output: 1 2 3 4 5 6 7 8 9
    Explanation:Above test case has 3 sorted
    arrays of size 3, 3, 3
    arr[][] = [[1, 2, 3],[4, 5, 6], 
    [7, 8, 9]]
    The merged list will be 
    [1, 2, 3, 4, 5, 6, 7, 8, 9].

    Example 2:

    Input:
    K = 4
    arr[][]={{1,2,3,4}{2,2,3,4},
             {5,5,6,6},{7,8,9,9}}
    Output:
    1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
    Explanation: Above test case has 4 sorted
    arrays of size 4, 4, 4, 4
    arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
    [5, 5, 6, 6]  [7, 8, 9, 9 ]]
    The merged list will be 
    [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
    6, 6, 7, 8, 9, 9 ].

    Expected Time Complexity: O(K2*Log(K))
    Expected Auxiliary Space: O(K)

*/


class Node
{
    int data;
    int elementPosition;
    int arrayPosition;
    Node(int data, int elementPos, int arrayPos)
    {
        this.data = data;
        this.elementPosition = elementPos;
        this.arrayPosition = arrayPos;
    }
}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.data, b.data));
        
        for(int i = 0; i < K; i++)
        {
            minHeap.add(new Node(arr[i][0], 0, i));
        }
        while(!minHeap.isEmpty())
        {
            Node minNode = minHeap.poll();
            int data = minNode.data;
            int elementPos = minNode.elementPosition;
            int arrayNumber = minNode.arrayPosition;
            sortedList.add(data);
            if(elementPos + 1 < arr[arrayNumber].length)
            {
                ++elementPos;
                minHeap.add(new Node(arr[arrayNumber][elementPos], elementPos, arrayNumber));
            }
        }
        return sortedList;
    }
}
