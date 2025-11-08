
/**
 * Write a description of class Tries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tries
{
    /*
       Tries are another kind of trees but they are not binary trees, each
       child can have several nodes
       
       the name 'tries' comes from re'trie'val, other names are digital, radix
       and prefix
       
       tries are used to implement autocompletion, it is one of the key
       application of tries
       
       tries allows us to store thousand or even millions of data in minimal
       space and provide super fast lookup
       
       eg
                root
                /   \
               b     c
             /  \     \
            a    o     a
           /      \     \
          g        y     t
      here bag and boy share same prefix ie 'b'
      if we want to add baggage word, we simply need to extend the bag child
      
      here child can maximum have 26 further childs as there are 26 alphabets
      in english
      
      the root node is always null or empty character because english word can
      start with any of letters
      
      
      Time complexity for operations
      Lookup of word -> O(L) where L is no of letters in word
      Insertion of word -> O(L)
      Deletion of word -> O(L)
      
      
      Tries support two types of traversals, Pre-Order and Post-Order
      in Pre-Order we first visit the root then children and in Post-Order
      we first visit the children then root
      
      For deleting a word we use Post-Order traversal means leaf to root
      and for searching/auto-completion we use Pre-Order
    */
}