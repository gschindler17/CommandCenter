package commandCenterPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PriorityTaskPanel extends GridPane implements EventHandler<ActionEvent>{

	/**
	 * The BacklogPanel reference to the Controller
	 */
	Controller programBrains;
	
	/**
	 * TextField to add the message for the task
	 */
	TextField taskTF;
	
	/**
	 * TextField to add the priority number for the task
	 */
	TextField taskPriorityTF;
	
	/**
	 * Button to confirm the data in the TextFields of taskTF & taskPriorityTF
	 */
	Button addTaskButton;
	
	
	public PriorityTaskPanel(Controller _programBrains) {
		
		super();
		
		programBrains = _programBrains;
		
		this.setStyle("-fx-background-color: #cae3d1;");
		
		// Initializes the taskTF
		taskTF = new TextField();
		taskTF.setPrefWidth(100);
		taskTF.setPromptText("Task Message");
		
		// taskTF GridPaneConstraints
		GridPane.setConstraints(taskTF, 0, 0);
		GridPane.setMargin(taskTF, new Insets(10));
		
		
		// Initializes the taskPriorityTF
		taskPriorityTF = new TextField();
		taskPriorityTF.setPrefWidth(100);
		taskPriorityTF.setPromptText("Priority");
		
		// taskPriorityTF GridPaneConstraints
		GridPane.setConstraints(taskPriorityTF, 1, 0);
		GridPane.setMargin(taskPriorityTF, new Insets(10));
		
		
		
		// Initializes the addTaskButton and makes it clickable
		addTaskButton = new Button("Add Task"); 		
		addTaskButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(addTaskButton, 2, 0);
		GridPane.setMargin(addTaskButton, new Insets(10));
		
		
		
		
		this.getChildren().add(taskTF);
		this.getChildren().add(taskPriorityTF);
		this.getChildren().add(addTaskButton);
		
	}


	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
