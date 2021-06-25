/*

    Perform postorder traversal

*/

// iterative
class Tree 
{
    ArrayList<Integer> postOrder(Node node) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> tempStack = new Stack<>();
        tempStack.push(node);
        while(!tempStack.isEmpty())
        {
            Node temp = tempStack.pop();
            stack.push(temp);
            if(temp.left != null)
            {
                tempStack.push(temp.left);
            }
            if(temp.right != null)
            {
                tempStack.push(temp.right);
            }
        }
        while(!stack.isEmpty())
        {
            list.add(stack.pop().data);
        }
        
        return list;
    }
}

// recursive
class Tree
{
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> postOrderList = new ArrayList<Integer>();
       performPostOrderTraversal(postOrderList, root);
       return postOrderList;
    }
    
    void performPostOrderTraversal(ArrayList<Integer> postOrderList, Node root)
    {
        if(root == null)
        {
            return;
        }
        performPostOrderTraversal(postOrderList, root.left);
        performPostOrderTraversal(postOrderList, root.right);
        postOrderList.add(root.data);
    }
}
