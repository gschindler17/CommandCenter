package commandCenterPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

public class BacklogPanel extends GridPane implements EventHandler<ActionEvent> {

	/**
	 * The BacklogPanel reference to the Controller
	 */
	Controller programBrains;
	
	/**
	 * Button to add task to the BacklogPanel
	 */
	Button addTaskButton;
	
	/**
	 * Button to remove task from the BacklogPanel
	 */
	Button removeTaskButton;
	
	/**
	 * TextField to add the message to the Backlog
	 */
	TextField backlogTF;
	
	
	
	/**
	 * Constructor for a BacklogPanel
	 * @param _programBrains Controller
	 */
	public BacklogPanel (Controller _programBrains) {
		
		super();
		
		programBrains = _programBrains;
		
		// Puts a buffer around the panel so nothing on top of each other
		this.setPadding(new Insets(5));
		
		this.setMinSize(200,100);
		
		this.setStyle("-fx-background-color: #f5fcf7;");
		
		// Initializes the backlogTF
		backlogTF = new TextField();
		backlogTF.setPrefWidth(100);
		backlogTF.setPromptText("Backlog Task");
		
		// backlogTF GridPaneConstraints
		GridPane.setConstraints(backlogTF, 2, 2);
		GridPane.setMargin(backlogTF, new Insets(10));
		
		
		// Initializes the addTaskButton and makes it clickable
		addTaskButton = new Button("+"); 		
		addTaskButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(addTaskButton, 0, 0);
		GridPane.setMargin(addTaskButton, new Insets(10));
		
		
		
		// Initializes the removeTaskButton and makes it clickable
		removeTaskButton = new Button("-"); 		
		removeTaskButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(removeTaskButton, 0, 1);
		GridPane.setMargin(removeTaskButton, new Insets(10));
		
		
		
		// Adds the buttons to the panel; this
		this.getChildren().add(addTaskButton);
		this.getChildren().add(removeTaskButton);
		this.getChildren().add(backlogTF);
	}


	@Override
	public void handle(ActionEvent onClick) {
		
		if (onClick.getSource() == addTaskButton)
		{
			System.out.println("Adding Task");
			programBrains.saveData();
		}
		if (onClick.getSource() == removeTaskButton)
		{
			System.out.println("Removing Task");
			programBrains.reloadData();
		}
		
	}
	
	
}
