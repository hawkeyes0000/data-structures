/*

    Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
    Following are the detailed steps.
    1) Create a Min Heap of size V where V is the number of vertices in the given graph. Every node of min heap contains vertex number and key value of the vertex.
    2) Initialize Min Heap with first vertex as root (the key value assigned to first vertex is 0). The key value assigned to all other vertices is INF (infinite).
    3) While Min Heap is not empty, do following
    …..a) Extract the min value node from Min Heap. Let the extracted vertex be u.
    …..b) For every adjacent vertex v of u, check if v is in Min Heap (not yet included in MST). If v is in Min Heap and its key value is more than weight of u-v, then update the key value of v as weight of u-v.

*/

class Edge
{
    int weight;
    int source;
    Edge(int weight, int source)
    {
        this.weight = weight;
        this.source = source;
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->Integer.compare(a.weight,b.weight)); 
        // for(ArrayList<ArrayList<Integer>> outer : adj)
        // {
        //     for(ArrayList<Integer> inner : outer)
        //     {
        //         for(int i : inner)
        //         {
        //             System.out.print(i + "    ");
        //         }
        //         System.out.println();
        //     }
        // }
        boolean[] isVisited = new boolean[V];
        pq.add(new Edge(0, 0));
        int spanningCost = 0;
        
        while(!pq.isEmpty())
        {
            Edge p = pq.poll();
            if(isVisited[p.source])
            {
                continue;
            }
            isVisited[p.source] = true;     // visit
            spanningCost += p.weight;
            
            // add edges of p into pq
            for(int i = 0; i < adj.get(p.source).size(); i++)
            {
                if(!isVisited[adj.get(p.source).get(i).get(0)])
                {
                    pq.add(new Edge(adj.get(p.source).get(i).get(1), adj.get(p.source).get(i).get(0)));
                }
            }
        }
        
        return spanningCost;
    }
}
