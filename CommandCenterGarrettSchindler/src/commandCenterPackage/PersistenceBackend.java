package commandCenterPackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceBackend {
	
	
	private CircularLinkedList<String> RotatingMessageList;
	
	private MinHeap<String> PriorityMinHeap;
	
	private Stack<String> BacklogStack;
	
	private FileWriter writer;
	
	private File outputFile;
	
	
	
	public PersistenceBackend (CircularLinkedList<String> _circularLinkedList, MinHeap _minHeap, Stack<String> _stack) {
		RotatingMessageList = _circularLinkedList;
		PriorityMinHeap = _minHeap;
		BacklogStack = _stack;
		
		
		System.out.println("IN CONSTRUCTOR");	
		
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("DataStoringFile.txt"));

			
			writer.append(RotatingMessageList.toString() + "\n");
			writer.append(PriorityMinHeap.toString()  + "\n");
			writer.append(BacklogStack.toString()  + "\n");
			writer.flush();
			writer.close();
			
		} catch (IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN PERSISTENCE BACKEND");
		}
		
		
				
	}
		

	public void saveData() {
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("DataStoringFile.txt"));

			writer.append(RotatingMessageList.toString() + "\n");
			writer.append(PriorityMinHeap.toString() + "\n");
			writer.append(BacklogStack.toString() + "\n");
			writer.flush();
			writer.close();
			
			
			this.loadInData();
			
			
		} catch (IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN SAVEDATA PERSISTENCE BACKEND");
		}
		
		
	}

	public void reloadData() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void loadInData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("DataStoringFile.txt"));
			
			String line = "";
			StringBuilder content = new StringBuilder();
			
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
			if ((line = reader.readLine()) != null)
			{
				content.append(line);
				System.out.println("PriorityMinHeap: " + content);
				PriorityMinHeap.loadInData(content.toString());
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
		
		} catch(IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN LOADINDATA PERSISTENCE BACKEND");
		}
	}
	
	

}
