package commandCenterPackage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class RotatingMessagePanel extends GridPane implements EventHandler<ActionEvent>{
	
	/**
	 * The RotatingMessagePanel reference to the Controller
	 */
	private Controller programBrains;
	
	
	RotatingMessagePanel(Controller _programBrains) {
		
		super();
		
		programBrains = _programBrains;
		
//		
	}
	
	
	
	
	
	
	
	
	

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
