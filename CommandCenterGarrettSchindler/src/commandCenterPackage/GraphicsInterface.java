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
	
	private PersistencePanel activePersistencePanel;
	
	private RotatingMessagePanel activeRotatingMessagePanel;
	
	private BacklogPanel activeBacklogPanel;
	
	private PriorityTaskPanel activePriorityTaskPanel;
	
	private RaceTheComputerPanel activeRTCP;
	
	
	@Override
	public void start(Stage primaryStage) {
		programBrains = new Controller(this);
		try {
			GridPane rootGridPane = new GridPane();
			rootGridPane.setPrefSize(500, 450);
			Scene _scene = new Scene(rootGridPane, 650, 520);
			primaryStage.setScene(_scene);
			primaryStage.setTitle("Garrett Schindler's Command Center");
			
			
			activePersistencePanel = new PersistencePanel(programBrains);
			GridPane.setConstraints(activePersistencePanel, 0, 0);
			
			
			activeRotatingMessagePanel = new RotatingMessagePanel(programBrains);
			GridPane.setConstraints(activeRotatingMessagePanel, 1, 0);
			
			
			activeBacklogPanel = new BacklogPanel(programBrains);
			GridPane.setConstraints(activeBacklogPanel, 0, 2);	
			
			
			activePriorityTaskPanel = new PriorityTaskPanel(programBrains);
			GridPane.setConstraints(activePriorityTaskPanel, 1, 1);
			
			
			activeRTCP = new RaceTheComputerPanel(programBrains);
			GridPane.setConstraints(activeRTCP, 0, 1);
			
		
			updateAll();
		
			
			rootGridPane.getChildren().add(activePersistencePanel);
			rootGridPane.getChildren().add(activeRotatingMessagePanel);
			rootGridPane.getChildren().add(activeBacklogPanel);
			rootGridPane.getChildren().add(activePriorityTaskPanel);
			rootGridPane.getChildren().add(activeRTCP);
			
			
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
	
	
	
	public void updateAll() {
		this.activePersistencePanel.update();
		this.activeRotatingMessagePanel.update();
		this.activeBacklogPanel.update();
		this.activePriorityTaskPanel.update();
		this.activeRTCP.update();
	}
}
