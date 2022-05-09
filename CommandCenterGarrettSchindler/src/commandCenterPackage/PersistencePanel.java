package commandCenterPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class PersistencePanel extends GridPane implements EventHandler<ActionEvent>{

	/**
	 * Actively saves the information present to a persistent file
	 */
	protected Button SaveDataButton;
	
	/**
	 * Actively reloads the information in the persistent file 
	 * Removes data from the persistent file
	 */
	protected Button ReloadDataButton;
	
	/**
	 * The PersistencePanel reference to the Controller
	 */
	protected Controller programBrains;
	
	
	
	
	/**
	 * Default constructor
	 */
	public PersistencePanel (Controller _programBrains) {
		
		// Call to parents constructor
		super();
		
		// Initializes the Controller
		programBrains = _programBrains;
		
		// Puts a buffer around the panel so nothing on top of each other
		this.setPadding(new Insets(5));
		
		
		this.setStyle("-fx-background-color: #dff5e5;");
		
		
		// Initializes the SaveButton and makes it clickable
		SaveDataButton = new Button("Save Data"); 		
		SaveDataButton.setOnAction(this);
		
		
		// SaveDataButton GridPaneConstraints
		GridPane.setConstraints(SaveDataButton, 0, 0);
		GridPane.setMargin(SaveDataButton, new Insets(10));
		
		
		
		// Initializes the ReloadDataButton and makes it clickable
		ReloadDataButton = new Button("Reload Data"); 
		ReloadDataButton.setOnAction(this);


		// SaveDataButton GridPaneConstraints
		GridPane.setConstraints(ReloadDataButton, 1, 0);
		GridPane.setMargin(ReloadDataButton, new Insets(10));
		
	
		// Adds the buttons to the panel; this
		this.getChildren().add(SaveDataButton);
		this.getChildren().add(ReloadDataButton);
		
	}



	@Override
	public void handle(ActionEvent onClick) {
		
		if (onClick.getSource() == SaveDataButton)
		{
			try
			{
				System.out.println("Data Saved");
				programBrains.saveData();
			} catch(Exception _exception)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		if (onClick.getSource() == ReloadDataButton)
		{
			try {
				System.out.println("Data Reloaded");
				programBrains.reloadData();
			} catch(Exception _exception)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
	}
	
	protected void clear() {
		
	}



	public void update() {
		// Updates to the panel would go here
	}
	
	
}
