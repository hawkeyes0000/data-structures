/*

    Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.

    Example 1:

    Input:
          1
        /   \
       3     2
    Output:1 3 2

    Example 2:

    Input:
               10
             /     \
            20     30
          /    \
        40     60
    Output: 10 20 30 60 40 


*/

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        findSpiralUtil(list, stack, true);
        return list;
    }
    
    void findSpiralUtil(ArrayList<Integer> list, Stack<Node> s1, boolean leftToRight)
    {
        if(s1.isEmpty())
        {
            return;
        }
        Stack<Node> newStack = new Stack<>();
        while(!s1.isEmpty())
        {
            Node currentNode = s1.pop();
            list.add(currentNode.data);
            if(leftToRight)
            {
                if(currentNode.right != null)
                {
                    newStack.push(currentNode.right);
                }
                if(currentNode.left != null)
                {
                    newStack.push(currentNode.left);
                }
            }
            else
            {
                if(currentNode.left != null)
                {
                    newStack.push(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    newStack.push(currentNode.right);
                }
            }
        }
        findSpiralUtil(list, newStack, !leftToRight);
    }
}
