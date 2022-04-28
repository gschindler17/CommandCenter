package linkedListPackage;



/** 
 * A simple LinkedList implementation
 * We will move on to a better version of this soon
 * @author gosnat
 * @author Garrett Schindler
 * @version Fall 2020
 *
 * @param <T> the type of data we are storing in this LinkedList
 */
public class LinkedList<T> {
	
	/** The first node in the list */
	private ListNode head;
	
	/** The last node in the list */
	private ListNode tail;

	/** The number of items in the list */
	int size = 0;

	
	public LinkedList() {
		clear();
	}
	
	
	public void clear() {
		size = 0;
		tail = new ListNode(null, null);
		head = new ListNode(null, tail);
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
		
		for (int i = 0; i <= index; i++)
		{
			scratch = scratch.next;
		}
		
		return scratch;
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
		
		
		ListNode scratch = findNodeAtPosition(index);
		return scratch.rdata;
		
	}
	
	/**
	 * Does this item exist in the list?
	 * @param data The data item you're looking for
	 * @return true if data item is already in the list, false if not
	 */
	public boolean contains(T target) {
		ListNode scratch = head.next;
		boolean result = false;
		
		while (scratch != tail)
		{
			if (scratch.rdata.equals(target))
			{
				result = true;
			}
			scratch = scratch.next;
		}
		return result;
	}
	
	@Override
	public String toString() {
		String output = "";
		ListNode reference = head.next;
		
		while (reference != tail)
		{
			output = output + reference.rdata + " ";
			reference = reference.next;
			
		}
		return output;
		
	}
	
	
	public void insert(T _data, int _index) throws IllegalArgumentException {
		if (_index < 0 || _index > size)
		{
			throw new IllegalArgumentException("Index is simply out of bounds.");
		}
		
		ListNode prev = head;
		
		for (int i =0; i < _index; i++)
		{
			prev = prev.next;
		}
		
		
		ListNode insertNode = new ListNode(_data, prev.next);
		
		prev.next = insertNode;
		size++;
		
		
	}
	
	
	public void delete(T _data) throws IllegalArgumentException{
		
		if (size ==  0)
		{
			throw new IllegalArgumentException ("Cannot delete from an empty LinkedList");
		}
		
		
		ListNode ref = head;
		
		boolean found = false;
		
		while (ref.rdata != null)
		{
			if (ref.rdata.equals(_data))
			{
				ref.next = ref.next.next;
				size--;
				found = true;
			}
			
			ref = ref.next;
		}
		
		if (!(found))
		{
			throw new IllegalArgumentException ("Data to delete not found in the LinkedList");
		}
		
	}

	
	public void deleteIndex(int _index) throws IllegalArgumentException {
		if (_index < 0 || _index > size)
		{
			throw new IllegalArgumentException("Index is simply out of bounds.");
		}
		
		ListNode deleteNode = head;
		
		for (int i = 0; i < _index; i++)
		{
			deleteNode = deleteNode.next;
		}
			
			
		deleteNode.next = (deleteNode.next.next);
		size--;
	}
	
	
	/**
	 * A private class for our ListNodes
	 * Since this class is private, only code in the LinkedList class can reference it
	 * We can safely make the attributes here public because no one else can get to the private class
	 * This allows for simpler code in our LinkedList class as long as we can trust ourselves
	 * not to supply illegal values
	 * Note that since this is a private class, we're still using the same type T as the LinkedList
	 * class that we are inside of, so no need to re-declare that type parameter here.
	 * @author gosnat
	 *
	 */
	
	private class ListNode{
		// The data to store in this node:
		T rdata;
		// A "pointer" to the next node or null at the end of the list
		ListNode next;
		
		
		/**
		 * Constructor
		 * @param data - the next item to store
		 * @param next- the object reference to the next item
		 */
		public ListNode (T _rdata, ListNode _next){
			rdata = _rdata;
			next = _next;
		}
		
	}
	
}