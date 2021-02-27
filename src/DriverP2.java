import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Completed
 * Last update: 10/13/20
 * Submitted:  10/13/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.09
 */
public class DriverP2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		StackRA<Package> packages = new StackRA<Package>();
		StackSLS<Item> samples = new StackSLS<Item>();

		boolean isDone = false;
		int userAns;

		System.out.println("Hello, and welcome! Please choose an option to proceed\n");
		
		System.out.print("1. Pick up an order\n2. Drop off an order\n3. Display number of packages and weight of bag\n");
		System.out.print("4. Display number of items and weight of bag of samples\n5. Enjoy an item from bag of samples");
		System.out.print("\n6. Enjoy all the samples in a bag of samples\n\n");
		
		while(!isDone) {

			System.out.print("You know the options. Enter a number to proceed\n> ");
			
			try {
				userAns = Integer.parseInt(input.readLine());
			} 
			catch (NumberFormatException e) {
				userAns = 10;
			} 
			catch (IOException e) {
				userAns = 10;
			}

			System.out.print(userAns + "\n");
						
			switch(userAns) {
			case 0:
				System.out.println("\nGoodbye!");
				isDone = true;
				break;
			case 1:
				pickUpOrder(packages);
				break;
			case 2:
				dropOffOrder(packages, samples);
				break;
			case 3:
				displayPackages(packages);
				break;
			case 4:
				displaySamples(samples);
				break;
			case 5:
				enjoySample(samples);
				break;
			case 6:
				enjoyAllSamples(samples);
				break;
			default:
				System.out.println("\nPlease enter a valid input, an integer 0-6.");
				break;	
			}
		}
	}

	public static void pickUpOrder(StackRA<Package> packages) {
		String name, sender, receiver;
		double weight;
		int amt;

		try {
			System.out.print("Please enter the following information about the item being "
					+ "picked up:\n> Name: ");
			name = input.readLine();
			System.out.print(name + "\n");
			
			System.out.print("\n> Weight: ");
			weight = Double.parseDouble(input.readLine());
			System.out.print(weight + "\n");

			System.out.print("\n> Number of items: ");
			amt = Integer.parseInt(input.readLine());
			System.out.print(amt + "\n");

			System.out.print("\n> Sender: ");
			sender = input.readLine();
			System.out.print(sender + "\n");

			System.out.print("\n> Receiver: ");
			receiver = input.readLine();
			System.out.print(receiver + "\n");
			
			packages.push(new Package(name, weight, sender, receiver, amt));
			
			System.out.println("A package of " + packages.peek().getName() + " weighed at "
					+ packages.peek().getWeight() / packages.peek().getAmtOfItems() + " lbs each are now in the bag.");
		}
		catch(StackException e) {
			System.out.println("The stack must have room for elements!\n");
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid entry. Please restart.\n\n");
		}
		catch(IOException e) {
			pickUpOrder(packages);
		}
	}

	public static void dropOffOrder(StackRA<Package> packages, StackSLS<Item> samples) {
		char answer;

		try {
			System.out.print("Would you allow me to keep a sample " + packages.peek().getRecipient() 
					+ "?\n> ");
			answer = Character.toLowerCase(input.readLine().charAt(0));
			System.out.println(answer + "\n");

			if(answer == 'y') {
				System.out.println("Thanks for letting me keep a " + packages.peek().getName() + "!");
				samples.push(new Item(packages.peek().getName(), (packages.peek().getWeight() / packages.peek().getAmtOfItems())));
			}
			else {
				System.out.println("Oh okay, Thanks anyways!\n");
			}
			packages.pop();
		}
		catch(InputMismatchException e1) {
			System.out.println("Please enter a valid input.\n");
		} 
		catch(StackException e2) {
			System.out.println("The package bag must have packages to perform this operation!\n");
		}
		catch(IOException e3) {
			System.out.println("Caught " + e3);
		}
	}

    public static void displayPackages(StackRA<Package> packages) {
        StackRA<Package> temp = new StackRA<Package>();
        double weight = 0;
        int counter = packages.top;
        
        for(int i = 0; i < counter + 1; i++) {
                temp.push(packages.pop());
                weight += temp.peek().getWeight();
        }
        
        for(int i = 0; i < counter + 1; i++) {
                packages.push(temp.pop());
        }
        
        System.out.println("Your bag has " + (packages.top + 1) + " package(s) in it, with a weight"
                        + " of " + weight + ".\n");
}

	public static void displaySamples(StackSLS<Item> samples) {
		try {
            Node<Item> current = samples.top;
            double weight = 0;
            int counter = 0;
            
            while(current != null) {
                    weight += current.getItem().getWeight();
                    current = current.getNext();
                    counter++;
            }
            
			System.out.println("Sample bag has " + counter + " items and weighs "
					+ weight + " lbs.\n");
		}
		catch(StackException e) {
			System.out.println("There are no samples to display!");
		}
	}

	public static void enjoySample(StackSLS<Item> samples) {
		try {
			System.out.println("This " + samples.pop().getName() + " is amazing! I love free stuff.\n");
		}
		catch(StackException e) {
			System.out.println("The sample bag must have samples to perform this operation!\n");
		}
	}

	public static void enjoyAllSamples(StackSLS<Item> samples) {
		try {	
			if(!samples.isEmpty()) {
				System.out.println("Sample bag has been emptied.\n");
				samples.popAll();
			}
			else {
				throw new StackException("");
			}
		}
		catch(StackException e) {
			System.out.println("Sample bag is already empty.\n");
		}
	}
}
