/*

    Given two binary trees, the task is to find if both of them are identical or not. 

    Example 1:

    Input:
         1          1
       /   \      /   \
      2     3    2     3
    Output: Yes
    Explanation: There are two trees both
    having 3 nodes and 2 edges, both trees
    are identical having the root as 1,
    left child of 1 is 2 and right child
    of 1 is 3.

    Example 2:

    Input:
        1       1
      /  \     /  \
     2    3   3    2
    Output: No
    Explanation: There are two trees both
    having 3 nodes and 2 edges, but both
    trees are not identical.

*/

class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    return isIdenticalUtil(root1, root2);
	}
	
	boolean isIdenticalUtil(Node root1, Node root2)
	{
	    // both tree are empty
	    if(root1 == null && root2 == null)
	    {
	        return true;
	    }
	    // one of them is empty
	    if((root1 == null && root2 != null) || (root1 != null && root2 == null))
	    {
	        return false;
	    }
	    
	    if(root1.data != root2.data)
	    {
	        return false;
	    }

	    return isIdenticalUtil(root1.left, root2.left) && isIdenticalUtil(root1.right, root2.right);
	}
	
}
