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
	
	
	
	public Controller () {
		// Initializes the storageSystem
		// Type: PersistenceBackend
		storageSystem = new PersistenceBackend();
	}
	
	
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	public void reloadData() {
		// TODO Auto-generated method stub
		
	}

	
}
