/*

    Given a Binary Search Tree. The task is to find the minimum element in this given BST.

    Example 1:

    Input:
               5
             /    \
            4      6
           /        \
          3          7
         /
        1
    Output: 1

    Example 2:

    Input:
                 9
                  \
                   10
                    \
                     11
    Output: 9


    Expected Time Complexity: O(Height of the BST)
    Expected Auxiliary Space: O(Height of the BST).

*/

class Tree
{
    //Function to find the minimum element in the given BST.
    int minValue(Node node)
    {
        if(node.left != null)
        {
            return minValue(node.left);
        }
        return node.data;
    }
}
