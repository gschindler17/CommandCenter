package commandCenterPackage;

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
	
	
	
	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public void push(T element){
		
		ListNode newNode = new ListNode(element, head.next);
		head.next = newNode;
		size++;
		
	}

	@Override
	public T pop() throws EmptyStackException {
		if (head.next == tail)
		{
			throw new EmptyStackException();
		}
		
		ListNode toReturn = head.next;
		head.next = head.next.next;
		size--;
		return toReturn.data;
		
	}

	@Override
	public T top() throws EmptyStackException {
		if (head.next == tail)
		{
			throw new EmptyStackException();
		}
		
		return head.next.data;
	}
	
	
	private class ListNode{
		// The data to store in this node:
		T data;
		// A "pointer" to the next node or null at the end of the list
		ListNode next;
		
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
		String toReturn = " ";
		ListNode prev = head;
		
		while (prev.next != tail)
		{
			toReturn = toReturn + prev.next.data;
			prev = prev.next;
		}
		
		return toReturn;
	}
	
	

}