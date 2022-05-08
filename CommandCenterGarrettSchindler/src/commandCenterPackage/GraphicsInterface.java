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
	private Controller programBrains = new Controller();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane rootGridPane = new GridPane();
			rootGridPane.setPrefSize(500, 400);
			Scene _scene = new Scene(rootGridPane, 1000, 500);
			primaryStage.setScene(_scene);
			primaryStage.setTitle("Garrett Schindler's Command Center");
			
			
			PersistencePanel activePersistencePanel = new PersistencePanel(programBrains);
			GridPane.setConstraints(activePersistencePanel, 0, 0);
			rootGridPane.getChildren().add(activePersistencePanel);
			
			RotatingMessagePanel activeRotatingMessagePanel = new RotatingMessagePanel(programBrains);
			GridPane.setConstraints(activeRotatingMessagePanel, 2, 0);
			rootGridPane.getChildren().add(activeRotatingMessagePanel);
			
			BacklogPanel activeBacklogPanel = new BacklogPanel(programBrains);
			GridPane.setConstraints(activeBacklogPanel, 1, 0);
			rootGridPane.getChildren().add(activeBacklogPanel);
			
			
			
			PriorityTaskPanel activePriorityTaskPanel = new PriorityTaskPanel(programBrains);
			GridPane.setConstraints(activePriorityTaskPanel, 2, 1);
			rootGridPane.getChildren().add(activePriorityTaskPanel);
			
			RaceTheComputerPanel activeRTCP = new RaceTheComputerPanel(programBrains);
			GridPane.setConstraints(activeRTCP, 0, 1);
			rootGridPane.getChildren().add(activeRTCP);
			
			programBrains.saveData();
			
			
			
			/*
			 * TODO
			 * Add elements to GridPane in correct locations
			 */
			
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
}
