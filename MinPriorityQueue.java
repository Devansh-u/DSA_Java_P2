
/**
 * Write a description of class MinPriorityQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinPriorityQueue
{
    private MinHeap heap;
    
    public MinPriorityQueue(){
        heap = new MinHeap();
    }
    
    public void enqueue(String value, int priority){
        heap.insert(value, priority);
    }
    
    public int dequeue(){
        return heap.remove();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public void print() {
        heap.print();
    }
}