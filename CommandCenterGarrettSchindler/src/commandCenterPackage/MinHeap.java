package commandCenterPackage;

import java.util.ArrayList;

public class MinHeap <T>{

	private int[] heapArray;
	private int heapSize;
	private int maxSize;
	
	public MinHeap(int _maxSize) {
		maxSize = _maxSize;
		heapSize = 0;
		
		heapArray = new int[maxSize + 1];
		heapArray[0] = 0;
	
	}
	
	
	private int parent(int index)
	{
		return index / 2;
	}
	
	private int leftChild(int index)
	{
		return index * 2;
	}
	
	private int rightChild(int index)
	{
		return (2 * index) + 1;
	}
	
	private void swap(int firstIndex, int secondIndex)
	{
		int temp;
		temp = heapArray[firstIndex];
		
		heapArray[firstIndex] = heapArray[secondIndex];
		heapArray[secondIndex] = temp;
	}
	
	
	public void loadInData(String loadedString) {
		int count = 0;
		String temp = loadedString;
		ArrayList<String> entries = new ArrayList<String> ();
		
		
		count = countChar(temp, ',');
		
		for(int i = 0; i < count; i++)
		{
			entries.add(temp.substring(0, temp.indexOf(',')));
			temp = temp.substring(temp.indexOf(',') + 2, temp.length());
		}
		
		
		this.clear();
		
		for (String entry: entries)
		{
			
			this.add((T)entry);
		}
		
	}
	
	private void add(T entry) {
		// TODO Auto-generated method stub
		
	}

	private void clear() {
		
		
	}

	private static int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }

	    return count;
	}
		
	}

}
