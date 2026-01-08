public class UndirectedGraphs
{
    /*
        undirected graphs do not have directions, means if A is connected to
        B then B is also connected to A
        
        weighted graphs have some weight/value for edges, it can be anything
        such as distance, condition anything that makes sense
        
        Dijkstra's Shortest path algorithm is one of classic algorithm for 
        finding the shorted distance between two nodes of a graph (weighted
        graph)
        
        with this algorithm we will generate a table of information which 
        contains the shortest distance from one node to every other node 
        including the node itself and also store the previous node from where
        we reached the other node
        
        initially we assume the distance from the node to the node itself is 0
        and distance from node to every other node is some large MAX value
        
        as we navigate in graph as we find the shorted path we will update the
        table
        
        for eg consider the following graph
            3
         A --- B
        |  \   | \1
       4|  2\ 6|  E
        |    \ | /5
        C ---  D
           1
           
        table will look something like this
        
        Node Distance Previous
        A       0 
        B       MAX
        C       MAX
        D       MAX
        E       MAX
        
        in every step we look at the unvisited neighbors of current node
        so for A unvisited neighbors are B,C and D
        
        now we calculate the distance from start node to each of them
        A -> B is 3 , on comparing, we find a value less than MAX so update MAX
        to 3, and add A as previous
        repeating the same for C and D
        
        Node Distance Previous
        A       0 
        B       3       A
        C       4       A
        D       2       A
        E       MAX
        
        we are now done visiting A, so we will now look at neighbors of A and
        pick the one with shortest distance ie D in this case, so next we will
        visit is D
        
        now repeating the steps for D, ie looking for unvisited neighbors of D
        and updating the table as needed, we already visited A so skipping it
        
        we will look to B,C and E and calculate the shortest distance from
        start node to each of them
        
        looking for shortest distance from starting node to each of neighbors
        of current node, ie distance form A to neighbors of D, and we already
        know A -> D is 2, so adding 2 to distance from D to B,C,E gives the
        required distance
        
        distance from A -> B via D is 2 + 6 = 8, on comparing with table 8 is 
        not less than 3 so we will not update the table
        
        for A -> C via D is 2 + 1 = 3, comparing with table and updating
        
        for A -> E via D is 2 + 5 = 7, comparing and updating in table
        
        Node Distance Previous
        A       0 
        B       3       A
        C   (4)X,3   (A)X, D  updated from 4 to 3 and A to D
        D       2       A
        E       7       D
        
        we visited all neighbors of D, so now picking the other closest one 
        and going there
        
        now looking at unvisited neighbors of B, there is E only, finding
        distance A -> E via B is 3 + 1 = 4, comparing and updating table
        
        Node Distance Previous
        A       0 
        B       3       A
        C       3       D
        D       2       A
        E       4       B
        
        done with B, looking at unvisited neighbor of B ie E, all neighbors
        of E are visited so done with it
        
        now C is left and all neighbors of C are visited so done with it also
        
        Node Distance Previous
        A       0 
        B       3       A
        C       3       D
        D       2       A
        E       4       B
        
        here the algorithm stops and through the table we can see all the
        shortest paths from node A to every other node
        
        we can build the path sequence such as, for A -> E, we have A -> B and
        B -> E the shortest distance is 4
        
        
        Prim's algorithm is used to find minimum spanning tree for a given graph
        
        minimum spanning tree refers to the shortest way possible to connect
        all the nodes in the graph, the number of edges are n-1 where n is total
        number of nodes, if edges are less than it then all nodes are not connected
        and if it is more than it then it means it has cycle in it and hence
        is not a tree
        
        dijkstras and prims both are example of greedy algorithm (selecting 
        the best option at each step)
    */
}