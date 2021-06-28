/*

    Given a binary tree. Check whether it is a BST or not.
    Note: We are considering that BSTs can not contain duplicate Nodes.

    Example 1:

    Input:
        2
     /    \
    1      3
    Output: 1 
    Explanation: 
    The left subtree of root node contains node 
    with key lesser than the root node’s key and 
    the right subtree of root node contains node 
    with key greater than the root node’s key.
    Hence, the tree is a BST.

    Example 2:

    Input:
      2
       \
        7
         \
          6
           \
            5
             \
              9
               \
                2
                 \
                  6
    Output: 0 
    Explanation: 
    Since the node with value 7 has right subtree 
    nodes with keys less than 7, this is not a BST.

*/

// USING INORDER TRAVERSAL
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i = 1; i < list.size(); i++)
        {
            if(list.get(i) <= list.get(i - 1))
            {
                return false;
            }
        }
        return true;
        
    }
    static void inorder(Node root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}


// RECURSIVE APPROACH
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isBSTUtil(Node root, int min, int max)
    {
        if(root == null)
        {
            return true;
        }
        
        if(root.data < min || root.data > max)
        {
            return false;
        }
        return (isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max));
    }
}
