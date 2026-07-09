package Heaps;
import java.util.*;

public class maxHeap 
{
    ArrayList<Integer> heap;

    public void initializeHeap()
    {
        heap = new ArrayList<>();
    }

    public void insert(int x)
    {
        heap.add(x);
        int i = heap.size()-1;

        // Bubble up/Heapify Up
        while(i>0)
        {
            int parent = (i-1)/2;

            if(heap.get(parent)<heap.get(i))
            {
                int temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.get(parent,temp);

                i=parent;
            }
            else break;
        }

    }

    // delete/extractMax
    public int delete()
    {
        // heap is empty
        if(heap.size()==0)
        {
            throw new RuntimeException("Heap is Empty");
        }

        if(heap.size()==1)
        {
            return heap.remove(0);
        }

        int max = heap.get(0);
        
        int lastIdx = heap.size()-1;
        heap.set(0,heap.get(lastIdx));
        heap.remove(lastIdx);

        int i = 0;

        // Now heapify down
        while(true) // OR: while(2*i+1<heap.size())
        {
            int left = 2*i+1;
            int right = 2*i+2;

            int largest = i;

            //check left child
            if(left<heap.size() && heap.get(left)>heap.get(largest))
            {
                largest = left;
            }

            //check right child
            if(right<heap.size() && heap.get(right)>heap.get(largest))
            {
                largest = right;
            }

            if(largest==i)
            {
                break;
            }

            //Swap
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest,temp);

            i=largest;
        }

        return max;
    }

    
}
