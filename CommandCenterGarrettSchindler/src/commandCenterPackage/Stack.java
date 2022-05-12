package commandCenterPackage;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Stack <T> implements DSStack<T> {

	/** The last node in the list */
	private ListNode tail;
	
	/** The first node in the list */
	private ListNode head;
	
	/** The number of items in the list */
	int size = 0;
	
	/**
	 * Constructor
	 * No parameters because starting condition is always "empty"
	 * attributes: size, tail, head
	 * 
	 * BOTH SENTINEL HEAD AND SENTINEL TAIL
	 */
	public Stack () {
		size = 0;
		tail = new ListNode(null, null);
		head = new ListNode(null, tail);
		
	}	
	
	
	/**
	 * True if empty, false if more than 1 value
	 */
	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public void push(T element) {
		
		size++;
		ListNode newNode = new ListNode(element, head.next);
		
		head.next = newNode;
	
		
		
	}

	/**
	 * Removes the top item in the stack
	 * Returns that top item; Type: T
	 */
	@Override
	public T pop() throws IllegalArgumentException {
				
		if (head.next == tail)
		{
			throw new IllegalArgumentException("Cannot delete from an empty stack");
		}
		
		ListNode toReturn = head.next;
		head.next = head.next.next;
		size--;
		
		return toReturn.data;
		
	}

	/**
	 * Gets the top item in the stack
	 */
	@Override
	public T top() throws EmptyStackException {
		if (head.next == tail)
		{
			throw new EmptyStackException();
		}
		
		return head.next.data;
	}
	
	/**
	 * Object that there is a stack of
	 * Both data and pointer to next ListNode as attributes
	 */
	private class ListNode{
		// The data to store in this node:
		public T data;
		// A "pointer" to the next node or null at the end of the list
		public ListNode next;
		
		/**
		 * Constructor
		 * @param data - the next item to store
		 * @param next- the object reference to the next item
		 */
		public ListNode (T _data, ListNode _next){
			data = _data;
			next = _next;
		}
		
	} //ListNode
	
	@Override
	public String toString() {
		String toReturn = "";
		ListNode prev = head;
		
		while (prev.next != tail)
		{
			toReturn = toReturn + ((String) prev.next.data) + ", ";
			prev = prev.next;
		}
		
		return toReturn;
	}


	/**
	 * Takes a string of data and loads it into the Stack
	 * Adds each element found in the String
	 * @param loadedString full of items to be added to the stack
	 */
	public void loadInData(String loadedString) {

		
		int count = 0;
		String temp = loadedString;
		ArrayList<String> entries = new ArrayList<String> ();
		
		
		count = countChar(temp, ',');
		
		for(int i = 0; i < count; i++)
		{
			entries.add(0, temp.substring(0, temp.indexOf(',')));
			temp = temp.substring(temp.indexOf(',') + 2, temp.length());
		}
		
		
		
		this.clear();
		
		for (String entry: entries)
		{
			
			this.push((T)(entry));
		}
		
	}
	
	
	/**
	 * Clear method
	 * Re-initializes the stack
	 * Sets size to 0, re-creates head & tail
	 */
	private void clear() {
		size = 0;
		tail = new ListNode(null, null);
		head = new ListNode(null, tail);
		
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
	    {    
	    	if(str.charAt(i) == c)
	        {
	    		count++;
	        }
	    }

	    return count;
	}
	

}
