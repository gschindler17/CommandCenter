package commandCenterPackage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceBackend {
	
	
	private CircularLinkedList<String> RotatingMessageList;
	
	private MinHeap PriorityMinHeap;
	
	private Stack<String> BacklogStack;
	
	private FileWriter writer;
	
	private File outputFile;
	
	
	
	public PersistenceBackend (CircularLinkedList<String> _circularLinkedList, MinHeap _minHeap, Stack<String> _stack) {
		RotatingMessageList = _circularLinkedList;
		PriorityMinHeap = _minHeap;
		BacklogStack = _stack;
		
		
		System.out.println("IN CONSTRUCTOR");	
		
		
		try {
			File output = new File("garbageFile.txt");
			PrintWriter writer = new PrintWriter(new FileWriter("DataStoringFile.txt"));

			System.out.println(RotatingMessageList.toString());
			
			writer.write("Overwritten?");
			writer.append(RotatingMessageList.toString());
			writer.append("\nTHIS IS CONTENT");
			writer.append(PriorityMinHeap.toString());
			writer.append(BacklogStack.toString());
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
			
		} catch (IOException _exception) {
			System.out.println("THERE'S AN IO EXCEPTION IN PERSISTENCE BACKEND");
		}
		
		
	}

	public void reloadData() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void loadInData() {
		
	}

}
