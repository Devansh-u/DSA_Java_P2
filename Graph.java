import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayDeque;
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graph
{
    private class Node{
        private String label;
        
        public Node(String label) {
            this.label = label;
        }
        
        @Override
        public String toString() {
            return label;
        }
    }
    
    private HashMap<String, Node> nodes;
    private HashMap<Node, ArrayList<Node>> adjacencyList;
    
    public Graph(){
        nodes = new HashMap<String, Node>();
        adjacencyList = new HashMap<Node, ArrayList<Node>>();
    }
    
    public void addNode(String label) {
        nodes.put(label, new Node(label));
        adjacencyList.put(nodes.get(label), new ArrayList<Node>());
    }
    
    public void removeNode(String label) {
        for (var node : nodes.values())
            if (adjacencyList.get(node).contains(nodes.get(label))) {
                adjacencyList.get(node).remove(nodes.get(label));
            }
        adjacencyList.remove(nodes.get(label));
        nodes.remove(label);
    }
    
    public void addEdge(String from, String to){
        if (nodes.containsKey(from) && nodes.containsKey(to)){
            adjacencyList.get(nodes.get(from)).add(nodes.get(to));
            adjacencyList.put(nodes.get(from),
                adjacencyList.get(nodes.get(from)));
        }
    }
    
    public void removeEdge(String from, String to){
        if (nodes.containsKey(from) && nodes.containsKey(to)) {
            adjacencyList.get(nodes.get(from)).remove(nodes.get(to));
            adjacencyList.put(nodes.get(from),
                adjacencyList.get(nodes.get(from)));
        }
    }
    
    public void depthFirstTraversal(String start) {
        depthFirst(nodes.get(start), new HashSet<Node>());
    }
    
    private HashSet<Node> depthFirst(Node node, HashSet<Node> result) {
        System.out.print(node+" ");
        result.add(node);
        if (adjacencyList.get(node).isEmpty())
            return result;
        for (var neighbor : adjacencyList.get(node))
            if (!result.contains(neighbor))
                result = depthFirst(neighbor, result);
        return result;
    }
    
    
    
    public void depthFirstIterative(String start) {
        var node = nodes.get(start);
        boolean isRev = false;
        HashSet<Node> result = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (!result.contains(node) && !isRev) {
                System.out.print(node+" ");
                result.add(node);
                stack.push(node);
            }
            if (!adjacencyList.get(node).isEmpty() && !isRev) {
                for (var neighbor : adjacencyList.get(node))
                    stack.push(neighbor);
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (result.contains(node))
                    isRev = true;
                else
                    isRev = false;
            }
            else
                break;
        }
    }
    
    public void breadthFirstIterative(String start) {
        var node = nodes.get(start);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashSet<Node> result = new HashSet<>();
        queue.add(node);
        while (true) {
            node = queue.removeFirst();
            if (!result.contains(node)) {
                System.out.print(node+" ");
                result.add(node);
                if (!adjacencyList.get(node).isEmpty()) {
                    for (var neighbor : adjacencyList.get(node))
                        queue.add(neighbor);
                }
            }
            if (queue.isEmpty())
                break;
        }
    }
    
    public void topologicalSort(String start) {
        var result = topologicalSort(nodes.get(start), new Stack<Node>());
        if (!result.contains(nodes.get(start)))
            result.push(nodes.get(start));
        while (!result.isEmpty())
            System.out.print(result.pop()+" ");
        System.out.println();
    }
    
    private Stack<Node> topologicalSort(Node node, Stack<Node> stack) {
        if (!stack.contains(node)) {
            if (!adjacencyList.get(node).isEmpty()) {
                for (var neighbor : adjacencyList.get(node)) {
                    stack = topologicalSort(neighbor, stack);
                    if (!stack.contains(neighbor))
                        stack.push(neighbor);
                }
            }
            else {
                stack.push(node);
                return stack;
            }
        }
        return stack;
    }
    
    public void hasCycle(String start) {
        System.out.println(hasCycle(nodes.get(start), new ArrayList<Node>()));
    }
    
    private boolean hasCycle(Node node, ArrayList<Node> list) {
        if (list.contains(node))
            return true;
        list.add(node);
        if (!adjacencyList.get(node).isEmpty())
            for (var neighbor : adjacencyList.get(node))
                return hasCycle(neighbor, list);
        return false;
    }
    
    public void print() {
        for (var node : nodes.values()) {
            System.out.println(node+" is connected with "+
                Arrays.toString(adjacencyList.get(node).toArray()));
        }
    }
}