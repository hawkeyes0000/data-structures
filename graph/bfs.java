/*

    Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
    Note: One can move from node u to node v only if there's an edge from u to v and find the BFS 
    traversal of the graph starting from the 0th vertex, from left to right according to the graph. 
    Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.

*/

// ITERATIVE APPROACH
class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty())
        {
            int front = queue.poll();
            bfs.add(front);
            for(int i : adj.get(front))
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    queue.add(i);
                }                
            }
        }       
        return bfs;
    }
}

// RECURSIVE APPROACH
class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> bfs = new ArrayList<>();
        bfsRecursive(bfs, queue, visited, adj);
        return bfs;
    }
    
    static void bfsRecursive(ArrayList<Integer> bfs, Queue<Integer> queue, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        if(queue.isEmpty())
        {
            return;
        }
        int curr = queue.poll();
        visited[curr] = true;
        bfs.add(curr);
        for(int i : adj.get(curr))
        {
            if(!visited[i])
            {
                visited[i] = true;
                queue.add(i);
            }
        }
        bfsRecursive(bfs, queue, visited, adj);
    }
}
