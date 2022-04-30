package commandCenterPackage;


import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	
	private Button addMessageButton;
	
	private Button removeMessageButton;
	
	private TextField messageToAddTF;
	
	private Label shownLabel;
	
	
	RotatingMessagePanel(Controller _programBrains) {
		
		
		super();
		
		programBrains = _programBrains;
		
		
		addMessageButton = new Button("Add message:");
		addMessageButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(addMessageButton, 2, 0);
		GridPane.setMargin(addMessageButton, new Insets(10));
		
		this.getChildren().add(addMessageButton);
		
		
		removeMessageButton = new Button("Remove current message");
		removeMessageButton.setOnAction(this);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(removeMessageButton, 2, 1);
		GridPane.setMargin(removeMessageButton, new Insets(10));
		
		this.getChildren().add(removeMessageButton);
		
		
		messageToAddTF = new TextField();
		messageToAddTF.setPrefColumnCount(20);
		
		// addTaskButton GridPaneConstraints
		GridPane.setConstraints(messageToAddTF, 3, 0);
		GridPane.setMargin(removeMessageButton, new Insets(10));
		
		this.getChildren().add(messageToAddTF);
		
		
		
		// TODO Figure out how to use these values
		shownLabel = new Label("STARTING PROCESSES...");
		programBrains.addMessageToRMP("FIRST ITEM SHOWN");
		programBrains.addMessageToRMP("SECOND ITEM SHOWN");
		programBrains.addMessageToRMP("THIRD ITEM SHOWN");
		
		System.out.println(programBrains.getRotatingMessages());
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
		
		
//		
	}
	
	
	
	
	
	
	
	

	@Override
	public void handle(ActionEvent onClick) {
		if (onClick.getSource() == addMessageButton)
		{
			System.out.println("Adding Message to Rotating Message Panel");
			
			String receivedMessage = messageToAddTF.getText();
			
			programBrains.addMessageToRMP(receivedMessage);
			
			
		}
		
		if (onClick.getSource() == removeMessageButton)
		{
			System.out.println("Deleting Message from Rotating Message Panel");
			
			programBrains.removeMessageFromRMP();
		}
		
	}







	
}
