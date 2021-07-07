/*

    Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
    Note: edges[i] is defined as u, v and weight.


    Example 1:

    Input: n = 3, edges = {{0,1,-1},{1,2,-2},
    {2,0,-3}}
    Output: 1
    Explanation: The graph contains negative weight
    cycle as 0->1->2->0 with weight -1,-2,-3,-1.

    Example 2:

    Input: n = 3, edges = {{0,1,-1},{1,2,-2},
    {2,0,3}}
    Output: 0
    Explanation: The graph does not contain any
    negative weight cycle.
    
    Expected Time Complexity: O(n*m)
    Expected Space Compelxity: O(n)

*/

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        for(int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        
        for(int i = 0; i < n-1; i++)
        {
            for(int j = 0; j < edges.length; j++)
            {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        for(int j = 0; j < edges.length; j++)
            {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                {
                    return 1;
                }
            }
        
        // for(int i = 0; i < edges.length; i++)
        // {
        //     for(int j = 0; j < edges[i].length; j++)
        //     {
        //         System.out.print(edges[i][j] + "    ");
        //     }
        //     System.out.println("\n\n");
        // }
        return 0;
    }
}
