package commandCenterPackage;

import java.util.ArrayList;


public class MinHeap {

	private PriorityNode[] heapArray;
	private int heapSize;
	private int maxSize;
	
	public MinHeap(int _maxSize) {
		maxSize = _maxSize;
		heapSize = 0;
		
		heapArray = new PriorityNode[maxSize];
	
	}
	
	
	private int parent(int index)
	{
		return (index - 1) / 2;
	}
	
	private int leftChild(int index)
	{	
		return (2 * index + 1);
	}
	
	private int rightChild(int index)
	{
		return (2 * index) + 2;
	}
	
	private void swap(int firstIndex, int secondIndex)
	{
		PriorityNode temp;
		temp = heapArray[firstIndex];
		
		heapArray[firstIndex] = heapArray[secondIndex];
		heapArray[secondIndex] = temp;
	}
	
	
	// heapify the node at i
		private void buildHeap(int startingIndex) {
		// If the node is a non-leaf node and any of its child is smaller
			if (!isLeaf(startingIndex)) {
				if (heapArray[startingIndex].compareTo(heapArray[leftChild(startingIndex)]) == 1  ||
						heapArray[startingIndex].compareTo(heapArray[rightChild(startingIndex)]) == 1 ) {
					if (heapArray[leftChild(startingIndex)].compareTo(heapArray[rightChild(startingIndex)])  == -1) {
						swap(startingIndex, leftChild(startingIndex));
						buildHeap(leftChild(startingIndex));
					} else {
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
	
	
	private boolean isLeaf(int startingIndex) {
		 	
		if (startingIndex > (heapSize / 2) && startingIndex <= heapSize)
		 {
	            return true;
	     }
	 
	    return false;
	}


	// To remove and return the minimum
    // element from the heap
    public PriorityNode delete()
    {
 
        PriorityNode popped = heapArray[0];
        heapArray[0] = heapArray[heapSize--];
        buildHeap(0);
 
        return popped;
    }
	
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
	
	public void add(String data, int priorityVal) throws ArrayIndexOutOfBoundsException {		
		
		if (heapSize >= maxSize) {
			return;
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
	
	
	private class PriorityNode implements Comparable <PriorityNode>{
		
		public int priorityVal;
		public String data;
		
		
		public PriorityNode(String _data, int _priorityVal)
		{
			data = _data;
			priorityVal = _priorityVal;
		}



		@Override
		public int compareTo(PriorityNode parameter) {
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
	
	@Override
	public String toString() {
		return this.allMessages() + this.allPriorities();
	}


	
}
	
