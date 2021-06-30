/*

    There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, 
    if the either of predecessor or successor is not found print -1.

    Input:
    The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting 
    the number of edges of the BST. The next line contains the edges of the BST. The last line contains the key.

    Output:
    Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.

    Constraints:
    1<=T<=100
    1<=n<=100
    1<=data of node<=100
    1<=key<=100

    Example:
    Input:
    2
    6
    50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
    65
    6
    50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
    100

    Output:
    60 70
    80 -1

*/

class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        /*
            Two cases -
            1. Key is found.
                If so, the predecessor will be greatest element in LST
                Successor will be smallest element in RST
            2. Exact key is not found. 
                In that case, if key is less than root, set successor to 
                root data and traverse to LST
                If key is more than root, set predecessor to root data and
                traverse to RST
        */         
        
        /*
            Input: root node, key
            output: predecessor node, successor node

            1. If root is NULL
                  then return
            2. if key is found then
                a. If its left subtree is not null
                    Then predecessor will be the right most 
                    child of left subtree or left child itself.
                b. If its right subtree is not null
                    The successor will be the left most child 
                    of right subtree or right child itself.
                return
            3. If key is smaller then root node
                    set the successor as root
                    search recursively into left subtree
                else
                    set the predecessor as root
                    search recursively into right subtree
        */
        
        /*
            class Res
            {
                Node pre;
                Node succ;
            }
        */
        if(root == null)
        {
            return;
        }
        if(root.data == key)
        {
            if(root.left != null)
            {
                Node temp = root.left;
                while(temp.right != null)
                {
                    temp = temp.right;
                }
                p.pre = temp;
            }
            if(root.right != null)
            {
                Node temp = root.right;
                while(temp.left != null)
                {
                    temp = temp.left;
                }
                s.succ = temp;
            }
        }
        else
        {
            if(key < root.data)
            {
                s.succ = root;
                findPreSuc(root.left, p, s, key);
            }
            else
            {
                p.pre = root;
                findPreSuc(root.right, p, s, key);
            }
        }
    }   
}
