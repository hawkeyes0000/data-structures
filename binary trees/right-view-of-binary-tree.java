/*

    Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

    Right view of following tree is 1 3 7 8.

              1
           /     \
         2        3
       /   \      /    \
      4     5   6    7
        \
         8

    Example 1:
    Input:
           1
        /    \
       3      2
    Output: 1 2

    Example 2:
    Input:
         10
        /   \
      20     30
     /   \
    40  60 
    Output: 10 30 60

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(Height of the Tree).

*/

// Queue approach
class Solution
{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null)
        {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            Node rightMost = queue.peek();
            list.add(rightMost.data);
            while(levelSize-- > 0)
            {
                Node currentNode = queue.remove();
                if(currentNode.right != null)
                {
                    queue.add(currentNode.right);
                }
                if(currentNode.left != null)
                {
                    queue.add(currentNode.left);
                }
            }
        }

        return list;
    }
}
