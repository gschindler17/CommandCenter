package commandCenterPackage;

import java.util.ArrayList;

/**
 * MinHeap is a version of a heap
 * Functions with the parent always a lower value than both children
 * Data Structures
 * @author Garrett Schindler
 * @version 5/11/2022
 *
 */
public class MinHeap {

	/**
	 * Array to keep all of the priority nodes; where the heap is stored
	 */
	private PriorityNode[] heapArray;
	
	/**
	 * Measures the size of the heap; fluctuates
	 */
	private int heapSize;
	
	/**
	 * Determined maximum size for the heap; stagnant on creation
	 */
	private int maxSize;
	
	/**
	 * Constructor
	 * @param _maxSize determined maximum size for the heap
	 */
	public MinHeap(int _maxSize) {
		maxSize = _maxSize;
		heapSize = 0;
		
		heapArray = new PriorityNode[maxSize];
	
	}
	
	/**
	 *
	 * @param index of the current node
	 * @return the index of the parent node
	 */
	private int parent(int index)
	{
		return (index - 1) / 2;
	}
	
	/**
	 * 
	 * @param index of the current node
	 * @return the index of the leftChild
	 */
	private int leftChild(int index)
	{	
		return (2 * index + 1);
	}
	
	/**
	 * 
	 * @param index of the current node
	 * @return the index of the rightChild
	 */
	private int rightChild(int index)
	{
		return (2 * index) + 2;
	}
	
	/**
	 * Swaps the indices of the two items in the heapArray
	 * @param firstIndex 
	 * @param secondIndex
	 */
	private void swap(int firstIndex, int secondIndex)
	{
		PriorityNode temp;
		temp = heapArray[firstIndex];
		
		heapArray[firstIndex] = heapArray[secondIndex];
		heapArray[secondIndex] = temp;
	}
	
	
		// buildHeap the node at i
		private void buildHeap(int startingIndex) {
			// If the node is a non-leaf node and greater
	        // than any of its child
	        if (!isLeaf(startingIndex)) {
	            if ((heapArray[leftChild(startingIndex)] != null && heapArray[startingIndex].priorityVal > heapArray[leftChild(startingIndex)].priorityVal)
	                || (heapArray[rightChild(startingIndex)] != null && heapArray[startingIndex].priorityVal > heapArray[rightChild(startingIndex)].priorityVal)) {
	 
	                // Swap with the left child and buildHeap
	                // the left child
	                if (heapArray[leftChild(startingIndex)].priorityVal
	                    < heapArray[rightChild(startingIndex)].priorityVal) {
	                    swap(startingIndex, leftChild(startingIndex));
	                    System.out.println(leftChild(startingIndex));
	                    buildHeap(leftChild(startingIndex));
	                }
	 
	                // Swap with the right child and buildHeap
	                // the right child
	                else {
	                    swap(startingIndex, rightChild(startingIndex));
	                    buildHeap(rightChild(startingIndex));
	                }
	            }
	        }
		}
		
		// Function to print the contents of the heap
		public void printHeap() {
			for (int i = 0; i < (heapSize / 2); i++) {
				System.out.print("\nParent : " + heapArray[i].priorityVal);
				if (leftChild(i) < heapSize)
					System.out.print(" Left : " + heapArray[leftChild(i)].priorityVal);
				if (rightChild(i) < heapSize)
					System.out.print(" Right :" + heapArray[rightChild(i)].priorityVal);
				System.out.println();
			}
		}
	
	
		/**
		 * 
		 * @param startingIndex
		 * @return boolean of if the current node is a leaf or not
		 */
	private boolean isLeaf(int startingIndex) {
		 	
		if (startingIndex > (heapSize / 2) && startingIndex <= heapSize)
		 {
	            return true;
	     }
	 
	    return false;
	}

	/**
	 * 
	 * @return topPriority in the heap
	 */
	public String topPriority() {
		if (heapSize < 1)
		{
			return "EMPTY";
		}
		
		return heapArray[0].data;
	}

	/**
	 * Takes the top of the heap off of the array and fixes the heap
	 * @return top item in the heap
	 */
    public PriorityNode delete()
    {
    	
    	
    	if (heapSize == 0)
    	{
    		throw new IllegalArgumentException("Cannot delete from an empty heap!");
    	}
 
        PriorityNode popped = heapArray[0];
        
        heapSize--;
        
        heapArray[0] = heapArray[heapSize];
        
        
        if (heapSize > 0)
        {
        	buildHeap(0);
        }
 
        return popped;
    }
	
    /**
     * Loads in the two different data strings and puts them into the heap
     * @param messageString all of the messages 
     * @param priorityString all of the priorities
     */
	public void loadInData(String messageString, String priorityString) {
		int count = 0;
		String messages = messageString;
		String priorities = priorityString;
		ArrayList<String> messagesAL = new ArrayList<String> ();
		ArrayList<Integer> prioritiesAL = new ArrayList<Integer> ();
		
		
		count = countChar(messages, ',');
		
		this.clear();
		
		for(int i = 0; i < count; i++)
		{
			messagesAL.add(messages.substring(0, messages.indexOf(',')));
			messages = messages.substring(messages.indexOf(',') + 2, messages.length());
			
			prioritiesAL.add(Integer.parseInt(priorities.substring(0, priorities.indexOf(','))));
			priorities = priorities.substring(priorities.indexOf(',') + 2, priorities.length());
			
			
			this.add(messagesAL.get(i), prioritiesAL.get(i));
		}
		
		
		
	}
	
	/**
	 * Add another item to the array
	 * @param data
	 * @param priorityVal
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void add(String data, int priorityVal) throws ArrayIndexOutOfBoundsException {		
		
		if (heapSize >= maxSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		heapArray[heapSize] = new PriorityNode(data, priorityVal);
		int current = heapSize;

		while (heapArray[current].compareTo(heapArray[parent(current)]) < 0) {
			swap(current, parent(current));
			current = parent(current);
		}
		heapSize++;
		
	}
	
	
	/**
	 * Clear method
	 * Re-initializes the MinHeap
	 * Sets size to 0
	 */
	private void clear() {
		heapSize = 0;
		
		heapArray = new PriorityNode[maxSize];
	}

	
	/**
	 * Counts the # of times a character occurs in a string
	 * @param str entered String
	 * @param c character that is counted
	 * @return # of times character occurs in string
	 */
	private static int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }

	    return count;
	}
	
	/**
	 * These nodes are put into the heap
	 * These objects are the elements of the heap
	 */
	private class PriorityNode implements Comparable <PriorityNode>{
		
		public int priorityVal;
		public String data;
		
		
		public PriorityNode(String _data, int _priorityVal)
		{
			data = _data;
			priorityVal = _priorityVal;
		}


		/**
		 * Making sure that PriorityNodes are comparable
		 */
		@Override
		public int compareTo(PriorityNode parameter) {
			if (parameter == null)
			{
				return 1;
			}
			
			
			if (this.priorityVal > parameter.priorityVal)
			{
				return 1;
			}
			if (this.priorityVal < parameter.priorityVal)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
		

	}

	/**
	 * @return all of the messages stored within the heap
	 */
	public String allMessages() {		
		
		String toReturn = "";
		
		if(heapSize == 0)
		{
			return "";
		}
		
		
		for (int i = 0; i < heapSize; i++)
		{
			
			toReturn = toReturn + heapArray[i].data + ", ";
		}
	
		return toReturn;
	}
	
	/**
	 * 
	 * @return all of the priorities in the heap
	 */
	public String allPriorities() {
		
		String toReturn = "";
		
		if(heapSize == 0)
		{
			return "";
		} 
		
		for (int k = 0; k < heapSize; k++)
		{
			toReturn = toReturn + heapArray[k].priorityVal + ", ";
		}
		
		return toReturn;
	}
	
	/**
	 * Prints out the contents of the heap
	 * The messages plus the priorities
	 * Messages and priorities are printed out separately
	 */
	@Override
	public String toString() {
		return this.allMessages() + this.allPriorities();
	}


	
}
	
