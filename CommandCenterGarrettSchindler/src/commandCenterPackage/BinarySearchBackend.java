package commandCenterPackage;

import java.util.Random;

public class BinarySearchBackend {

	/**
	 * The maximum value that can be guessed
	 */
	private int maxSize;
	
	/**
	 * An array that stores all of the values that are possible guesses
	 */
	private int[] binaryArray;
	
	/**
	 * The currently stored random number
	 * Gains its value from the "newRandomNumber()" method
	 */
	private int currentRN;
	
	/**
	 * The number that the user has guessed
	 */
	private int guessNumber;
	
	
	/**
	 * Constructor
	 * @param _maxSize From 0 to this integer value is the range of random numbers
	 */
	public BinarySearchBackend(int _maxSize)
	{
		guessNumber = 0;
		maxSize = _maxSize;
		binaryArray = new int[maxSize];
		newRandomNumber();
		
		// Fills binaryArray
		for (int index = 0; index < maxSize; index++)
		{
			binaryArray[index] = index;
		}
	}
	
	
	/**
	 * Sets currentRN with a new random number within the accepted range
	 */
	public void newRandomNumber() 
	{
		Random rand = new Random(); 
	    int upperbound = maxSize - 1;
	    currentRN = rand.nextInt(upperbound); 
	}
	
	/**
	 * @return the current random number
	 */
	public int getRN()
	{
		return currentRN;
	}
	
	/**
	 * Determines how many guesses it would take the computer to guess the number
	 * @return int of how many times the computer needed to guess
	 */
	public int numberOfComputerGuesses()
	{
		int min = 0; 
		int max = binaryArray.length-1;  
		int numberOfGuesses = 0;

		// Modified Binary Search that counts iterations
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

	/**
	 * @return the minimum value within the range
	 */
	public int getMinGuess() {
		return 0;		
	}

	/**
	 * @return the maximum value within the range
	 */
	public int getMaxGuess() {
		return maxSize - 1;
	}

	/**
	 * increments the guessNumber of the user
	 */
	public void incrementGuessNumber() {
		guessNumber++;
	}
	
	/**
	 * @return the current number of guesses the user has made
	 */
	public int getGuessNumber() {
		return guessNumber;
	}

	/**
	 * Resets the backend
	 * New random number; user guesses to 0
	 */
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
