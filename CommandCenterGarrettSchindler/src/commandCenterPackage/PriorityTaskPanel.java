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
		
		
		// Initializes the addTaskButton and makes it clickable
		removeTaskButton = new Button("Remove Task"); 		
		removeTaskButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(removeTaskButton, 1, 1);
		GridPane.setMargin(removeTaskButton, new Insets(10));
		
		
		topItemLabel = new Label(programBrains.getTopPriority());
		GridPane.setConstraints(topItemLabel, 2, 1);
		GridPane.setMargin(topItemLabel, new Insets(10));
		
		
		this.getChildren().add(removeTaskButton);
		this.getChildren().add(topItemLabel);
		this.getChildren().add(taskTF);
		this.getChildren().add(taskPriorityTF);
		this.getChildren().add(addTaskButton);
		
	}


	@Override
	public void handle(ActionEvent onClick) {
		if (onClick.getSource() == addTaskButton)
		{
			try {
				System.out.println("Adding task to PriorityTaskList");
				String receivedTask = taskTF.getText();
				int receivedPriority = Integer.parseInt(taskPriorityTF.getText().toString());
				programBrains.addPriorityTask(receivedTask, receivedPriority);
				topItemLabel.setText(programBrains.getTopPriority());
			} catch (Exception _exception) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
		if (onClick.getSource() == removeTaskButton)
		{
			try {
				System.out.println("Removing task from PriorityTaskList");
				programBrains.deleteTopPriority();
				topItemLabel.setText(programBrains.getTopPriority());
			} catch (Exception _exception) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
	}
}
