package coburn_problem1;

import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class CAI1 {
	private static Scanner in =
		      new Scanner(System.in);
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
	{	

		quiz();
	}
	
	//Performs the code function
	public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int num1 = random.nextInt(10);
		int num2 = random.nextInt(10);
		
		int answer = num1 * num2;
		
		boolean isCorrect = false;
		
		while(!isCorrect)
		{
			askQuestion(num1, num2);
		
			int response = readResponse();
			isCorrect = isAnswerCorrect(answer, response);
			if(!isCorrect)
				displayIncorrectResponse();
		}
		
		displayCorrectResponse();
	}
	
	//Prints the question to solve
	public static void askQuestion(int num1, int num2)
	{
		System.out.println("How much is " + num1 + " times " + num2 +"?");
	}
	
	//Reads the answer the user gives
	public static int readResponse()
	{
		int input;
		input = in.nextInt();
		return input;
	}
	
	//Determines if the user's response was correct
	public static boolean isAnswerCorrect(int answer, int response)
	{
		if(response == answer)
			return true;
		return false;
	}
	
	//Prints a message to express the user's success
	public static void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	
	//Prints a message to express the user's failure
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
}
