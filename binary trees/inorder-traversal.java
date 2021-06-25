/*

    Perform inorder traversal, both recursively and iteratively

*/

// Recursive
class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> inOrderList = new ArrayList<Integer>();
        performInOrderTraversal(inOrderList, root);
        return inOrderList;
    }
    
    void performInOrderTraversal(ArrayList<Integer> inOrderList, Node root)
    {
        if(root == null)
        {
            return;
        }
        performInOrderTraversal(inOrderList, root.left);
        inOrderList.add(root.data);
        performInOrderTraversal(inOrderList, root.right);
    }
}


// Iterative
class Solution 
{
    ArrayList<Integer> inOrder(Node root) 
    {
        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(!stack.isEmpty() || temp != null)
        {
            if(temp!= null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            else
            {
                Node visitMe = stack.pop();
                inorder.add(visitMe.data);
                temp = visitMe.right;
            }
        }
        return inorder;
    }
}
