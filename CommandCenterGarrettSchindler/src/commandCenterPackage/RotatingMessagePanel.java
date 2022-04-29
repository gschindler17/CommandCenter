package commandCenterPackage;


import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RotatingMessagePanel extends GridPane implements EventHandler<ActionEvent> {
	
	/**
	 * The RotatingMessagePanel reference to the Controller
	 */
	private Controller programBrains;
	
	private CircularLinkedList toDisplay;
	
	private Button addMessageButton;
	
	private Button removeMessageButton;
	
	private Text addMessageText;
	
	private int messageNumber;
	
	private Label shownLabel;
	
	
	RotatingMessagePanel(Controller _programBrains) {
		
		
		super();
		
		programBrains = _programBrains;
				
		System.out.println("Started RMP Constructor");
		
		
		messageNumber = 0;
		
		shownLabel = new Label("empty");
		this.getChildren().add(shownLabel);
		
		
		
		toDisplay = programBrains.getRotatingMessages();
			// May need more brains because of immutable properties
		
		
		Timer rotationTimer = new Timer();
		TimerTask rotationTask = new TimerTask() {
			 @Override
			    public void run() {
			        programBrains.addRotatingMessages("Garrett Schindler was here");
			        toDisplay = programBrains.getRotatingMessages();
			        
			        //TODO change the label based off of the new text
			        
			        messageNumber++;
			        
			        if (messageNumber >= toDisplay.getSize())
			        {
			        	messageNumber = messageNumber %  toDisplay.getSize();
			        }
			        
			        
			        
			        System.out.println("end of run");
			        
			        
			        
			    }
			};
			
		
		
		rotationTimer.schedule(rotationTask, 2000, 2000);
		
		
		
		
		System.out.println("Finished RMP Constructor");
		
//		
	}
	
	
	
	
	
	
	
	

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}







	
}
