/*

    Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

*/

// simple DFS solution
// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

class Solution
{
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] isVisited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!isVisited[i])
            {
                if(dfs(i, isVisited, -1, adj))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean dfs(int current, boolean[] isVisited, int parent, ArrayList<ArrayList<Integer>> adj)
    {
        isVisited[current] = true;
        for(int i : adj.get(current))
        {
            if(isVisited[i])
            {
                if(i != parent)
                {
                    return true;    
                }
            }
            else if(dfs(i, isVisited, current, adj))
            {
                return true;
            }
        }
        return false;
    }
}
