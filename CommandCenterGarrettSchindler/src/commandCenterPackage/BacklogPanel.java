package commandCenterPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	 * Displays the contents of the BacklogStack
	 */
	Label backlogLabel;
	
	
	
	/**
	 * Constructor for a BacklogPanel
	 * @param _programBrains Controller
	 */
	public BacklogPanel (Controller _programBrains) {
		
		super();
		
		
		programBrains = _programBrains;
		
		// Puts a buffer around the panel so nothing on top of each other
		this.setPadding(new Insets(5));
		
		// Sets the color of the panel
		this.setStyle("-fx-background-color: #afe0b4;");
		
		
		// Initializes the backlogLabel
		backlogLabel = new Label("Add item to backlog...");
		backlogLabel.setPrefWidth(150);
		backlogLabel.setMinHeight(140);
		backlogLabel.setMaxHeight(140);
		GridPane.setConstraints(backlogLabel, 1, 0);
		GridPane.setMargin(backlogLabel, new Insets(10));
		
		
		
		// Initializes the backlogTF
		backlogTF = new TextField();
		backlogTF.setPrefWidth(100);
		backlogTF.setPromptText("Backlog Task");
		
		// backlogTF GridPaneConstraints
		GridPane.setConstraints(backlogTF, 1, 1);
		GridPane.setMargin(backlogTF, new Insets(10));
		
		
		// Initializes the addTaskButton and makes it clickable
		addTaskButton = new Button(" + "); 	
		addTaskButton.setPrefWidth(40);
		addTaskButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(addTaskButton, 2, 1);
		GridPane.setMargin(addTaskButton, new Insets(10));
		
		
		
		// Initializes the removeTaskButton and makes it clickable
		removeTaskButton = new Button(" - "); 	
		removeTaskButton.setPrefWidth(40);
		removeTaskButton.setOnAction(this);
		
		// removeTaskButton GridPaneConstraints
		GridPane.setConstraints(removeTaskButton, 0, 1);
		GridPane.setMargin(removeTaskButton, new Insets(10));
		
		
		
		// Adds the buttons to the panel; this
		this.getChildren().add(backlogLabel);
		this.getChildren().add(addTaskButton);
		this.getChildren().add(removeTaskButton);
		this.getChildren().add(backlogTF);
	}


	@Override
	public void handle(ActionEvent onClick) {
		
		// If the addTaskButton is clicked
		if (onClick.getSource() == addTaskButton)
		{
			try {
				
				System.out.println("Adding Backlog Task");
				String textToAdd = backlogTF.getText();
				
				// If the user doesn't add any data, throw an exception
				if (textToAdd == "" || textToAdd == null)
				{
					throw new IllegalArgumentException("No backlog task entered!");
				}
				
				programBrains.addBacklogItem(textToAdd);
				updateLabel();
				backlogTF.clear();
				programBrains.saveData();
				
				
			} catch(Exception _exception)
			{
				// Throws alert to the GUI
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
		// If the removeTaskButton is clicked
		if (onClick.getSource() == removeTaskButton)
		{
			try {
				System.out.println("Removing Backlog Task");
				programBrains.removeBacklogItem();
				updateLabel();
				backlogTF.clear();
				programBrains.saveData();
				
				
			} catch(Exception _exception)
			{
				// Throws an alert to the GUI
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
	}


	/**
	 * Determines what the label to be shown should be
	 */
	private void updateLabel() {
		
		String newLabelText = "";
		String stackToString = programBrains.getBacklog();
		
		int entries = countChar(stackToString, ',');
		
		for (int i = 0; i < entries; i++)
		{
			newLabelText = newLabelText + stackToString.substring(0, stackToString.indexOf(',')) + "\n";
			stackToString = stackToString.substring(stackToString.indexOf(',') + 2, stackToString.length());
			
		}
		
		// Sets the backlogLabel to what it should show
		backlogLabel.setText(newLabelText);
	}
	
	/**
	 * Counts the # of times a character occurs in a string
	 * @param str entered String
	 * @param c character that is counted
	 * @return # of times character occurs in string
	 */
	private static int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }

	    return count;
	}


	/**
	 * Updates the panel
	 * Allows an external object to force this panel to update itself
	 */
	public void update() {
		updateLabel();
		backlogTF.clear();
	}
	
	
	
	
}
