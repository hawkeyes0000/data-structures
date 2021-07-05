/*

    Given a reference of a node in a connected undirected graph.

    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

    class Node {
        public int val;
        public List<Node> neighbors;
    }



    Test case format:

    For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node 
    with val == 2, and so on. The graph is represented in the test case using an adjacency list.

    An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node 
    in the graph.

    The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

    https://leetcode.com/problems/clone-graph/
    
*/

/*
    Maintain the following variables:-
    boolean isVisited[101] -> keeps track of visited nodes. maintained using the value of node (1,2,...100)
    Node[] listOfNodes[101] -> contains all the nodes of CLONED graph. maintained using the value of node (1,2,...100)
    For each source node, create a target node with the same value, and mark it visited.
    Traverse through each of source node neighbors, if the neighbor is already visited, add the neighbor to target.neighbors list, else
    create a new temp node, and recursively do the visiting process with that new node.
    
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) 
    {
        if(node == null)
        {
            return null;
        }
        Node[] listOfNodes = new Node[101];    // will store node ref at given val index   
        Node target = new Node();
        boolean[] isVisited = new boolean[101];
        target = cloneGraphUtil(node, target, listOfNodes, isVisited);
        
        return target;
    }
    static Node cloneGraphUtil(Node node, Node target, Node[] listOfNodes, boolean[] isVisited)
    {
        target = new Node(node.val);
        listOfNodes[node.val] = target;
        isVisited[target.val] = true;
        for(Node n : node.neighbors)
        {
            // already visited, so just add as neighbor
            if(isVisited[n.val])
            {
                target.neighbors.add(listOfNodes[n.val]);
            }
            else
            {
                Node temp = new Node();
                temp = cloneGraphUtil(n, temp, listOfNodes, isVisited);
                target.neighbors.add(listOfNodes[n.val]);
            }
        }
        return target;
    }
}
