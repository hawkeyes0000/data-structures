/*
    
    Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
    Note: The Graph doesn't contain any negative weight cycle.
    
*/

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        boolean[] isVisited = new boolean[V];
        for(int k = 0; k < V - 1; k++)
        {
            int min = getMin(dist, isVisited, V);
            isVisited[min] = true;
            for(int i = 0; i < adj.get(min).size(); i++)
            {
                int v = adj.get(min).get(i).get(0);
                int vWeight = adj.get(min).get(i).get(1);
                if(!isVisited[v] && dist[min] + vWeight < dist[v])
                {
                    dist[v] = dist[min] + vWeight;
                }
            }
        }
        
        // traverse to get a sense of the fucking 3D arraylist
        // for(int i = 0; i < adj.size(); i++)
        // {
        //     for(int j = 0; j < adj.get(i).size(); j++)
        //     {
        //         System.out.print(i + "    " + adj.get(i).get(j).get(0) + "    " + adj.get(i).get(j).get(0) + "\t\t\t\t");
        //     }
        //     System.out.println();
        // }
        
        return dist;
    }
    
    static int getMin(int[] dist, boolean[] isVisited, int V)
    {
        int minIndex = -1;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < V; i++)
        {
            if(!isVisited[i] && dist[i] != -1 && dist[i] < minVal)
            {
                minVal = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

