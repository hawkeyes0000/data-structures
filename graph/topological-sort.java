/*

    Given a Directed Graph with V vertices and E edges, Find any Topological Sorting of that Graph.
    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, 
    vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

    For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological sorting for a graph. 
    For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always a vertex 
    with in-degree as 0 (a vertex with no incoming edges).
    
*/

/*
    In short, in topological sort, the nodes should be arranged in increasing order as per their indegree
    There can be multiple TS's for a given graph, because multiple vertices can have the same indegree
    The problem is a variation of DFS
    In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. 
    
    In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively 
    call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. 
    Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack. 
    
*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ts = new int[V];
        boolean[] isVisited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++)
        {
            if(!isVisited[i])
            {
                topoSortUtil(i, isVisited, stack, adj);
            }
        }
        int i = 0;
        while(!stack.isEmpty())
        {
            ts[i] = stack.pop();
            ++i;
        }
        return ts;
    }
    
    static void topoSortUtil(int i, boolean[] isVisited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj)
    {
        isVisited[i] = true;
        Iterator<Integer> it = adj.get(i).iterator();
        while(it.hasNext())
        {
            int j = it.next();
            if(!isVisited[j])
            {
                topoSortUtil(j, isVisited, stack, adj);
            }
        }
        stack.push(i);
    }
}
