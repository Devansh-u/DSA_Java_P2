public class BinaryTrees {
    /*
        Tree is a data structure that stores elements in a hierarchy, we refer to these elements
        as nodes and lines that connect them as edges
        these nodes contains value or data

        the top most node is called ROOT, the nodes below another are called CHILD nodes to them
        and the last node below which there is no other node are called LEAF nodes

        if a tree have maximum of two children nodes then it is called Binary Tree

        we use tree where we want to represent hierarchical data
        databases uses trees for indexing
        autocompletion is also another application to trees

        Binary search tree is a special kind of binary tree which follow a particular pattern
        ie, each node in binary search tree is greater than it's left node and smaller than it's
        right node
        left < node < right
        eg :      7
                 / \
                4   9
               / \ / \
              1  6 8  10
        here 1 < 4 < 6 ; similarly 4 < 7 < 9
        there is also another pattern that is the whole left subtree of root node have all
        values smaller than root itself and whole right subtree have all values greater than
        root node

        these patterns helps in searching for an element in a tree, so that we need not to
        traverse the complete tree

        time complexities of tree functions are as follows
        O(logn) -> lookup
        O(logn) -> insert
        O(logn) -> delete
        in all above functions as we move we rejects/selects the half of tree by comparison
        hence they all run in logarithmic manner


        As trees are non linear data structures we have different approaches for traversal over
        a tree, these approaches are classified into two different categories
        Breadth first or Level Order
        Depth first

        in Breadth first, we traverse all nodes at same level and then move to next level

        in Depth first we have three different ways to traverse these are
        pre-order -> root, left subtree, right subtree
        in-order -> left subtree, root, right subtree
        post-order -> left subtree, right subtree, root

        eg :      7
                 / \
                4   9
               / \ / \
              1  6 8  10
        in the above example the order of traversal for different approaches is as follows

        breadth first -> 7 , 4, 9, 1, 6, 8, 10
        depth first
        pre-order -> 7, 4, 1, 6, 9, 8, 10
        in-order -> 1 , 4, 6, 7, 8, 9, 10 // ascending order
                // to get in descending order just reoder by right, root , left
        post-order -> 1, 6, 4, 8, 10, 9, 7
                // in post-order we visited the root from the leaf bottom to top

        depth and height are two different things
        depth is represented by no of edges from root node to target node, simply it is
        calculated as we move down a tree, root node will have 0 depth, both its child will
        have 1 depth and so on
        height is just opposite to depth, the height of leaves are 0 and we move upward the
        height increases, leaf node will have 0 height, it's parent will have 1 height and so
        on

        also to find height of a node we need to find the longest path from the leaf to that
        node

        height of root node is also called height of tree

    */
}
