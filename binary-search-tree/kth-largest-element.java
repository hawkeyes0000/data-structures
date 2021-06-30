/*

    Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

    Example 1:

    Input:
          4
        /   \
       2     9
    k = 2 
    Output: 4


    Example 2:

    Input:
           9
            \ 
              10
    K = 1
    Output: 10

    Expected Time Complexity: O(H + K).
    Expected Auxiliary Space: O(H)

*/

class Solution
{
    static class Count
    {
        int c = 0;
        int value = 0;
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        Count c  = new Count();
        kthLargestUtil(root, K, c);
        return c.value;
    }
    
    static void kthLargestUtil(Node root, int K, Count c)
    {
        if(root == null)
        {
            return;
        }
        kthLargestUtil(root.right, K, c);
        c.c++;
        if(c.c == K)
        {
            c.value = root.data;
            return;
        }
        kthLargestUtil(root.left, K, c);
    }
}
