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
	
	
	private BinarySearchBackend BSBackend;
	
	
	
	
	
	
	public Controller() {
		
		
		rotatingMessages = new CircularLinkedList<String> ();
		priorityMinHeap = new MinHeap (100);
		backlogStack = new Stack<String> ();
		BSBackend = new BinarySearchBackend(100);
		
		storageSystem = new PersistenceBackend(rotatingMessages, priorityMinHeap, backlogStack);
		
	}
	
	
	public void saveData() {
		storageSystem.saveData();
		
	}
	
	public void loadData() {
		storageSystem.loadInData();
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


	public void addPriorityTask(String receivedTask, int receivedPriority) {
		priorityMinHeap.add(receivedTask, receivedPriority);
		
	}


	public String getTopPriority() {
		return priorityMinHeap.topPriority();
	}


	public void deleteTopPriority() {
		priorityMinHeap.delete();
		
	}


	public int minBSVal() {
		return BSBackend.getMinGuess();
	}
	
	public int maxBSVal() {
		return BSBackend.getMaxGuess();
	}


	public int compareBSGuess(int _guess) {
		return BSBackend.compareUserGuessToRN(_guess);
	}


	public void incrementGuessNumber() {
		BSBackend.incrementGuessNumber();
		
	}


	public int getGuessNumber() {
		return BSBackend.getGuessNumber();
	}


	public int getBSNumber() {
		return BSBackend.getRN();
	}


	public int getBSComputerGuesses() {
		return BSBackend.numberOfComputerGuesses();
	}
	
	public void resetBSBackend() {
		BSBackend.reset();
	}


	public void addBacklogItem(String text) {
		backlogStack.push(text);
	}


	public void removeBacklogItem() {
		backlogStack.pop();
	}


	public String getBacklog() {
		return backlogStack.toString();
	}
	
	
	
	
	
	
	


		

	
}
