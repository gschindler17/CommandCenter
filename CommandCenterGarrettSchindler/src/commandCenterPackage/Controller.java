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
	
	/**
	 * Object that handles the BackLog data
	 * Type: Stack
	 */
	private Stack<String> backlogStack;
	
	/**
	 * Object that handles the BinarySearch Backend
	 * Type: BinarySearchBackend
	 */
	private BinarySearchBackend BSBackend;
	
	/**
	 * Object that handles the graphics interface
	 * Type: GraphicsInterface
	 */
	private GraphicsInterface graphicsInterface;
	
	
	
	
	
	/**
	 * Constructor
	 * @param _graphicsInterface passed this in so controller can access all items
	 */
	public Controller(GraphicsInterface _graphicsInterface) {
		
		this.graphicsInterface = _graphicsInterface;
		
		rotatingMessages = new CircularLinkedList<String> ();
		priorityMinHeap = new MinHeap (100);
		backlogStack = new Stack<String> ();
		BSBackend = new BinarySearchBackend(100);
		
		storageSystem = new PersistenceBackend(rotatingMessages, priorityMinHeap, backlogStack);
		
		
	}
	
	/**
	 * Saves the data to the persistence system
	 */
	public void saveData() {
		storageSystem.saveData();
		graphicsInterface.updateAll();
		
	}
	
	/**
	 * Loads the data from the persistence system
	 */
	public void loadData() {
		storageSystem.loadInData();
		graphicsInterface.updateAll();
	}

	/**
	 * Reloads all of the data in the persistence system
	 */
	public void reloadData() {
		storageSystem.reloadData();
		graphicsInterface.updateAll();
		
	}


	/**
	 * Gets the next message to be displayed
	 * @return type String
	 */
	public String nextRotatingMessage() {
		return rotatingMessages.next();
	}


	/**
	 * Adds a message to the RMP
	 * @param messageToAdd is of type String
	 */
	public void addMessageToRMP(String messageToAdd) {
		rotatingMessages.add(messageToAdd);
		
	}


	/**
	 * Removes the message from the RMP
	 */
	public void removeMessageFromRMP() {
		rotatingMessages.deleteCurrent();
		
	}


	/**
	 * Adds a priority task to the priorityMinHeap
	 * @param receivedTask task to be added
	 * @param receivedPriority task's priority
	 */
	public void addPriorityTask(String receivedTask, int receivedPriority) {
		priorityMinHeap.add(receivedTask, receivedPriority);
		
	}


	/**
	 * Grabs the top item in the minHeap
	 * @return String of top item
	 */
	public String getTopPriority() {
		return priorityMinHeap.topPriority();
	}

	/**
	 * Deletes the top item in the minHeap
	 */
	public void deleteTopPriority() {
		priorityMinHeap.delete();
		
	}

	/**
	 * Gets the minimum value in BS range
	 * @return int
	 */
	public int minBSVal() {
		return BSBackend.getMinGuess();
	}
	
	/**
	 * Gets the maximum value in BS range
	 * @return int
	 */
	public int maxBSVal() {
		return BSBackend.getMaxGuess();
	}


	/**
	 * Compares the user's guess to the current Random number
	 * @param _guess int of the user's guess
	 * @return -1, 0, 1
	 */
	public int compareBSGuess(int _guess) {
		return BSBackend.compareUserGuessToRN(_guess);
	}

	/**
	 * Increases the number of guesses the user has made
	 */
	public void incrementGuessNumber() {
		BSBackend.incrementGuessNumber();
		
	}


	/**
	 * 
	 * @return the number of times the user has guessed
	 */
	public int getGuessNumber() {
		return BSBackend.getGuessNumber();
	}


	/**
	 * 
	 * @return what the binary search random number is
	 */
	public int getBSNumber() {
		return BSBackend.getRN();
	}


	/**
	 * 
	 * @return how many times the computer had to guess to correctly find the RN
	 */
	public int getBSComputerGuesses() {
		return BSBackend.numberOfComputerGuesses();
	}
	
	/**
	 * Resets the BS backend
	 */
	public void resetBSBackend() {
		BSBackend.reset();
	}

	
	/**
	 * Adds an item to the backlog
	 * @param text
	 */
	public void addBacklogItem(String text) {
		backlogStack.push(text);
	}


	/**
	 * removes an item from the backlog
	 */
	public void removeBacklogItem() {
		backlogStack.pop();
	}


	/**
	 * 
	 * @return all of the items in the backlogStack in their string format
	 */
	public String getBacklog() {
		return backlogStack.toString();
	}
	
	
	
	
	
	
	
	
	
	


		

	
}
