/*

    Given a Binary Tree, find diameter of it.
    The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. 

    Example 1:
    Input:
           1
         /  \
        2    3
    Output: 3

    Example 2:
    Input:
             10
            /   \
          20    30
        /   \ 
       40   60
    Output: 4

    Your Task:
    You need to complete the function diameter() that takes root as parameter and returns the diameter.

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(Height of the Tree).

*/

class Solution 
{
    // returns the max of two values
    int max(int a, int b)
    {
        return a > b ? a : b;
    }
    
    // returns the height of the tree
    int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftHeight = 1;
        int rightHeight = 1;
        if(root.left != null)
        {
            leftHeight += height(root.left);
        }
        if(root.right != null)
        {
            rightHeight += height(root.right);
        }
        return max(leftHeight, rightHeight);
    }
    //Function to return the diameter of a Binary Tree.
    int diameter(Node root) 
    {
        if(root == null)
        {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        
        int finalDiameter = max(leftHeight + rightHeight + 1, max(leftDiameter, rightDiameter));
        return finalDiameter;
    }
}
