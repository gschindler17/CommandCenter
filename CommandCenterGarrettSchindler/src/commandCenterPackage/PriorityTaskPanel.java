package commandCenterPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	/**
	 * Button to remove the top item in the PriorityHeap
	 */
	Button removeTaskButton;
	
	/**
	 * Label to show what the top item is in the PriorityHeap
	 */
	Label topItemLabel;
	
	
	public PriorityTaskPanel(Controller _programBrains) {
		
		super();
		
		programBrains = _programBrains;
		
		// Sets the background color of the panel
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
		GridPane.setConstraints(addTaskButton, 0, 1);
		GridPane.setMargin(addTaskButton, new Insets(10));
		
		
		// Initializes the removeTaskButton and makes it clickable
		removeTaskButton = new Button("Remove Task"); 		
		removeTaskButton.setOnAction(this);
		
		// removeTaskButton GridPaneConstraints
		GridPane.setConstraints(removeTaskButton, 1, 1);
		GridPane.setMargin(removeTaskButton, new Insets(10));
		
		// Initializes the topItemLabel
		topItemLabel = new Label(programBrains.getTopPriority());
		
		// column, row, columnSpan, rowSpan
		GridPane.setConstraints(topItemLabel, 0, 2, 3, 1);
		GridPane.setMargin(topItemLabel, new Insets(10));
		
		
		// Add all of the javafx objects to the panel
		this.getChildren().add(taskTF);
		this.getChildren().add(taskPriorityTF);
		this.getChildren().add(addTaskButton);
		this.getChildren().add(removeTaskButton);
		this.getChildren().add(topItemLabel);
		
	}


	@Override
	public void handle(ActionEvent onClick) {
		
		// When the addTaskButton is clicked
		if (onClick.getSource() == addTaskButton)
		{
			try {
				System.out.println("Adding task to PriorityTaskList");
				String receivedTask = taskTF.getText();
				taskTF.clear();
				int receivedPriority = Integer.parseInt(taskPriorityTF.getText().toString());
				programBrains.addPriorityTask(receivedTask, receivedPriority);
				topItemLabel.setText(programBrains.getTopPriority());
				programBrains.saveData();
			} catch (Exception _exception) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
		// When the removeTaskButton is clicked
		if (onClick.getSource() == removeTaskButton)
		{
			try {
				System.out.println("Removing task from PriorityTaskList");
				programBrains.deleteTopPriority();
				taskTF.clear();
				topItemLabel.setText(programBrains.getTopPriority());
				programBrains.saveData();
			} catch (Exception _exception) {
				// Pop an alert box if there is an exception
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
	    		programBrains.saveData();
			}
		}
	}


	public void update() {
		topItemLabel.setText(programBrains.getTopPriority());
		taskTF.clear();
	}
}
