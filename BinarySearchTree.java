
/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class BinarySearchTree
{
    private class Node {
        private int value;
        private Node lChild;
        private Node rChild;
        
        public Node (int value) {
            this.value = value;
        }
    }
    
    private Node root;
    
    private boolean hasLeft(Node node) {
        return node.lChild != null;
    }
    
    private boolean hasRight(Node node) {
        return node.rChild!= null;
    }
    
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (current.value == value)
                break;
            if (value < current.value) {
                if (hasLeft(current))
                    current = current.lChild;
                else {
                    current.lChild = node;
                    break;
                }
            }
            else {
                if (hasRight(current))
                    current = current.rChild;
                else {
                    current.rChild = node;
                    break;
                }
            }
        }
    }
    
    public boolean find(int value) {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        while (true) {
            if (current.value == value)
                return true;
            if (value < current.value) {
                if (hasLeft(current))
                    current = current.lChild;
                else
                    return false;
            }
            else {
                if (hasRight(current))
                    current = current.rChild;
                else
                    return false;
            }
        }
    }
    
    
    public void breadthFirst() {
        if (root == null)
            throw new IllegalStateException();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Node> primaryQueue = new ArrayDeque<>();
        ArrayDeque<Node> secondaryQueue = new ArrayDeque<>();
        
        primaryQueue.add(root);
        while (!primaryQueue.isEmpty()) {
            for (var node : primaryQueue) {
                if (hasLeft(node))
                    secondaryQueue.add(node.lChild);
                if (hasRight(node))
                    secondaryQueue.add(node.rChild);
            }
            while (!primaryQueue.isEmpty())
                result.add(primaryQueue.remove().value);
            while (!secondaryQueue.isEmpty())
                primaryQueue.add(secondaryQueue.remove());
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
    
    public void depthFirstPre() {
        if (root == null)
            throw new IllegalStateException();
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> primaryStack = new Stack<>();
        boolean isRev = false;

        var current = root;
        while (true) {
            if (!primaryStack.contains(current)) {
                primaryStack.push(current);
                result.add(current.value);
            }
            if ((hasLeft(current) && !result.contains(current.lChild.value)) 
                && !isRev) {
                current = current.lChild;
            }
            else {
                if (hasRight(current) &&
                    !result.contains(current.rChild.value)) {
                    current = current.rChild;
                    isRev = false;
                }
                else {
                    primaryStack.pop();
                    if (primaryStack.isEmpty())
                        break;
                    current = primaryStack.peek();
                    isRev = true;
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
    
    public void depthFirstIn() {
        if (root == null)
            throw new IllegalStateException();
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> primaryStack = new Stack<>();
        boolean isRev = false;
        
        var current = root;
        while (true) {
            if (!primaryStack.contains(current)) {
                primaryStack.push(current);
            }
            if (hasLeft(current) && !isRev) {
                current = current.lChild;
            }
            else {
                if (!result.contains(current.value))
                    result.add(current.value);
                if (hasRight(current) &&
                    !result.contains(current.rChild.value)) {
                    current = current.rChild;
                    isRev = false;
                }
                else {
                    primaryStack.pop();
                    if (primaryStack.isEmpty())
                        break;
                    current = primaryStack.peek();
                    isRev = true;
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
    
    public void depthFirstPost() {
        if (root == null)
            throw new IllegalStateException();
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> primaryStack = new Stack<>();
        boolean isRev = false;
        
        var current = root;
        while (true) {
            if (!primaryStack.contains(current))
                primaryStack.push(current);
            if (hasLeft(current) && !isRev) {
                current = current.lChild;
            }
            else {
                if (hasRight(current) &&
                    !result.contains(current.rChild.value)) {
                    current = current.rChild;
                    isRev = false;
                }
                else {
                    result.add(current.value);
                    primaryStack.pop();
                    if (primaryStack.isEmpty())
                        break;
                    current = primaryStack.peek();
                    isRev = true;
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
    
    
    public void depthFirstPreRec() {
        pre(root);
    }
    
    public void depthFirstInRec() {
        in(root);
    }
    
    public void depthFirstPostRec() {
        post(root);
    }
    
    private void pre(Node node) {
        if (node == null)
            return;
        System.out.print(node.value+" ");
        pre(node.lChild);
        pre(node.rChild);
    }
    
    private void in(Node node) {
        if (node == null)
            return;
        in(node.lChild);
        System.out.print(node.value+" ");
        in(node.rChild);
    }
    
    private void post(Node node) {
        if (node == null)
            return;
        post(node.lChild);
        post(node.rChild);
        System.out.print(node.value+" ");
    }
    
    public void getMin() {
        System.out.println(left(root).value);
    }
    
    private Node left(Node node) {
        if (node.lChild == null)
            return node;
        return left(node.lChild);
    }
    
    public int getDepth(int node) {
        var current = root;
        int depth = 0;
        if (find(node)) {
            while (true) {
                if (node == current.value)
                    break;
                if (node < current.value)
                    current = current.lChild;
                else
                    current = current.rChild;
                depth++;
            }
            return depth;
        }
        return -1;
    }
    
    public void getHeight() {
        System.out.println(height(root));
    }
    
    private int height(Node node) {
        if (node == null)
            return -1;
        if (node.lChild == null && node.rChild == null)
            return 0;
        return 1+Math.max(height(node.lChild),height(node.rChild));
    }
    
    public void areEqual(BinarySearchTree other) {
        System.out.println(isEqual(root,other.root));
    }
    
    private boolean isEqual(Node thisRoot, Node otherRoot) {
        if (thisRoot == null && otherRoot == null)
            return true;
        if (thisRoot != null && otherRoot != null)
            return thisRoot.value == otherRoot.value &&
                isEqual(thisRoot.lChild, otherRoot.lChild) &&
                isEqual(thisRoot.rChild, otherRoot.rChild);
        return false;
    }
    
    public void validateBST() {
        // root.lChild.rChild.value = 21;
        System.out.println(isBST(root,-100,100));
    }
    
    private boolean isBST(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.value < min || node.value > max)
            return false;
        return isBST(node.lChild, min, node.value - 1) &&
            isBST(node.rChild, node.value + 1, max);
    }
    
    public void nodesAtKthDistance(int k) {
        var result = new ArrayList<Node>();
        result = getNodesAtKthDistance(root, k, result);
        for (var node : result)
            System.out.print(node.value+" ");
        System.out.println();
    }
    
    private ArrayList<Node> getNodesAtKthDistance(Node node, int k,
        ArrayList<Node> result) {
        if (node == null)
            return null;
        if (k == 0)
            result.add(node);
        getNodesAtKthDistance(node.lChild, k-1, result);
        getNodesAtKthDistance(node.rChild, k-1, result);
        return result;
    }
    
    
    public void breadthFirstRec() {
        for (var node : getBreadthFirstRec())
            System.out.print(node.value+" ");
        System.out.println();
    }
    
    private ArrayList<Node> getBreadthFirstRec() {
        var result = new ArrayList<Node>();
        for (int i = 0; i <= height(root); i++)
            result = getNodesAtKthDistance(root, i, result);
        return result;
    }
    
    public int getSize() {
        return getBreadthFirstRec().size();
    }
    
    public int countLeaves() {
        var count = 0;
        for (var node : getBreadthFirstRec())
            if (height(node) == 0)
                count++;
        return count;
    }
    
    public void getMax() {
        System.out.println(max(root).value);
    }
    
    private Node max(Node node) {
        if (node.rChild == null)
            return node;
        return max(node.rChild);
    }
    
    public void contains(int value) {
        System.out.println(contains(root, value));
    }
    
    private boolean contains(Node node, int value) {
        if (node == null)
            return false;
        if (node.value == value)
            return true;
        return contains(node.lChild, value) || contains(node.rChild, value);
    }
    
    public void areSiblings(int firstValue, int secondValue) {
        System.out.println(areSiblings(root, firstValue, secondValue ));
    }
    
    private boolean areSiblings(Node node, int v1, int v2) {
        if (node == null)
            return false;
        if (hasLeft(node) && hasRight(node))
            if ( (node.lChild.value == v1 && node.rChild.value == v2)
                || (node.lChild.value == v2 && node.rChild.value == v1) )
                    return true;
        return areSiblings(node.lChild, v1, v2) 
            || areSiblings(node.rChild, v1, v2);
    }
    
    public void getAncestors(int value) {
        var result = getAncestors(root, value, new ArrayList<Integer>());
        if (result == null)
            return;
        for (var node : result)
            System.out.println(node);
    }
    
    private ArrayList<Integer> getAncestors(Node node,
        int value, ArrayList<Integer> result) {
            if (node == null)
                return null;
            if (node.value != value)
                result.add(node.value);
            if (value < node.value)
                result = getAncestors(node.lChild, value, result);
            if (value > node.value)
                result = getAncestors(node.rChild, value, result);
            return result;
        }
}