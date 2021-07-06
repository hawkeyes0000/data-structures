/*

    Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
    Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.


    Example 1:

    Input:
    grid = {{0,1},{1,0},{1,1},{1,0}}
    Output:
    1
    Explanation:
    The grid is-
    0 1
    1 0
    1 1
    1 0
    All lands are connected.

    Example 2:

    Input:
    grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
    Output:
    2
    Expanation:
    The grid is-
    0 1 1 1 0 0 0
    0 0 1 1 0 1 0 
    There are two islands one is colored in blue 
    and other in orange.

    Expected Time Compelxity: O(n*m)
    Expected Space Compelxity: O(n*m)

*/

/*
    The task is to find the number of "connected components" of an undirected graph.
    When '1' (island) is encountered, check if its index is valid. if so, change its value to some random value other than 0,1 (Say 2), 
    and recursively perform the island+index check in all 8 directions. finally, when coming out of recursion, increment the counter.
    the advantage of changing island value from 1 to 2 is that the same connected component is not visited multiple times
*/

class Solution
{
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, ROWS, COLS, i , j);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void dfs(char[][] grid, int ROWS, int COLS, int i, int j)
    {
        if(i >= 0 && i < ROWS && j >=0 && j < COLS && grid[i][j] == '1')
        {
            grid[i][j] = '2';
            dfs(grid, ROWS, COLS, i-1, j);      // north
            dfs(grid, ROWS, COLS, i-1, j+1);    // north-east
            dfs(grid, ROWS, COLS, i, j+1);      // east
            dfs(grid, ROWS, COLS, i+1, j+1);    // south-east
            dfs(grid, ROWS, COLS, i+1, j);      // south
            dfs(grid, ROWS, COLS, i+1, j-1);    // south-west
            dfs(grid, ROWS, COLS, i, j-1);      // west
            dfs(grid, ROWS, COLS, i-1, j-1);    // north-west
        }
    }
}
