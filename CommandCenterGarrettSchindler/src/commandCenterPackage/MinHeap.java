package commandCenterPackage;

import java.util.ArrayList;

public class MinHeap <T extends Comparable<? super T>>{

	private T[] heapArray;
	private int heapSize;
	private int maxSize;
	
	public MinHeap(int _maxSize) {
		maxSize = _maxSize;
		heapSize = 0;
		
		heapArray = (T[]) (new Comparable[maxSize]);
	
	}
	
	
	private int parent(int index)
	{
		return index / 2;
	}
	
	private int leftChild(int index)
	{
		return index * 2;
	}
	
	private int rightChild(int index)
	{
		return (2 * index) + 1;
	}
	
	private void swap(int firstIndex, int secondIndex)
	{
		T temp;
		temp = heapArray[firstIndex];
		
		heapArray[firstIndex] = heapArray[secondIndex];
		heapArray[secondIndex] = temp;
	}
	
	public void buildHeap(int startingIndex)
	{
		// If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(startingIndex)) {
        	if (heapArray[startingIndex].compareTo(heapArray[leftChild(startingIndex)]) > 0 || heapArray[startingIndex].compareTo(heapArray[rightChild(startingIndex)]) > 0)    
        	{
                // Swap with the left child and heapify
                // the left child
                if (heapArray[leftChild(startingIndex)].compareTo(heapArray[rightChild(startingIndex)]) < 1) {
                    swap(startingIndex, leftChild(startingIndex));
                    buildHeap(leftChild(startingIndex));
                }
 
                // Swap with the right child and heapify
                // the right child
                else {
                    swap(startingIndex, rightChild(startingIndex));
                    buildHeap(rightChild(startingIndex));
                }
            }
        }
	}
	
	
	private boolean isLeaf(int startingIndex) {
		 	
		if (startingIndex > (heapSize / 2) && startingIndex <= heapSize)
		 {
	            return true;
	     }
	 
	    return false;
	}


	// To remove and return the minimum
    // element from the heap
    public T delete()
    {
 
        T popped = heapArray[0];
        heapArray[0] = heapArray[heapSize--];
        buildHeap(0);
 
        return popped;
    }
	
	public void loadInData(String loadedString) {
		int count = 0;
		String temp = loadedString;
		ArrayList<String> entries = new ArrayList<String> ();
		
		
		count = countChar(temp, ',');
		
		for(int i = 0; i < count; i++)
		{
			entries.add(temp.substring(0, temp.indexOf(',')));
			temp = temp.substring(temp.indexOf(',') + 2, temp.length());
		}
		
		
		this.clear();
		
		for (String entry: entries)
		{
			
			this.add((T)entry);
		}
		
	}
	
	private void add(T entry) throws ArrayIndexOutOfBoundsException {
		if (heapSize >= maxSize) {
            throw new ArrayIndexOutOfBoundsException("CANNOT ADD TO MINHEAP, ArrayIndexOutOfBoundsException");
        }
 
        heapArray[++heapSize] = entry;
        int current = heapSize;
 
        while (heapArray[current].compareTo(heapArray[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
		
	}

	private void clear() {
		
		
	}

	private static int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }

	    return count;
	}
		
}
