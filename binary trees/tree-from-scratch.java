/*

    Implement Binary Tree with the following operations - Insert, Delete, Traversal (level order)
    
*/

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree
{
    TreeNode root;
    BinaryTree(int data)
    {
        root = new TreeNode(data);
    }
    
    void insertNode(int data)
    {
        TreeNode newNode = new TreeNode(data);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.remove();
            if(temp.left == null)
            {
                temp.left = newNode;
                break;
            }
            else
            {
                q.add(temp.left);
            }
            if(temp.right == null)
            {
                temp.right = newNode;
                break;
            }
            else
            {
                q.add(temp.right);
            }
        }
    }
    
    void deleteNode(int data)
    {
        TreeNode keyNode = null;
        TreeNode temp = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            temp = q.remove();
            if(temp.data == data)
            {
                keyNode = temp;
            }
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
        if(keyNode == null)
        {
            System.out.println("No such node found!");
        }
        else
        {
            deleteDeepest(keyNode, temp);   
        }
    }
    
    void deleteDeepest(TreeNode keyNode, TreeNode rightMost)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.remove();
            if(temp.left != null)
            {
                if(temp.left == rightMost)
                {
                    keyNode.data = temp.left.data;
                    temp.left = null;    
                    break;
                }
                else
                {
                    q.add(temp.left);
                }
            }
            if(temp.right != null)
            {
                if(temp.right == rightMost)
                {
                    keyNode.data = temp.right.data;
                    temp.right = null;    
                    break;
                }
                else
                {
                    q.add(temp.right);
                }
            }
        }
    }
    
    void levelOrderTraverse()
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.remove();
            System.out.println(temp.data);
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree(100);
        bt.insertNode(105);
        bt.insertNode(5);
        bt.levelOrderTraverse();
        bt.deleteNode(105);
        System.out.println("After deletion:");
        bt.levelOrderTraverse();
        bt.deleteNode(5);
        System.out.println("After deletion:");
        bt.levelOrderTraverse();
        bt.deleteNode(100);
        System.out.println("After deletion:");
        bt.levelOrderTraverse();
        bt.levelOrderTraverse();
        bt.insertNode(5885);
        bt.levelOrderTraverse();
        bt.deleteNode(100);
        System.out.println("After deletion:");
        bt.levelOrderTraverse();
    }
}
