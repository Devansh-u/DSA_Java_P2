
/**
 * Write a description of class Graphs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graphs
{
    /*
        We use graphs to represent connected objects such as router on network,
        people on social media platforms
        
        using a graph we can see that how objects are connected and how strong
        their connections are
        
        similar to trees, graphs consists of Nodes and Edges, mathematically
        tree is a kind of graph, graph without any cycles
        
        we don't have root node in graphs, there are nodes/vertices
        and edges/lines
        
        nodes can be connected to any no of nodes, there are no such
        limitations
        
        if two nodes are directly connected we say they are adjacent/neighbors
        nodes
        
        if edges have a direction then it is a directed graph, in directed
        graphs we can have one node connected to other but the opposite may
        not be true
        
        these edges can also have weight, weight are used to represent how
        strong the connection is
        
        
        Graphs can be implemented using different ways
        1. Adjacency Matrix, a 2-D matrix is used to store the data, eg
        
            John Mary Bob Alice
        John   0    1   1   1
        Mary   0    0   1   1
        Bob    0    0   0   0
        Alice  0    0   1   0
        
        here 1 represents the connection while 0 means not connected
        
        Space Complexity for this way is O(n^2)
        Time Complexity for operations:
            
            Insertion() O(V^2) -> as new matrix of one extra row and col will
                be made and all items need to be copied from older matrix
            (When we do complexity analysis of graps we prefer to use 'V'
            vertices and 'E' edges instead of 'n')
            
            Deletion() O(V^2) -> need to copy elements of older matrix to
                newer matrix with removed one row and col
            
            Insertion of Edge() O(1) -> just find index (can be done using
            hash table) and update value
            
            Remove Edge() O(1) -> just find index
            
            Query Edge() (whether two are connected or not) O(1) -> read value
                by index
            
            Finding neighbor/adjacent nodes() O(V) as we have to check for each
            node whether it is connected to it or not
        
        2. Adjacency List, an array of linked list, here objects with
            connections are stored in an array of linked list, where the linked
            list contains the neighbor/connected objects for each node
            
            here only connections are store so it is space efficient
            
            Space Complexity is O(V + E) where E is total no of 
                Edges/connections
            
            Dense Graph is a graph where each node is connected to every other
            node in graph, here total no of edges is E = V*(V-1) so space
            complexity becomes O(V^2)
            
            Insertion of node O(1), as we just add a new element in adjacency
            list
            
            Removing of node O(V + E) as we need to remove element from the
            list and also delete the connections to that node from every other
            node, in worst case O(V^2)
            
            Adding an Edge O(K) where K is no of Edges as first we need to
            check whether the connection pre exist or not and in worst case
            O(V)
            
            Removing an Edge O(K) and in worst case O(V)
            
            Searching for an Edge is also O(K) and in worst case O(V)
            
            Finding neighbor of an object is also O(K) and in worst case O(V)
            as we need to traverse over the linked list of connections for
            that object
            
            for concluding adding,removing,searching of an edge have lower
            time complexity in adjacency matrix while adding node and finding
            neighbor is quick in adjacency list
            
            when dealing with dense graph adjacency matrix performs better
            and space complexity is almost same for both
            
            traversal in graphs also uses the breadth first and depth first
            traversal methods
            
            when using depth first it's possible to have
            unvisited nodes as the node which we start from may not have a
            connection with one or more of nodes in graph
            
            using breadth first we first visit the node and then its neighbors
            in a queue method as we dequeue the neighbors of node are enqueued
            
            
            Topological sorting is done to find the right order we need to
            process the nodes of a graph, it have implementations like
            scheduling tasks/jobs or dependencies building for main project
            
            this algo doesn't have unique solution, there can be diffrent order
            for same task and is only possible with 'Directed Acyclic Graph'
    */
}