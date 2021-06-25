/*

    Given a binary tree, find its preorder traversal.

    Example 1:
    Input:
            1      
          /          
        4    
      /    \   
    4       2
    Output: 1 4 4 2 

    Example 2:
    Input:
           6
         /   \
        3     2
         \   / 
          1 2
    Output: 6 3 1 2 2 
    
    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(N).

*/

// iterative
/*
    Add root node to stack
    while stack is not empty:
        visit(stack.top)
        if stack.top.right is not null, push stack.top.right
        if stack.top.left is not null, push stack.top.left
*/
class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preorderList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node temp = stack.pop();
            preorderList.add(temp.data);
            if(temp.right != null)
            {
                stack.push(temp.right);
            }
            if(temp.left != null)
            {
                stack.push(temp.left);
            }
        }   
        return preorderList;
    }
}



// recursive
class BinaryTree
{
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preOrderList = new ArrayList<Integer>();
        performPreOrderTraversal(preOrderList, root);
        return preOrderList;
    }
    static void performPreOrderTraversal(ArrayList<Integer> postOrderList, Node root)
    {
        if(root == null)
        {
            return;
        }
        postOrderList.add(root.data);
        performPreOrderTraversal(postOrderList, root.left);
        performPreOrderTraversal(postOrderList, root.right);
    }
}
