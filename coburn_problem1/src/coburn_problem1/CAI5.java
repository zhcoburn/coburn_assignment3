package coburn_problem1;

import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class CAI5 {
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
		
		int answer;
		
		boolean isCorrect = false;
		int randresponse = random.nextInt(4);
		int numright = 0;
		int difficulty;
		int problemType;
		
		System.out.println("Please specify a difficulty between 1 and 4. (Easiest - 1, Hardest - 4)");
		
		difficulty = readDifficulty();
		
		System.out.println("Please choose what set of problems you'd like to solve.");
		System.out.println("[1 - Addition]");
		System.out.println("[2 - Multiplication]");
		System.out.println("[3 - Subtraction]");
		System.out.println("[4 - Division]");
		System.out.println("[5 - All]");
		
		problemType = readProblemType();
		
		int range = 1;
		for(int i = 0; i < difficulty; i++)
			range = range * 10;
		
		for(int i = 0; i < 10; i++)
		{
			answer = generateQuestionArgument(range, problemType, random);
		
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
	
	//Returns the difficulty value set by the user
	public static int readDifficulty()
	{
		boolean isValid = false;
		int input = 1;
		while(!isValid)
		{
			input = in.nextInt();
			if(input<5 && input > 0)
				isValid = true;
			else
				System.out.println("Invalid response. Please try again.");
		}
		return input;
	}
	
	public static int readProblemType()
	{
		boolean isValid = false;
		int input = 1;
		while(!isValid)
		{
			input = in.nextInt();
			if(input<6 && input > 0)
				isValid = true;
			else
				System.out.println("Invalid response. Please try again.");
		}
		return input;
	}
	
	//Generates a problem based on the difficulty level specified, returns the valid answer
	public static int generateQuestionArgument(int range, int type, SecureRandom random)
	{	
		int num1 = random.nextInt(range);
		int num2 = random.nextInt(range);
		int answer;
		int question = type;
		
		switch (type)
		{
			case 1:
				answer = num1 + num2;
				break;
			case 2:
				answer = num1 * num2;
				break;
			case 3:
				answer = num1 - num2;
				break;
			case 4:
				answer = num1 / num2;
				break;
			case 5:
				question = random.nextInt(4) + 1;
				switch (question)
				{
					case 1:
						answer = num1 + num2;
						break;
					case 2:
						answer = num1 * num2;
						break;
					case 3:
						answer = num1 - num2;
						break;
					case 4:
						answer = num1 / num2;
						break;
					default:
						answer = num1 * num2;
						break;
				}
				break;
			default:
				answer = num1 * num2;
				break;
		}
		askQuestion(num1, num2, question);
		
		return answer;
	}
	
	//Prints the question to solve
	public static void askQuestion(int num1, int num2, int type)
	{
		switch (type)
		{
			case 1:
				System.out.println("How much is " + num1 + " plus " + num2 +"?");
				break;
			case 2:
				System.out.println("How much is " + num1 + " times " + num2 +"?");
				break;
			case 3:
				System.out.println("How much is " + num1 + " minus " + num2 +"?");
				break;
			case 4:
				System.out.println("How much is " + num1 + " divided by " + num2 +"?");
				break;
			default:
				System.out.println("How much is " + num1 + " times " + num2 +"?");
				break;
		}
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