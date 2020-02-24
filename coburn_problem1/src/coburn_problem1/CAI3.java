package coburn_problem1;

import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class CAI3 {
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
		int num1;
		int num2;
		
		int answer;
		
		boolean isCorrect = false;
		int randresponse = random.nextInt(4);
		int numright = 0;
		
		for(int i = 0; i < 10; i++)
		{
			num1 = random.nextInt(10);
			num2 = random.nextInt(10);
			
			answer = num1 * num2;
			
			askQuestion(num1, num2);
		
			int response = readResponse();
			isCorrect = isAnswerCorrect(answer, response);
			
			
			if(!isCorrect)
				displayIncorrectResponse(randresponse);
			else
			{
				displayCorrectResponse(randresponse);
				numright++;
			}
			randresponse = random.nextInt(4);
		}
		
		double percentage = ((double)numright / 10)*100;
		
		displayCompletionMessage(percentage);
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
	public static void displayCorrectResponse(int random)
	{
		switch (random)
		{
			case 0:
				System.out.println("Very good!");
				break;
			case 1:
				System.out.println("Excellent!");
				break;
			case 2:
				System.out.println("Nice work!");
				break;
			case 3:
				System.out.println("Keep up the good work!");
				break;
			default:
				System.out.println("Very good!");
				break;
		}
	}
	
	//Prints a message to express the user's failure
	public static void displayIncorrectResponse(int random)
	{
		switch (random)
		{
			case 0:
				System.out.println("No. Please try again.");
				break;
			case 1:
				System.out.println("Wrong. Try once more.");
				break;
			case 2:
				System.out.println("Don't give up!");
				break;
			case 3:
				System.out.println("No. Keep trying.");
				break;
			default:
				System.out.println("No. Please try again.");
				break;
		}
	}
	
	//Displays the final score and a message expressing success or failure
	public static void displayCompletionMessage(double percentage)
	{
		System.out.println("Your score: "+percentage+"%");
		if(percentage >= 75)
			System.out.println("Congratulations, you are ready to go to the next level!");
		else	
			System.out.println("Please ask your teacher for extra help.");
		
	}
}
