package commandCenterPackage;



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

	public CircularLinkedList() {
		tail = null;
		head = null;
		size = 0;
		currentNode = head;
	}
	
	public CircularLinkedList(T firstData) {
		tail = null;
		head = null;
		size = 0;
		this.add(firstData);
		currentNode = head;
	}
	
	
	public void clear() {
		size = 0;
		head = null;
		currentNode = head;
		tail = null;
	}
	
	
	public int getSize() {
		return size;
	}
	
	
	public void add(T data) {
		ListNode newNode = new ListNode(data, null);

	    if (head == null) {
	        head = newNode;
	    } else {
	        tail.next = newNode;
	    }

	    System.out.println("HEAD:" + head);
	    
	    tail = newNode;
	    tail.next = head;
	    currentNode = head;
	    size++;
	}
	
	
	
	
	// TODO Check validity
	@Override
	public String toString() {
		String output = "";
		ListNode reference = head;
		
		System.out.println("size: " + size);
		
		for (int i = 0; i < size; i++)
		{
			output = output + reference.rdata + ", ";
			reference = reference.next;
		}
		return output;
		
	}
	

	
	
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



	// TODO Check validity
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


	public String next() throws NullPointerException{
		
		if (currentNode == null)
		{
			throw new NullPointerException("NOTHING IN LINKEDLIST!!");
		}
		
		
		if (currentNode.rdata == null)
		{
			throw new NullPointerException("You must add a value to the list to continue");
		}
		
		System.out.println(currentNode);
		currentNode = currentNode.next;
		
		String toReturn = (String)currentNode.rdata;
				
		

		return toReturn;
		
	}


	public void deleteCurrent() {
		
		ListNode temp = head;
	    if (head == null) { // the list is empty
	        return;
	    }
	    
	    if (temp == currentNode && size > 1)
	    {
	    	for (int k = 0; k < size - 1; k++)
	    	{
	    		temp = temp.next;
	    	}
	    	
	    	System.out.println("\nTEMP: " + temp);
	    	System.out.println("head.next: " + head.next + "\n");
	    	
	    	
	    	temp.next = head.next;
	    	head = head.next;
	    	currentNode = temp;
	    	size--;
	    	return;
	    }
	    
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
}
	
	
	