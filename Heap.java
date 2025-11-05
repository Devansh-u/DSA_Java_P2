
/**
 * Write a description of class Heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.ArrayList;

public class Heap
{
    private int[] heap;
    private int count,size;
    
    public Heap() {
        heap = new int[10];
        size = 10;
    }
    
    private void resize(boolean isForceFull) {
        if (isForceFull || count == size) {
            var temp = new int[2*size];
            for (int i = 0; i<count; i++)
                temp[i] = heap[i];
            heap = temp;
            size *= 2;
        }
    }
    
    public void insert(int item) {
        resize(false);
        
        heap[count] = item;
        verifyHeap(item, count, true);
        
        count++;
    }
    
    private void verifyHeap(int value, int index, boolean isInsert) {
        while (!isHeap(value, index, isInsert)) {
            int iD = performBubbling(value, index, isInsert);
            index = iD;
        }
    }
    
    private int performBubbling(int value, int index, boolean isBubbleUp) {
        // System.out.println("Bubbling "+( (isBubbleUp) ? "Up "
            // : "Down " )+value);
        var newId = (isBubbleUp) ? getPId(index) : getCId(index);
        swap(index, newId);
        return newId;
    }
    
    public int remove() {
        var result = heap[0];
        heap[0] = heap[count-1];
        heap[--count] = 0;
        
        verifyHeap(heap[0], 0, false);
        return result;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    private int getPId(int cId) {
        return (cId - 1) / 2;
    }
    
    private int getCId(int pId) {
        var lCId = (2*pId) + 1;
        var rCId = (2*pId) + 2;
        if (lCId >= size || rCId >= size)
            resize(true);
        return (heap[lCId] >= heap[rCId]) ? lCId : rCId;
    }
    
    private boolean isHeap(int value, int index, boolean isBubbleUp) {
        return (isBubbleUp) ? heap[getPId(index)] >= value : 
            value >= heap[getCId(index)];
    }
    
    private void swap(int child, int parent) {
        var temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }
    
    public void heapSort() {
        System.out.println(Arrays.toString(sort().toArray()));
    }
    
    private ArrayList<Integer> sort() {
        ArrayList<Integer> result = new ArrayList<>();
        var duplicate = this;
        while (!duplicate.isEmpty())
            result.add(duplicate.remove());
        return result;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap,0,count));
    }
}