/*

    Given a binary tree, find its height.
    
    Example 1:
    Input:
         1
        /  \
       2    3
    Output: 2

    Example 2:
    Input:
      2
       \
        1
       /
     3
    Output: 3   

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)

*/

class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        int leftHeight = 1;
        int rightHeight = 1;
        if(node.left != null)
        {
            leftHeight += height(node.left);
        }
        if(node.right != null)
        {
            rightHeight += height(node.right);
        }
        
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
