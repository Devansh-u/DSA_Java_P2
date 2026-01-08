import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class UndirectedGraph{
    
    private class Node {
        private String label;
        private ArrayList<Edge> edges;
        
        public Node(String label) {
            this.label = label;
            edges = new ArrayList<Edge>();
        }
        
        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }
    }
    
    private class WrapperNode {
        private Node node;
        private int priority;
        
        public WrapperNode(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
        
        @Override
        public String toString() {
            return node.label+" at "+priority;
        }
    }
    
    private class Edge {
        private Node from;
        private Node to;
        private int weight;
        
        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public String toString() {
            return from.label+" -- "+weight+" -> "+to.label;
        }
    }
    
    private HashMap<String, Node> vertices = new HashMap<>();
    private int size;
    
    public void addNode(String label) {
        Node node = new Node(label);
        vertices.putIfAbsent(label, node);
        size++;
    }
    
    public void addEdge(String from, String to, int weight) {
        Node fromNode = vertices.get(from);
        Node toNode = vertices.get(to);
        
        if (fromNode != null && toNode != null) {
            fromNode.addEdge(toNode, weight);
            toNode.addEdge(fromNode, weight);
        }
    }
    
    public void shortestPath(String from, String to) {
        Node fromNode = vertices.get(from);
        Node toNode = vertices.get(to);
        
        if (fromNode != null && toNode != null)
            getShortestPath(fromNode, toNode);
    }
    
    public boolean hasCycle() {
        for (Node node : vertices.values())
            if (checkForCycle(node, null, new ArrayList<Node>())) {
                System.out.println("Yes");
                return true;
            }
        return false;
    }
    
    public void primsAlgorithm() {
        primsAlgo();
    }
    
    private void primsAlgo() {
        UndirectedGraph tree = new UndirectedGraph();        
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Node startingNode = vertices.values().iterator().next();
        queue.addAll(startingNode.edges);
        tree.addNode(startingNode.label);
        
        while (tree.size < size) {
            Edge minEdge = queue.remove();
            
            if (tree.vertices.containsKey(minEdge.to.label))
                continue;
            
            tree.addNode(minEdge.to.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);
            
            for (Edge edge : minEdge.to.edges) {
                if (!tree.vertices.containsKey(edge.to.label))
                    queue.add(edge);
            }
        }
        
        tree.print();
    }
    
    private boolean checkForCycle(Node node, Node parentNode, ArrayList<Node> visited) {
        visited.add(node);
        
        for (Edge edge : node.edges) {
            if (edge.to == parentNode)
                continue;
            if (visited.contains(edge.to))
                return true;
            
            if (checkForCycle(edge.to, node, visited))
                return true;
        }
        return false;          
    }
    
    private void getShortestPath(Node fromNode, Node toNode) {
        HashMap<Node, Integer> distance = new HashMap<>();
        HashMap<Node, Node> previous = new HashMap<>();
        ArrayList<Node> visited = new ArrayList<>();        
        
        distance.put(fromNode, 0);
        for (Node node : vertices.values())
            distance.putIfAbsent(node, Integer.MAX_VALUE);
        
        PriorityQueue<WrapperNode> queue = new PriorityQueue<>(Comparator.comparingInt(wn -> wn.priority));
        
        queue.add(new WrapperNode(fromNode, 0));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove().node;
            visited.add(currentNode);
            
            for (Edge edge : currentNode.edges) {
                if (visited.contains(edge.to))
                    continue;
                
                int newDistance = distance.get(currentNode) + edge.weight;
                
                if (distance.get(edge.to) > newDistance) {
                    distance.put(edge.to, newDistance);
                    previous.put(edge.to, currentNode);
                    queue.add(new WrapperNode(edge.to, newDistance));
                }
            }
        }
        
        System.out.println(distance.get(toNode));
        
        Node currentNode = toNode;
        while (currentNode != fromNode) {
            System.out.print(currentNode.label+" <- ");
            currentNode = previous.get(currentNode);
        }
        System.out.println(currentNode.label);
    }
    
    public void print() {
        for (Node node : vertices.values()) {
            System.out.println(node.label);
            for (Edge edge : node.edges)
                System.out.println(edge);
        }
    }
}