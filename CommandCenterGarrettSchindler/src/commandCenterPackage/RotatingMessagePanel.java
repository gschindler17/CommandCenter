package commandCenterPackage;


import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class RotatingMessagePanel extends GridPane implements EventHandler<ActionEvent>, Runnable {
	
	/**
	 * The RotatingMessagePanel reference to the Controller
	 */
	private Controller programBrains;
	
	private CircularLinkedList toDisplay;
	
	
	RotatingMessagePanel(Controller _programBrains) {
		
		
		super();
		
		programBrains = _programBrains;
				
		System.out.println("Started RMP Constructor");
		
		
		
		toDisplay = new CircularLinkedList();
		
		// toDisplay = programBrains.getRotatingMessages()
			// May need more brains because of immutable properties
		
		Timer rotationTimer = new Timer();
		TimerTask rotationTask = new TimerTask() {
			 @Override
			    public void run() {
			        System.out.println("in rotation");
			        
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



	
	
	public void start() {
		System.out.println("Starting thread");
		
		Thread startThread = new Thread(this, "NamedThread");
		startThread.start();
	}
	
	
	@Override
	public void run() {
		System.out.println("This is running");
		
	}
	
	
	
}
