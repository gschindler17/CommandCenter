package commandCenterPackage;

import java.util.ArrayList;

/** 
 
 * @author Garrett Schindler
 * @version Fall 2022
 *
 * @param <T> the type of data we are storing in this LinkedList
 */
public class CircularLinkedList<T> {
	
	/** The first node in the list */
	private ListNode head;
	
	/** The last node in the list */
	private ListNode tail;
	

	/** The number of items in the list */
	private int size;
	
	/** Current node */
	private ListNode currentNode;

	
	/**
	 * Empty constructor of CircularLinkedList
	 * Initializes a CircularLinkedList object 
	 */
	public CircularLinkedList() {
		tail = null;
		head = null;
		size = 0;
		currentNode = head;
	}
	
	/**
	 * Initializes a CircularLinkedList object
	 * @param firstData first item to add to the CircularLinkedList
	 */
	public CircularLinkedList(T firstData) {
		tail = null;
		head = null;
		size = 0;
		this.add(firstData);
		currentNode = head;
	}
	
	/**
	 * Clears the CircularLinkedList
	 * Sets to null
	 */
	public void clear() {
		tail = null;
		head = null;
		size = 0;
		currentNode = head;
	}
	
	/**
	 * @return size of the CircularLinkedList
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * Adds a data piece to the CircularLinkedList
	 * @param data of Type T
	 */
	public void add(T data) {
		ListNode newNode = new ListNode(data, null);

		// if the CircularLinkedList is empty
	    if (head == null) {
	        head = newNode;
	    } else {
	        tail.next = newNode;
	    }

	    // Links all of the ListNodes together
	    tail = newNode;
	    tail.next = head;
	    currentNode = head;
	    size++;
	}
	
	/**
	 * @return String of the CircularLinkedList
	 */
	@Override
	public String toString() {
		String output = "";
		ListNode reference = head;
		
		for (int i = 0; i < size; i++)
		{
			output = output + reference.rdata + ", ";
			reference = reference.next;
		}
		return output;
		
	}
	

	
	/**
	 * ListNode objects are passed around in the CircularLinkedList
	 * @author Garrett Schindler
	 *
	 */
	private class ListNode{
		// The data to store in this node:
		public T rdata;
		// A "pointer" to the next node or null at the end of the list
		public ListNode next;
		
	
		/**
		 * Constructor
		 * @param data - the next item to store
		 * @param next- the object reference to the next item
		 */
		public ListNode ( T _rdata, ListNode _next){
			rdata = _rdata;
			next = _next;
		}
		
		@Override
		public String toString() {
			return (String) rdata;
		}
		
	}
	
	
	/**
	 * Note that this is returning pointer the data item (type T), not the ListNode object
	 * @param index index that you want to fetch data from
	 * @return data item located at that index
	 * @throws IllegalArgumentException if requested index is out of bounds
	 */
	public T get(int index) throws IllegalArgumentException{
		
		if (index < 0 || index > size)
		{
			throw new IllegalArgumentException("Index is simply out of bounds.");
		}
		
		
		ListNode scratch1 = findNodeAtPosition(index);
		return scratch1.rdata;
		
	}
	
	
	/**
	 * Helper method to locate the node at a particular index
	 * Can be used to avoid duplicated code in other methods
	 * Note this is private since it is used to support the public methods
	 * @param index the index you want to locate
	 * @return A pointer to the node at requested index
	 * @throws IllegalArgumentException If requested index is out of bounds
	 */
	private ListNode findNodeAtPosition(int index) throws IllegalArgumentException{
		
		if (index < 0 || index > size)
		{
			throw new IllegalArgumentException("Index is simply out of bounds.");
		}
		
		ListNode scratch = head;
		
		for (int i = 0; i < index; i++)
		{
			scratch = scratch.next;
		}
		
		return scratch;
	}



	/**
	 * Removes data from the CircularLinkedList
	 * @param data to be deleted
	 */
	public void delete(String data) {
		if (size ==  0)
		{
			throw new IllegalArgumentException ("Cannot delete from an empty LinkedList");
		}
		
		
		ListNode ref = head;
		boolean found = false;
		
		for (int i = 0; i < size; i++)
		{
			if (ref.rdata.equals(data))
			{
				ref.next = ref.next.next;
				size--;
				found = true;
			}
			
			ref = ref.next;
		}
		
		if (!(found))
		{
			throw new IllegalArgumentException ("Data to delete not found in the CircularLinkedList");
		}
	}


	/**
	 * Grabs the next item in the circularly linked list
	 * Increments currentNode after finding it
	 * @return String of the data in next node
	 * @throws NullPointerException if currentNode is null or currentNode.rdata is null
	 */
	public String next() throws NullPointerException{
		
		// If the currentNode is null, throw exception
		if (currentNode == null)
		{
			throw new NullPointerException("NOTHING IN LINKEDLIST!!");
		}
		
		// If the currentNode has no data, throw exception
		if (currentNode.rdata == null)
		{
			throw new NullPointerException("You must add a value to the list to continue");
		}
		
		// Go to the next node
		currentNode = currentNode.next;
		
		String toReturn = (String)currentNode.rdata;
				
		

		return toReturn;
		
	}


	/**
	 * Deletes the currentNode from the CircularLinkedList
	 */
	public void deleteCurrent() {
		
		ListNode temp = head;
		
	    // if the CircularLinkedList is empty, return
		if (head == null) { // the list is empty
	        return;
	    }
	    
		// if the currentNode is the head and there is more than 1 item in array
	    if (temp == currentNode && size > 1)
	    {
	    	// Go to the node before currentNode
	    	for (int k = 0; k < size - 1; k++)
	    	{
	    		temp = temp.next;
	    	}
	    	
	    	// Remove the node from the CircularLinkedList and return
	    	temp.next = head.next;
	    	head = head.next;
	    	currentNode = temp;
	    	size--;
	    	return;
	    }
	    
	    // If currentNode != head, then increment until node is deleted
	    for (int i = 0; i < size; i++)
	    {
	    	if (temp.next == currentNode)
	    	{
	    		temp.next = currentNode.next;
	    	}
	    	
	    	temp = temp.next;
	    }
	    
	    size --;
		
		
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
		
		for (String LLS: entries)
		{
			
			this.add((T)LLS);
		}
		
		
		
	}
	
	private static int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }

	    System.out.println("COUNT: " + count);
	    return count;
	}
}
	
	
	