/*

    Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. (leftmost nodes in each level)

    Left view of following tree is 1 2 4 8.

              1
           /     \
         2        3
       /     \    /    \
      4     5   6    7
       \
         8   

    Example 1:
    Input:
       1
     /  \
    3    2
    Output: 1 3
    
*/

// Using Queues
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty())
        {
            int qSize = q1.size();
            Node temp = q1.peek();
            list.add(temp.data);
            while(qSize-- > 0)
            {
                temp = q1.remove();
                if(temp.left != null)
                {
                    q1.add(temp.left);
                }
                if(temp.right != null)
                {
                    q1.add(temp.right);
                }
            }
        }
        return list;
    }
}

// recursive approach
class Tree
{
    static int maxLevel = 0;
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int level = 1;
        leftViewCount(root, level, list);
        return list;
    }
    void leftViewCount(Node root, int level, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        if(level > maxLevel)
        {
            list.add(root.data);
            maxLevel = level;
        }
        leftViewCount(root.left, level + 1, list);
        leftViewCount(root.right, level + 1, list);
    }
}
