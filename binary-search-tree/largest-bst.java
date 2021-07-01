/*

    Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.

    Example 1:

    Input:
            1
          /   \
         4     4
       /   \
      6     8
    Output: 1
    Explanation: There's no sub-tree with size
    greater than 1 which forms a BST. All the
    leaf Nodes are the BSTs with size equal
    to 1.

    Example 2:

    Input: 6 6 3 N 2 9 3 N 8 8 2
                6
            /       \
           6         3
            \      /   \
             2    9     3
              \  /  \
              8 8    2 
    Output: 2
    Explanation: The following sub-tree is a
    BST of size 2: 
           2
        /    \ 
       N      8

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(Height of the BST).

*/

// Approach 1:- O(N^2)
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        {
            return height(root);
        }
        else
        {
            return Math.max(largestBst(root.left), largestBst(root.right));
        }
    }
    
    static int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + height(root.left) + height(root.right);
    }
    
    static boolean isBST(Node root, int min, int max)
    {
        if(root == null)
        {
            return true;
        }
        if(root.data < min || root.data > max)
        {
            return false;
        }
        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }
}

// Approach 2:- O(N)
// https://www.youtube.com/watch?v=4fiDs7CCxkc
class Solution
{
    static class MinMax
    {
        boolean isBST;
        int min;
        int max;
        int size;
        MinMax()
        {
            isBST = true;   // null tree is a bst
            size = 0;
            min = Integer.MAX_VALUE;    // not sure why
            max = Integer.MIN_VALUE;
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        MinMax result = largestBstUtil(root);
        return result.size;
    }
    
    static MinMax largestBstUtil(Node root)
    {
        // return a new MinMax with isBST = true
        if(root == null)
        {
            return new MinMax();
        }
        // perform post-order traversal
        MinMax left = largestBstUtil(root.left);
        MinMax right = largestBstUtil(root.right);
        
        MinMax result = new MinMax();
        
        // if any of this is true, the node is not bst
        if(left.isBST == false || right.isBST == false || (left.max >= root.data || right.min <= root.data))
        {
            result.isBST = false;
            result.size = Math.max(left.size, right.size);
            return result;
        }
        
        // the node is a BST
        result.isBST = true;
        result.size = 1 + left.size + right.size;
        result.min = root.left != null ? left.min : root.data;
        result.max = root.right != null ? right.max : root.data;

        return result;
    }
}
