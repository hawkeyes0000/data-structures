/*

    Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

*/

// USING DFG - https://www.youtube.com/watch?v=rKQaZuoUR4M
class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        HashSet<Integer> white = new HashSet<>();   // not visited
        HashSet<Integer> gray = new HashSet<>();    // in transit
        HashSet<Integer> black = new HashSet<>();   // visited
        
        // insert V elements inside white
        for(int i = 0; i < V; i++)
        {
            white.add(i);
        }
        
        while(white.size() > 0)
        {
            int currentVertex = white.iterator().next();
            if(isCyclicUtil(currentVertex, adj, white, gray, black))
            {
                return true;
            }
        }
        return false;
    }
    
    static boolean isCyclicUtil(int vertex, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> white, HashSet<Integer> gray, HashSet<Integer> black)
    {
        // move to gray
        moveElement(white, gray, vertex);
        for(int i : adj.get(vertex))
        {
            // already explored
            if(black.contains(i))
            {
                continue;
            }
            // cycle detected
            if(gray.contains(i))
            {
                return true;
            }
            if(isCyclicUtil(i, adj, white, gray, black))
            {
                return true;
            }
        }
        moveElement(gray, black, vertex);
        return false;
    }
    
    static void moveElement(HashSet<Integer> source, HashSet<Integer> target, int element)
    {
        source.remove(element);
        target.add(element);
    }
}


// USING BFS
