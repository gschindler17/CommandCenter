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
	
	
	
	
	
	
	public Controller () {
		// Initializes the storageSystem
		// Type: PersistenceBackend
		storageSystem = new PersistenceBackend();
		rotatingMessages = new CircularLinkedList<String> ("SAMPLE");
		
	}
	
	
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	public void reloadData() {
		// TODO Auto-generated method stub
		
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
