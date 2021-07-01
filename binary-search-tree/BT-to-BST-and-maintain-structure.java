/*

    Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.

    Example 1:

    Input:
          1
        /   \
       2     3
    Output: 1 2 3


    Example 2:

    Input:
              1
           /    \
         2       3
       /        
     4       
    Output: 1 2 3 4
    Explanation:
    The converted BST will be

            3
          /   \
        2     4
      /
     1


    Expected Time Complexity: O(NLogN).
    Expected Auxiliary Space: O(N).

*/

/*
    STEP 1:- Perform inorder traversal on BT. Store result in an ArrayList
    STEP 2:- Sort the ArrayList
    STEP 3:- Perform inorder traversal once more, but this time replace the data from first element of array list
    STEP 4:- Return root
*/

class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        Collections.sort(list);
        convertTree(root, list);
        
        return root;
    }
    
    static void inorderTraverse(Node root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        inorderTraverse(root.left, list);
        list.add(root.data);
        inorderTraverse(root.right, list);
    }
    
    static void convertTree(Node root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        convertTree(root.left, list);
        root.data = list.remove(0);
        convertTree(root.right, list);
    }
}
 
