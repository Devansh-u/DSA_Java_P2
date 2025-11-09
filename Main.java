public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(14);
        tree.insert(24);
        tree.insert(3);
        tree.insert(8);
        tree.insert(26);

        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("C","A");
        graph.addEdge("D","A");
        graph.print();
        graph.hasCycle("A");
        // graph.breadthFirstIterative("A");
        // System.out.println();
        // graph.breadthFirstIterative("B");
        // System.out.println();
        // graph.breadthFirstIterative("C");
        // System.out.println();
        // graph.breadthFirstIterative("D");
        // System.out.println();
        // graph.print();
        // graph.depthFirstTraversal("X");
        // System.out.println();
        // graph.depthFirstTraversal("B");
        // System.out.println();
        // graph.depthFirstTraversal("C");
        // System.out.println();
        // graph.depthFirstTraversal("D");
        // System.out.println();
        // graph.addNode("Bag");
        // graph.addNode("Dog");
        // graph.addNode("Cat");
        // graph.addEdge("Cat","Bag");
        // graph.addEdge("Cat","Dog");
        // graph.addEdge("Dog","Bag");
        // graph.addEdge("Bag","Dog");
        // graph.print();
        // graph.removeNode("Bag");
        // System.out.println("Final");
        // graph.print();
        // System.out.println("1");
        // graph.print();
        // graph.removeNode("Dog");
        // System.out.println("2");
        // graph.print();
        // graph.addEdge("Bag", "Dog");
        // System.out.println("3");
        // graph.print();
        // graph.addEdge("Bag", "Cat");
        // graph.addEdge("Dog", "Cat");
        // System.out.println("4");
        // graph.print();
        // graph.removeEdge("Cat", "Bag");
        // System.out.println("5");
        // graph.print();
        // graph.removeEdge("Bag", "Cat");
        // System.out.println("6");
        // graph.print();

        // AVLTree tree = new AVLTree();
        // tree.insert(12);
        // tree.insert(3);
        // tree.insert(9);
        // tree.insert(4);
        // tree.insert(6);
        // tree.insert(2);
        // tree.isPerfect();

        // Trie trie = new Trie();
        
        // trie.insert("Car");
        // trie.insert("Card");
        // trie.insert("Care");
        // trie.insert("Careful");
        // trie.insert("Egg");
    }
}
