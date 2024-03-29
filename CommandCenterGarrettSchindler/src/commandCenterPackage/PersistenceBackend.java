package commandCenterPackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceBackend {
	
	/**
	 * Imports the RotatingMessageList so that it can load in the data
	 */
	private CircularLinkedList<String> RotatingMessageList;
	
	/**
	 * Imports the PriorityMinHeap so that it can load in the data
	 */
	private MinHeap PriorityMinHeap;
	
	/**
	 * Imports the BacklogStack so that it can load in the data
	 */
	private Stack<String> BacklogStack;
	
	/**
	 * Holds the File where all of the information is to be stored
	 */
	private File outputFile;
	
	
	/**
	 * Constructor
	 * Initializes all of the data
	 * @param _circularLinkedList
	 * @param _minHeap
	 * @param _stack
	 */
	public PersistenceBackend (CircularLinkedList<String> _circularLinkedList, MinHeap _minHeap, Stack<String> _stack) {
		
		// Stores to attributes
		RotatingMessageList = _circularLinkedList;
		PriorityMinHeap = _minHeap;
		BacklogStack = _stack;
		outputFile = new File("DataStoringFile.txt");
			
		// Fills the attributes from the persistentFile
		loadInData();		
				
	}
		

	/**
	 * All of the data is stored to the saved outputFile
	 * Multiple lines, each line is later read back into the file when "loadData()" is called
	 */
	public void saveData() {
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

			writer.append(RotatingMessageList.toString() + "\n");
			writer.append(PriorityMinHeap.allMessages() + "\n");
			writer.append(PriorityMinHeap.allPriorities() + "\n");
			writer.append(BacklogStack.toString() + "\n");
			writer.flush();
			writer.close();
			
			// Loads the data back into the GUI
			this.loadInData();
			
			
		} catch (IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN SAVEDATA PERSISTENCE BACKEND");
		}
		
		
	}

	/**
	 * Clears out all of the data saved in the persistence file
	 * Empties everything out
	 */
	public void reloadData() {
			try {
				PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

				writer.append("\n");
				writer.append("\n");
				writer.append("\n");
				writer.append("\n");
				writer.flush();
				writer.close();
				
				// Loads the data back into the GUI
				this.loadInData();
				
				
			} catch (IOException _exception) {
				System.out.println("THERE'S AN IO EXCEPTION IN SAVEDATA PERSISTENCE BACKEND");
			}
	}
		
	
	
	/**
	 * Data from the persistence file is brought back into the GUI
	 * Reading from a text file
	 */
	public void loadInData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(outputFile));
			
			String line = "";
			StringBuilder content = new StringBuilder();
			StringBuilder content2 = new StringBuilder();
			
			if ((line = reader.readLine()) != null)
			{
				content.append(line);
				System.out.println("RotatingMessageList: " + content);
				RotatingMessageList.loadInData(content.toString());
			}
			else 
			{
				throw new IOException("uh oh... no RotatingMessageList to load");
			}
			
			content = new StringBuilder();
			content2 = new StringBuilder();
			if ((line = reader.readLine()) != null)
			{
				content.append(line);
				line = reader.readLine();
				content2.append(line);
				System.out.println("PriorityMinHeap: " + content + content2);
				PriorityMinHeap.loadInData(content.toString(), content2.toString());
			}
			else 
			{
				throw new IOException("uh oh... no PriorityMinHeap to load");
			}
			
			content = new StringBuilder();
			if ((line = reader.readLine()) != null)
			{
				content.append(line);
				System.out.println("BacklogStack: " + content);
				BacklogStack.loadInData(content.toString());
			}
			else 
			{
				throw new IOException("uh oh... no PriorityMinHeap to load");
			}
			
			reader.close();
			
		
		} catch(IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN LOADINDATA PERSISTENCE BACKEND");
		}
	}
	
	

}
