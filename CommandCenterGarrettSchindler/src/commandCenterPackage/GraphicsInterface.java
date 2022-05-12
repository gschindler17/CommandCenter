package commandCenterPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * COS212 Final Project
 * "Command Center"
 * 
 * Full demonstration of concepts in Bethel University COS-212
 * Computer Science 2 - Data Structures
 * 
 *  
 * @author Garrett Schindler
 * @version Spring 2022
 *
 */


public class GraphicsInterface extends Application{
	
	/**
	 * Variable programBrains is of type Controller
	 * This handles all of the computations of the program
	 * Controller within MVC
	 */
	private Controller programBrains;
	
	/**
	 * Object that is an instance of the PersistencePanel class
	 * Holds the save and reload data buttons
	 */
	private PersistencePanel activePersistencePanel;
	
	/**
	 * Object that is an instance of the RotatingMessagePanel class
	 * Holds the message that rotates after a certain amount of time
	 * Holds the ability to add and delete messages
	 */
	private RotatingMessagePanel activeRotatingMessagePanel;
	
	/**
	 * Object that is an instance of the BacklogPanel class
	 * Holds the stack of items in the "backlog"
	 */
	private BacklogPanel activeBacklogPanel;
	
	/**
	 * Object that is an instance of the PriorityTaskPanel class
	 * Shows the priority panel
	 * Holds the ability to add and delete priority tasks
	 */
	private PriorityTaskPanel activePriorityTaskPanel;
	
	/**
	 * Object that is an instance of the RaceTheComputerPanel
	 * Holds the entire interface for the RTCP game
	 */
	private RaceTheComputerPanel activeRTCP;
	
	
	@Override
	public void start(Stage primaryStage) {
		programBrains = new Controller(this);
		try {
			// Creates the Scene
			GridPane rootGridPane = new GridPane();
			rootGridPane.setPrefSize(500, 450);
			Scene _scene = new Scene(rootGridPane, 650, 520);
			primaryStage.setScene(_scene);
			primaryStage.setTitle("Garrett Schindler's Command Center");
			
			// Instantiation
			activePersistencePanel = new PersistencePanel(programBrains);
			GridPane.setConstraints(activePersistencePanel, 0, 0);
			
			// Instantiation
			activeRotatingMessagePanel = new RotatingMessagePanel(programBrains);
			GridPane.setConstraints(activeRotatingMessagePanel, 1, 0);
			
			// Instantiation
			activeBacklogPanel = new BacklogPanel(programBrains);
			GridPane.setConstraints(activeBacklogPanel, 0, 2);	
			
			// Instantiation
			activePriorityTaskPanel = new PriorityTaskPanel(programBrains);
			GridPane.setConstraints(activePriorityTaskPanel, 1, 1);
			
			// Instantiation
			activeRTCP = new RaceTheComputerPanel(programBrains);
			GridPane.setConstraints(activeRTCP, 0, 1);
			
			// Makes sure all of the panels are up to date
			updateAll();
		
			// Adds the different panels to the rootGridPane
			rootGridPane.getChildren().add(activePersistencePanel);
			rootGridPane.getChildren().add(activeRotatingMessagePanel);
			rootGridPane.getChildren().add(activeRTCP);
			rootGridPane.getChildren().add(activePriorityTaskPanel);
			rootGridPane.getChildren().add(activeBacklogPanel);
			
			
			
			
			primaryStage.show();
			
		} catch (Exception _except) {
			_except.printStackTrace();
		}
		
	}

	/**
	 * Main method;
	 * launches the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/**
	 * Updates all of the panels
	 * Each panel has their own update method
	 */
	public void updateAll() {
		this.activePersistencePanel.update();
		this.activeRotatingMessagePanel.update();
		this.activeBacklogPanel.update();
		this.activePriorityTaskPanel.update();
		this.activeRTCP.update();
	}
}
