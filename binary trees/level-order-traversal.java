/*
    Given a binary tree, find its level order traversal.
    Level order traversal of a tree is breadth-first traversal for the tree.


    Example 1:
    Input:
        1
      /   \ 
     3     2
    Output:1 3 2

    Example 2:
    Input:
            10
         /      \
        20       30
      /   \
     40   60
    Output:10 20 30 40 60 N N

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)
    
*/

class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> finalList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        
        while(queue.peek() != null)
        {
            Node currentNode = queue.poll();
            finalList.add(currentNode.data);
            if(currentNode.left != null)
            {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                queue.add(currentNode.right);
            }
        }  
        return finalList;
    }
}
