package commandCenterPackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceBackend {
	
	
	private CircularLinkedList<String> RotatingMessageList;
	
	private MinHeap PriorityMinHeap;
	
	private Stack<String> BacklogStack;
	
	private File outputFile;
	
	
	
	public PersistenceBackend (CircularLinkedList<String> _circularLinkedList, MinHeap _minHeap, Stack<String> _stack) {
		RotatingMessageList = _circularLinkedList;
		PriorityMinHeap = _minHeap;
		BacklogStack = _stack;
		outputFile = new File("DataStoringFile.txt");
			
		
		loadInData();		
		
				
	}
		

	public void saveData() {
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

			writer.append(RotatingMessageList.toString() + "\n");
			writer.append(PriorityMinHeap.allMessages() + "\n");
			writer.append(PriorityMinHeap.allPriorities() + "\n");
			writer.append(BacklogStack.toString() + "\n");
			writer.flush();
			writer.close();
			
			
			this.loadInData();
			
			
		} catch (IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN SAVEDATA PERSISTENCE BACKEND");
		}
		
		
	}

	public void reloadData() {
			try {
				PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

				writer.append("\n");
				writer.append("\n");
				writer.append("\n");
				writer.append("\n");
				writer.flush();
				writer.close();
				
				
				this.loadInData();
				
				
			} catch (IOException _exception) {
				System.out.println("THERE'S AN IO EXCEPTION IN SAVEDATA PERSISTENCE BACKEND");
			}
	}
		
	
	
	@SuppressWarnings("resource")
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
