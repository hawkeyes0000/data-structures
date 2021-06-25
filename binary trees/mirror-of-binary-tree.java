/*

    Given a binary tree, the task is to create a new binary tree which is a mirror image of the given binary tree.

    Examples: 
    Input:
            5
           / \
          3   6
         / \
        2   4
    Output:
    Inorder of original tree: 2 3 4 5 6 
    Inorder of mirror tree: 6 5 4 3 2
    Mirror tree will be:
      5
     / \
    6   3
       / \
      4   2

    Input:
            2
           / \
          1   8
         /     \
        12      9
    Output:
    Inorder of original tree: 12 1 2 8 9 
    Inorder of mirror tree: 9 8 2 1 12

*/

public class Main 
{   
    static class TreeNode
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
    
    static void inorder(TreeNode root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        // System.out.println("");
    }
    
    static void mirror(TreeNode root)
    {
        if(root.left != null)
        {
            mirror(root.left);
        }
        if(root.right != null)
        {
            mirror(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(80);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(75);
        root.left.right = new TreeNode(90);
        root.right.left = new TreeNode(150);
        root.right.right = new TreeNode(250);
        System.out.println("*** BEFORE MIRRORING ***");
        inorder(root);
        System.out.println("\n*** AFTER MIRRORING ***");
        mirror(root);
        inorder(root);
    }
}
