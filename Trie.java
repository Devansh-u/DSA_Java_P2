
/**
 * Write a description of class Trie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Trie
{
    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;
        
        public Node (char value) {
            this.value = value;
            children = new HashMap<>();
        }
        
        public boolean isLeaf() {
            return children.isEmpty();
        }
        
        public void setEndOfWord(boolean isEnd) {
            isEndOfWord = isEnd;
        }
        
        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }
        
        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }
        
        public void remove(char ch) {
            children.remove(ch);
        }
        
        public Node getChild(char ch) {
            return children.get(ch);
        }
        
        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
        
        @Override
        public String toString() {
            return value+"";
        }
    }
    
    private Node root;
    
    public Trie() {
        root = new Node(' ');
    }
    
    public void insert(String input) {
        isInputNull(input);
        input = input.toLowerCase();
        var current = root;
        
        for (char letter : input.toCharArray()) {
            if (!current.hasChild(letter))
                current.addChild(letter);
            current = current.getChild(letter);
        }
        current.setEndOfWord(true);
    }
    
    public boolean contains(String input) {
        isInputNull(input);
        input = input.toLowerCase();
        var current = root;
        
        for (char letter : input.toCharArray()) {
            if (!current.hasChild(letter))
                return false;
            current = current.getChild(letter);
        }
        return current.isEndOfWord;
    }
    
    public void containsRec(String input) {
        if (input == null || input.length() == 0)
            return;
        System.out.println(containsRec(root, input.toLowerCase(), 0));
    }
    
    private boolean containsRec(Node node, String input, int index) {
        if (index == input.length() && node.value == input.charAt(index-1))
            return node.isEndOfWord;
        var letter = input.charAt(index);
        if (node.hasChild(letter))
            return containsRec(node.getChild(letter), input, index + 1);
        return false;
    }
    
    private void isInputNull(String input) {
        if (input == null)
            throw new IllegalArgumentException();
    }
    
    public void preOrder() {
        preOrder(root);
    }
    
    public void postOrder() {
        postOrder(root);
    }
    
    private void preOrder(Node node) {
        System.out.println(node);
        for (var child : node.getChildren())
             preOrder(child);
    }
    
    private void postOrder(Node node) {
        for (var child : node.getChildren())
            postOrder(child);
        if (node != root)
            System.out.println(node);
    }
    
    private ArrayList<Node> postOrderArr(Node node, ArrayList<Node> result) {
        for (var child : node.getChildren())
            postOrderArr(child, result);
        result.add(node);
        return result;
    }
    
    public void delete(String input) {
        if (input == null)
            return;
        delete(root, input.toLowerCase(), 0);
    }
    
    private void delete(Node node, String input, int index) {
        if (index == input.length()) {
            node.setEndOfWord(false);
            return;
        }
        
        var letter = input.charAt(index);
        Node child = node.getChild(letter);
        if (child == null)
            return;
        
        delete(child, input, index + 1);
        
        if (child.isLeaf() && !child.isEndOfWord)
            node.remove(letter);
    }
    
    public void autoComplete(String input){
        if (input == null)
            return;
        System.out.println(Arrays.toString(
            autoComplete(workingNode(root, input, 0),
                input, new ArrayList<String>()).toArray()));
    }
    
    private Node workingNode(Node node, String input, int index) {
        if (index == input.length())
            return node;
        var letter = input.toLowerCase().charAt(index);
        return workingNode(node.getChild(letter), input, index + 1);
    }
    
    private ArrayList<String> autoComplete(Node node,
        String word,
            ArrayList<String> result){
        if (node == null)
            return result;
        if (node.isEndOfWord)
            result.add(word);
        for (var child : node.getChildren())
            autoComplete(child, word+child.value, result);
        return result;
    }
    
    public void getNoOfWords() {
        var words = autoComplete(workingNode(root, "", 0),
                "", new ArrayList<String>()).size();
        System.out.println(words);
    }
    
    public void longestCommonPrefix(String[] input) {
        Trie trie = new Trie();
        for (var word : input)
            trie.insert(word.toLowerCase());
        System.out.println(longestCommonPrefix(trie.root, ""));
    }
    
    private String longestCommonPrefix(Node node, String prefix) {
        if (node == null)
            return null;
        
        if (node.getChildren().length > 1 || node.isEndOfWord)
            return prefix+node.value;
        
        return node.value+longestCommonPrefix(node.getChildren()[0], prefix);
    }
}