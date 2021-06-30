/*

    Given a BST and an integer K. Find the Kth Smallest element in the BST. 

    Example 1:

    Input:
          2
        /   \
       1     3
    K = 2
    Output: 2

    Example 2:

    Input:
            2
          /  \
         1    3
    K = 5
    Output: -1

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(1).

*/

class Solution
{
    class Count
    {
        int currentCount = 0;
        int value = -1;
    }
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int K) 
    {
        Count c = new Count();
        KthSmallestElementUtil(root, K, c);
        return c.value;
    }
    
    void KthSmallestElementUtil(Node root, int K, Count c)
    {
        if(root == null || c.value > K)
        {
            return;
        }
        KthSmallestElementUtil(root.left, K, c);
        c.currentCount++;
        if(c.currentCount == K)
        {
            c.value = root.data;
            return;
        }
        KthSmallestElementUtil(root.right, K, c);
    }   
}
