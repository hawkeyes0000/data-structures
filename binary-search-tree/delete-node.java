/*

    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:
        Search for a node to remove.
        If the node is found, delete the node.

*/

/*
    Three cases:-
    1. Leaf node is to be deleted - simply remove that node
    2. Node with one child - change the parent node reference to point to the single child of the node that is to be deleted.
    3. Node with two children - find the minimum element in RST, change the data of node-to-be-deleted to the minimum element, and recursively delete the minimum node. (reduce the problem to either 1st or 2nd case)
    
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root == null)
        {
            return root;
        }
        else if(key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            // case 1: leaf node
            if(root.left == null && root.right == null)
            {
                root = null;
            }
            // case 2: one child
            else if(root.left == null)
            {
                TreeNode temp = root.right;
                root.right = null;
                root = temp;
            }
            else if(root.right == null)
            {
                TreeNode temp = root.left;
                root.left = null;
                root = temp;
            }
            // case 3: two children
            else
            {
                // find minimum element in RST
                TreeNode min = findMin(root.right);
                // update root value
                root.val = min.val;
                // delete min
                root.right = deleteNode(root.right, min.val);
            }
        }
            
        return root;
    }
    
    static TreeNode findMin(TreeNode root)
    {
        if(root.left == null)
        {
            return root;
        }
        return findMin(root.left);
    }
}
