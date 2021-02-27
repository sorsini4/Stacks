import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Completed and throughly tested
 * Last update: 10/05/20
 * Submitted:  10/05/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.03
 */
public class DriverP1 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StackRA<Object> itemsRA = new StackRA<Object>();
		StackSLS<Object> itemsSLS = new StackSLS<Object>();

		boolean isDone = false;
		int userAns;

		System.out.println("Each operation will be done twice, once with the StackRA class, the other with the StackSLS class.");
		System.out.println("Hello, and welcome! Please choose an option to proceed\n");

		while(!isDone) {
			System.out.print("1. Push an item onto stack\n2. Pop an item from stack\n"
					+ "3. Display top item from stack\n4. Display items in stack"
					+ "\n5. Clear stack \n6. Exit\n> ");
			
			try {
				userAns = Integer.parseInt(input.readLine());
			} 
			catch (NumberFormatException e) {
				userAns = 7;
			} 
			catch (IOException e) {
				userAns = 7;
			}

			switch(userAns) {
			case 1:
				pushIntoStack(itemsRA);
				pushIntoStack(itemsSLS);
				break;
			case 2:
				popOffStack(itemsRA);
				popOffStack(itemsSLS);
				break;
			case 3:
				displayTop(itemsRA);
				displayTop(itemsSLS);
				break;
			case 4:
				displayStack(itemsRA);
				displayStack(itemsSLS);
				break;
			case 5:
				clearStack(itemsRA);
				clearStack(itemsSLS);
				break;
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
	}

	public static void pushIntoStack(StackInterface<Object> userStack) throws IOException {
		try {
			System.out.print("Enter an item: ");
			userStack.push(input.readLine());
		}
		catch(StackException e) {
			System.out.println("There must be items in the collection!");
		}
	}

	public static void popOffStack(StackInterface<Object> userStack) {
		try {
			System.out.println("Popped the top item, " + userStack.pop() + ".");
		}
		catch(StackException e) {
			System.out.println("There must be items in the collection!");
		}
	}

	public static void displayTop(StackInterface<Object> userStack) {
		try {
			System.out.println("The top item is: " + userStack.peek());
		}
		catch(StackException e) {
			System.out.println("There must be items in the collection!");
		}
	}

	public static void displayStack(StackInterface<Object> userStack) {
		if(!userStack.isEmpty()) {
			System.out.println(userStack.toString());
		}
		else {
			System.out.println("There must be items in the collection!");
		}
	}

	public static void clearStack(StackInterface<Object> userStack) {
		try {	
			userStack.popAll();
			System.out.println("Popped all items out of the collection!");
		}
		catch(StackException e) {
			System.out.println("There must be items in the collection!");
		}
	}
}

