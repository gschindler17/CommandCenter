package commandCenterPackage;

import java.awt.Cursor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RaceTheComputerPanel extends VBox implements EventHandler<ActionEvent> {


		/**
		 * The RaceTheComputerPanel reference to the Controller
		 */
		Controller programBrains;
		
		
		/**
		 * Prompts what the range of the guess can be in
		 */
		Label rangeLabel;
		
		/**
		 * Prompts for the user's guess
		 */
		Label userGuessPromptLabel;
		
		/**
		 * To add the user's guess of what the number is
		 * TextField
		 */
		TextField userGuessTF;
		
		/**
		 * Submits the user's guess
		 */
		Button submitButton;
		
		/**
		 * Displays the count of how many times the user has guessed
		 */
		Label guessCounterLabel;
		
		/**
		 * Responds to whether the user's number is correct, higher, or lower
		 */
		Label responseToGuessLabel;
		
		/**
		 * Displays the correct number
		 */
		Label correctNumberLabel;
		
		/**
		 * Displays the number of computer guesses
		 */
		Label computerGuessesLabel;
		
		
		/**
		 * New number; reset button
		 */
		Button resetNumber;
		
		
		
		
		public RaceTheComputerPanel(Controller _programBrains) {
			
			super();
			
			programBrains = _programBrains;
			
			this.setStyle("-fx-background-color: #73db66;");
			// Puts a buffer around the panel
			this.setPadding(new Insets(10));
			
			rangeLabel = new Label("I have a number between " + programBrains.minBSVal() + " and " + programBrains.maxBSVal());
			userGuessPromptLabel = new Label("Guess my number: ");
			userGuessTF = new TextField();
			userGuessTF.setPromptText("value");
			submitButton = new Button("Guess");
			submitButton.setOnAction(this);
			guessCounterLabel = new Label("Number of guesses: 0");
			responseToGuessLabel = new Label("Waiting for your guess");
			correctNumberLabel = new Label("My number was: " + programBrains.getBSNumber());
			computerGuessesLabel = new Label("The computer guessed my number in " + programBrains.getBSComputerGuesses() + " guesses");
			resetNumber = new Button("RESET");
			resetNumber.setOnAction(this);
			
			
			correctNumberLabel.setVisible(false);
			computerGuessesLabel.setVisible(false);
			
			
			
			
			
			
			this.getChildren().add(rangeLabel);
			this.getChildren().add(userGuessPromptLabel);
			this.getChildren().add(userGuessTF);
			this.getChildren().add(submitButton);
			this.getChildren().add(guessCounterLabel);
			this.getChildren().add(responseToGuessLabel);
			this.getChildren().add(correctNumberLabel);
			this.getChildren().add(computerGuessesLabel);
			this.getChildren().add(resetNumber);
			
		}


		private String getComparison(int _guess) {
			int comparisonValue = programBrains.compareBSGuess(_guess);
			
			if (comparisonValue == 1)
			{
				return "greater than";
			}
			if (comparisonValue == 0)
			{
				return "EXACTLY EQUAL to";
			}
			else
			{
				return "less than";
			}
		}


		@Override
		public void handle(ActionEvent onClick) {
			if (onClick.getSource() == submitButton)
			{
				try 
				{
					System.out.println("Submitting guess");
					int receivedGuess = Integer.parseInt(userGuessTF.getText());
					userGuessTF.clear();
					userGuessTF.setPromptText(receivedGuess + "");
					programBrains.incrementGuessNumber();
					responseToGuessLabel.setText("Your guess was " + this.getComparison(receivedGuess) + " my number");
					guessCounterLabel.setText("Number of guesses: " + programBrains.getGuessNumber());
					
					if (programBrains.compareBSGuess(receivedGuess) == 0)
					{
						correctNumberLabel.setVisible(true);
						computerGuessesLabel.setVisible(true);
					}
					
					Platform.runLater(new Runnable() {

			            @Override
			            public void run() {
			                userGuessTF.requestFocus();
			            }
			        });
					
				} catch(Exception _exception)
				{
					Alert alert = new Alert(Alert.AlertType.ERROR);
		    		alert.setTitle("Something doesn't look right...");
		    		alert.setContentText(_exception.getMessage());
		    		alert.showAndWait();
				}
				
			}
			
			if (onClick.getSource() == resetNumber)
			{
				try
				{
					reset();
				} catch(Exception _exception)
				{
					Alert alert = new Alert(Alert.AlertType.ERROR);
		    		alert.setTitle("Something doesn't look right...");
		    		alert.setContentText(_exception.getMessage());
		    		alert.showAndWait();
				}
			}
		}

		/**
		 * Updates the RaceTheComputerPanel
		 */
		public void update() {
			reset();
		}
		
		
		private void reset() {
			programBrains.resetBSBackend();
			userGuessTF.clear();
			rangeLabel.setText("I have a number between " + programBrains.minBSVal() + " and " + programBrains.maxBSVal());
			guessCounterLabel.setText("Number of guesses: 0");
			responseToGuessLabel.setText("Waiting for your guess");
			correctNumberLabel.setText("My number was: " + programBrains.getBSNumber());
			computerGuessesLabel.setText("The computer guessed my number in " + programBrains.getBSComputerGuesses() + " guesses");
			correctNumberLabel.setVisible(false);
			computerGuessesLabel.setVisible(false);
		}
	}

