package commandCenterPackage;

import java.util.Random;

public class BinarySearchBackend {

	private int maxSize;
	private int[] binaryArray;
	private int currentRN;
	private int guessNumber;
	
	
	public BinarySearchBackend(int _maxSize)
	{
		guessNumber = 0;
		maxSize = _maxSize;
		binaryArray = new int[maxSize];
		newRandomNumber();
		
		
		for (int index = 0; index < maxSize; index++)
		{
			binaryArray[index] = index;
		}
	}
	
	
	public void newRandomNumber() 
	{
		Random rand = new Random(); //instance of random class
	    int upperbound = maxSize - 1;
	    currentRN = rand.nextInt(upperbound); 
	}
	
	public int getRN()
	{
		return currentRN;
	}
	
	
	public int numberOfComputerGuesses()
	{
		int min = 0; 
		int max = binaryArray.length-1;  
		int numberOfGuesses = 0;


		while (min <= max)
		{
			numberOfGuesses++;
			int mid = (min + max) / 2;
			if (binaryArray[mid] == currentRN)
			{
				break;
			}
			else if (currentRN < binaryArray[mid])
			{
				max = mid-1;
			}
			else
			{
				min = mid+1;
			}
		}
		return numberOfGuesses;
	}
	
	
	
	
	/**
	 * Compares an integer value to what the random number is
	 * @param userGuess what the user has guessed
	 * @return 1 if parameter/guess is greater than number; 0 if equal; -1 if parameter/guess is less than random number
	 */
	public int compareUserGuessToRN(int userGuess)
	{
		if (userGuess > currentRN)
		{
			return 1;
		}
		else if (userGuess == currentRN)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}


	public int getMinGuess() {
		return 0;		
	}


	public int getMaxGuess() {
		return maxSize - 1;
	}


	public void incrementGuessNumber() {
		guessNumber++;
	}
	
	public int getGuessNumber() {
		return guessNumber;
	}


	public void reset() {
		newRandomNumber();
		guessNumber = 0;
		
	}
	
	
	
//	private int binarySearch(int[] list, int target){ 
//		int min = 0; 
//		int max = list.length-1;  
//
//
//		while (min <= max)
//		{
//			int mid = (min + max) / 2;
//			if (list[mid] == target)
//			{
//				return mid;
//			}
//			else if (target < list[mid])
//			{
//				max = mid-1;
//			}
//			else
//			{
//				min = mid+1;
//			}
//			return -1; //target is not in the array
//		}
//	
//		return -1;
//	}

}
