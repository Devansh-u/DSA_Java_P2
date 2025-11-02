
/**
 * Write a description of class AVLTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class AVLTree
{
    private class Node {
        private int value;
        private int height;
        private Node lChild;
        private Node rChild;
        
        public Node(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value+"";
        }
    }
    
    private Node root;
    
    public void insert(int value) {
        root = insert(root, new Node(value));
    }
    
    private Node insert(Node parent, Node node) {
        if (parent == null)
            return node;
        if (node.value < parent.value)
                parent.lChild = insert(parent.lChild, node);
        if (node.value > parent.value)
                parent.rChild = insert(parent.rChild, node);
        
        resetHeight(parent);
        return balance(parent);
    }

    private int getHeight(Node node) {
        return (node == null) ? -1 : node.height;
    }
    
    private int balanceFactor(Node node) {
        return (node == null) ? 0 : 
            (getHeight(node.lChild) - getHeight(node.rChild));
    }
    
    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }
    
    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }
    
    private Node balance(Node parent) {
        if (isLeftHeavy(parent))
            parent = selectRotation(parent,true);
        if (isRightHeavy(parent))
            parent = selectRotation(parent,false);
        return parent;
    }
    
    private Node selectRotation(Node node, boolean isLeftHeavy) {
        if (isLeftHeavy) {
            if (balanceFactor(node.lChild) < 0) {
                System.out.println("Left Shifting on "+node.lChild);
                node.lChild = leftShift(node.lChild);
            }
            System.out.println("Right Shifting on "+node);
            node = rightShift(node);
        }
        else {
            if (balanceFactor(node.rChild) > 0) {
                System.out.println("Right Shifting on "+node.rChild);
                node.rChild = rightShift(node.rChild);
            }
            System.out.println("Left Shifting on "+node);
            node = leftShift(node);
        }
        return node;
    }
    
    private void resetHeight(Node node) {
        node.height = Math.max(getHeight(node.lChild), getHeight(node.rChild))
            + 1;
    }
    
    private Node leftShift(Node node) {
        Node temp = node.rChild;
        node.rChild = temp.lChild;
        temp.lChild = node;
        
        resetHeight(node);
        resetHeight(temp);
        
        return temp;
    }
    
    private Node rightShift(Node node) {
        Node temp = node.lChild;
        node.lChild = temp.rChild;
        temp.rChild = node;
        
        resetHeight(node);
        resetHeight(temp);
        
        return temp;
    }
    
    public void isPerfect() {
        System.out.println(isPerfect(root));
    }
    
    private boolean hasLeft(Node node){
        return node.lChild != null;
    }
    
    private boolean hasRight(Node node){
        return node.rChild != null;
    }
    
    private boolean isPerfect(Node parent) {
        if (parent == null || getHeight(parent) <= 1)
            return true;
        if ( getHeight(parent) > 1 ) {
            if (hasLeft(parent) && hasRight(parent))
                return true;
            return false;
        }
        return isPerfect(parent.lChild) && isPerfect(parent.rChild);
    }
}