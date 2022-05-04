package commandCenterPackage;

/**
 * Handles the brains of the entire equation
 * @author Garrett Schindler
 *
 */
public class Controller {

	/**
	 * Object that handles behind the scenes persistence
	 */
	private PersistenceBackend storageSystem;
	
	
	/**
	 * Object that handles the RotatingMessages
	 * Type: CircularLinkedList
	 */
	private CircularLinkedList<String> rotatingMessages;
	
	
	/**
	 * Object that handles the PriorityQueue data
	 * Type: MinHeap
	 */
	private MinHeap priorityMinHeap;
	
	
	private Stack<String> backlogStack;
	
	
	
	
	
	
	public Controller() {
		
		
		rotatingMessages = new CircularLinkedList<String> ();
		priorityMinHeap = new MinHeap (100);
		backlogStack = new Stack<String> ();
		
		storageSystem = new PersistenceBackend(rotatingMessages, priorityMinHeap, backlogStack);
		
		
	}
	
	
	public void saveData() {
		storageSystem.saveData();
		
	}

	public void reloadData() {
		storageSystem.reloadData();
		
	}


	public CircularLinkedList<String> getRotatingMessages() {
		return rotatingMessages;
	}
	
	public void addRotatingMessages(String data) {
		rotatingMessages.add(data);
	}
	
	public void deleteRotatingMessages(String data) {
		rotatingMessages.delete(data);
	}


	public String nextRotatingMessage() {
		return rotatingMessages.next();
	}


	public void addMessageToRMP(String messageToAdd) {
		rotatingMessages.add(messageToAdd);
		
	}


	public void removeMessageFromRMP() {
		rotatingMessages.deleteCurrent();
		
	}
	
	
	


		

	
}
