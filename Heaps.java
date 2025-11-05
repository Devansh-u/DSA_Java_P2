
/**
 * Write a description of class Heaps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heaps
{
    /*
        Heap is a special type of tree with two properties, first property
        is that it is a complete tree, means that each level except the last
        level is full, simply each node will have left and right node except
        the level just above leaves and also to note that levels are filled
        from left to right, means there can be any null right node but if there
        is right node then left node must not be null, second property is heap
        property, means value of every node is greater than or equal to value 
        of its children node
        
        eg
                20
              /    \
            10      15
           /  \    /
          4    5  6
        it is complete tree as except last level each level is completely
        filled and nodes are filled in left to right order, means there is no
        such case where right node is present & left do not in same level
        here each node below 20 can have value less than or equal to 20
        
        it is more acurately called binary heap as it is a binary tree
        it is called a MAX Heap where root is greatest and in a MIN Heap root
        is smallest
        
        Properties of Heap
        1 - Complete (Perfect + left to right filling)
        2 - Heap Property
        
        Applications of Heap
        1 - sorting (heap sort)
        2 - graph algorithms (shortest path) eg in google maps
        3 - implementing priority queues
        4 - finding Kth smallest/largest value
        
        Operations on Heap
        we simply insert items as in a tree and if it is not in right place
        we move it up/down based on Max/Min Heap to place it at right position
        this upward movement is called 'bubbling up' (simply swapping value
        with parent node's value is bubbling up)
        
        Time Complexity of insertion, the longest the value can travel is
        height of tree, O(logn), mathematically height of tree h = logn for
        binary search tree
        
        Time Complexity of deletion, in heaps we can only delete root node not
        any of child nodes, and we have to fill this root node with another
        value to maintain the heap property, so we have to pick the right most
        value in last level to put at root node and now check for completeness
        of heap, to maintain heap property we will apply the bubbling up or
        bubbling down operation, this operation also run in logn as max
        comparison for heap property is height of tree
        
        Time Complexity
        1 - Insert() -> O(logn)
        2 - Delete() -> O(logn)
        3 - Max() -> O(1) for MAX Heap
        4 - Min() -> O(1) for MIN Heap
        
        
        Although heaps are binary trees we use array of objects to store values
        as they are complete binary trees and don't have any holes, so its
        more efficient to store them in arrays
        
        the index of node follows level order traversal and to get index for
        child nodes we have formulas
        left child = 2*indexOfParent + 1
        right child = 2*indexOfParent + 2
        
        for index of parent node formula is
        parent = (indexOfChild - 1) / 2
        
        
        Heap sort says that in a Max Heap the root value is maximum, and when
        we remove it then root will have value of next maximum, in this way
        we can get the descending order for data and if Heap is Min Heap we
        can get the ascending order
        
        Similarly priority queues can be implemented using heap and the benefit
        is the time complexity reduces from O(n) to O(log n) for insertion, but
        however the deletion time complexity is O(1) in priority queues whereas
        O(log n) in heaps.
    */
}