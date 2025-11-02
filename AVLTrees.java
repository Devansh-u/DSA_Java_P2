
/**
 * Write a description of class AVLTrees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AVLTrees
{
    /*
       The need to balance trees is because the avg time complexity of 
       operations on balanced trees is O(logn) and as tree becomes unbalance
       these operations slows down and their complexity increases to O(n)
       
       
       Balanced trees holds true for the property that the left sub tree
       and right subtree will have maximum of '1' height difference between
       them
       eg 
            a
           / \
          b   c
             / \
            d   e
       it will be considered a balnced tree, because the difference between
       the left and right subtree of every node is less than or equal to '1'
            a
           / \
          b   c
             / \
            d   e
                 \
                 f
       this is an unbalanced tree, because the right subtree is taller than
       left subtree and has height difference greater than 1
       
       
       Tree structure that mostly contains right child are Right Skewed trees
       and similarly those mostly contains left child are Left Skewed trees
       
       
       AVL Trees are the first self-balancing trees, when we add nodes 
       to AVL trees the tree tries to balance itself
       
       balancing is followed by adding/insert operation, as soon as a node
       it added balancing is performed
       
       AVL stands for (Adelson Velsky and Landis), named after their investors
       there are many more self balancing trees
       
       
       AVL trees uses rotation to balance themselves
       
       Types of rotations are
       Left(LL)
       Right(RR)
       Left-Right(LR)
       Right-Left(RL)
       
       steps for implementing rotations are simple and clear, first find the
       node which is violating the balancing property (ie height of left and
       right child varies by more than 1)
       then we identify which side left or right need to be rotated, its also
       a simple task as we just need to look for following things,
       
       if tree is simply unbalanced at right side of node then we use left
       balancing
       if tree is unbalanced at left side of node then we use right balancing
       if tree is unbalanced in a way that first child is at right and child
       of that right node is at left then we use right-left balancing
       and vice versa (in these cases, the first rotation is applied
       to first child of primary node and other to primary node itself)
       
       while performing balancing we are allowed to detach a node for
       simplicity and later add it to the tree at correct position
    */
}