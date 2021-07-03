/*

    Given a connected undirected graph. Perform a Depth First Traversal of the graph.
    Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph..

*/

class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        recursiveDFS(adj, list, isVisited, 0);
        return list;
    }
    static void recursiveDFS(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, boolean[] isVisited, int node)
    {
        list.add(node);
        isVisited[node] = true;
        ArrayList<Integer> curr = adj.get(node);
        for(int i : curr)
        {
            if(!isVisited[i])
            {
                recursiveDFS(adj, list, isVisited, i);
            }
        }
    }
}
