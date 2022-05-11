package commandCenterPackage;


import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RotatingMessagePanel extends GridPane implements EventHandler<ActionEvent> {
	
	/**
	 * The RotatingMessagePanel reference to the Controller
	 */
	private Controller programBrains;
	
	/**
	 * Button to add a new String message to the RotatingMessagePanel
	 */
	private Button addMessageButton;
	
	/**
	 * Button to remove the current String message from the RotatingMessagePanel
	 */
	private Button removeMessageButton;
	
	/**
	 * "Textbox" for the user to type in the String message that they want to add
	 */
	private TextField messageToAddTF;
	
	/**
	 * String message that is currently shown on the panel
	 * This message rotates
	 */
	private Label shownLabel;
	
	
	RotatingMessagePanel(Controller _programBrains) {
		
		// Call to the super conductor
		super();
		
		// HEX Background color setting
		this.setStyle("-fx-background-color: #b2edc3;");
		
		// Passes the controller (programBrains) to the RotatingMessagePanel
		programBrains = _programBrains;
		
		
		addMessageButton = new Button("Add message:");
		addMessageButton.setOnAction(this);
		
		// addMessageButton GridPaneConstraints
		GridPane.setConstraints(addMessageButton, 0, 1);
		GridPane.setMargin(addMessageButton, new Insets(10));
		
		this.getChildren().add(addMessageButton);
		
		
		removeMessageButton = new Button("Remove current message");
		removeMessageButton.setOnAction(this);
		
		// removeMessageButton GridPaneConstraints
		GridPane.setConstraints(removeMessageButton, 1, 1);
		GridPane.setMargin(removeMessageButton, new Insets(10));
		
		this.getChildren().add(removeMessageButton);
		
		
		messageToAddTF = new TextField();
		messageToAddTF.setPrefWidth(150);
		messageToAddTF.setPromptText("Message to add...");
		
		// messageToAddTF GridPaneConstraints
		GridPane.setConstraints(messageToAddTF, 0, 0);
		GridPane.setMargin(messageToAddTF, new Insets(10));
		
		this.getChildren().add(messageToAddTF);
		
		
		
		// TODO Figure out how to use these values
		shownLabel = new Label(" ");
		GridPane.setConstraints(shownLabel, 1, 0);
		GridPane.setMargin(shownLabel, new Insets(10));
		
		
//		programBrains.addMessageToRMP("FIRST ITEM SHOWN");
//		programBrains.addMessageToRMP("SECOND ITEM SHOWN");
//		programBrains.addMessageToRMP("THIRD ITEM SHOWN");
//		System.out.println(programBrains.getRotatingMessages());
		
		
		this.getChildren().add(shownLabel);
			
		
		/**
		 * Timer
		 */
		Timer rotationTimer = new Timer();
		
		/**
		 * Task that the timer is going to do
		 */
		TimerTask rotationTask = new TimerTask() { 
			@Override
			public void run() {
		        
				// Crucial part so that threading does not go out of line
		        Platform.runLater(new Runnable(){

					@Override
					public void run() {
						
						// Sets the label to the new rotating message
						// programBrains.nextRotatingMessage is of type String
						shownLabel.setText(programBrains.nextRotatingMessage());
						
					}
		       
		        });
				
			};
		};
			

			
		// Timer does the scheduled task every ____ milliseconds;
		rotationTimer.schedule(rotationTask, 2000, 2000);
		
	}
	
	
	
	

	@Override
	public void handle(ActionEvent onClick) {
		if (onClick.getSource() == addMessageButton)
		{
			try {
				System.out.println("Adding Message to Rotating Message Panel");
				String receivedMessage = messageToAddTF.getText();
				programBrains.addMessageToRMP(receivedMessage);
				programBrains.saveData();
			}  catch (Exception _exception) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
			
		}
		
		if (onClick.getSource() == removeMessageButton)
		{
			
			try{
				System.out.println("Deleting Message from Rotating Message Panel");
				programBrains.removeMessageFromRMP();
				programBrains.saveData();
			}  catch (Exception _exception) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle("Something doesn't look right...");
	    		alert.setContentText(_exception.getMessage());
	    		alert.showAndWait();
			}
		}
		
	}




	public void update() {
		// Updates to the panel
	}







	
}
