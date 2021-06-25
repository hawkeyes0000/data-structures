/*
    
    Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.

    Example 1:
    Input :
            1
          /   \
         3     2

    Output: 3 2 1
    Explanation:
    Traversing level 1 : 3 2
    Traversing level 0 : 1

    Example 2:
    Input :
           10
          /  \
         20   30
        / \ 
       40  60

    Output: 40 60 20 30 10
    Explanation:
    Traversing level 2 : 40 60
    Traversing level 1 : 20 30
    Traversing level 0 : 10

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)
    
*/

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(queue.peek() != null)
        {
            Node currentNode = queue.poll();
            finalList.add(0, currentNode.data);
            if(currentNode.right != null)
            {
                queue.add(currentNode.right);
            }
            if(currentNode.left != null)
            {
                queue.add(currentNode.left);
            }
        }
        return finalList;
    }
}      
