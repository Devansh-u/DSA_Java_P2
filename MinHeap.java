
/**
 * Write a description of class MinHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinHeap
{
    private class Node{
        private int key;
        private String value;
        
        public Node(String value, int key) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] heap;
    private int size;
    
    public MinHeap(){
        heap = new Node[10];
    }
    
    public void insert(String value, int key) {
        Node node = new Node(value, key);
        heap[size++] = node;
        
        checkHeap(size-1, true);
    }
    
    public int remove() {
        var result = heap[0].key;
        heap[0] = heap[--size];
        heap[size+1] = null;
        
        checkHeap(0, false);
        
        return result;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    private void checkHeap(int index, boolean isInsert) {
        if (!isInsert) {
            var newIndex = index;
            var leftIndex = leftIndex(index);
            if (hasRight(index)) {
                if (heap[newIndex].key > heap[leftIndex].key)
                    newIndex = leftIndex;
                var rightIndex = rightIndex(index);
                if (heap[newIndex].key > heap[rightIndex].key)
                    newIndex = rightIndex;
                
                if (newIndex == index)
                    return;
            
                swap(index, newIndex);
                checkHeap(newIndex,isInsert);
            }
            else {
                if (hasLeft(index) 
                    && heap[index].key > heap[leftIndex].key) {
                        swap(index, leftIndex);
                        checkHeap(leftIndex,isInsert);
                }
            }
        }
        else {
            var parentIndex = parentIndex(index);
            if (parentIndex == index)
                return;
            if (heap[parentIndex].key > heap[index].key) {
                swap(index, parentIndex);
                checkHeap(parentIndex, isInsert);
            }
        }
    }
    
    private void swap(int index, int newIndex) {
        var temp = heap[index];
        heap[index] = heap[newIndex];
        heap[newIndex] = temp;
    }
    
    private int parentIndex(int index) {
        return (index-1) / 2;
    }
    
    private int leftIndex(int index) {
        return 2*index + 1;
    }
    
    private int rightIndex(int index) {
        return 2*index + 2;
    }
    
    private boolean hasLeft(int index) {
        return (2*index + 1) < size;
    }
    
    private boolean hasRight(int index) {
        return (2*index + 2) < size;
    }
    
    public void print() {
        for (int i = 0 ; i<size ; i++)
            System.out.println(heap[i].value+" , "+heap[i].key);
    }
}