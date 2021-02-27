/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Completed and throughly tested
 * Last update: 10/05/20
 * Submitted:  10/05/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.03
 */
public class Package extends Item {
	
	private String sender;
	private String recipient;
	private int amtOfItems;
	
	public Package(String name, double weight, String sender, String recipient, int amtOfItems) {
		super(name, weight);
		this.sender = sender;
		this.recipient = recipient;
		this.amtOfItems = amtOfItems;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String newSender) {
		this.sender = newSender;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String newRecipient) {
		this.recipient = newRecipient;
	}

	public int getAmtOfItems() {
		return amtOfItems;
	}

	public void setAmtOfItems(int amtOfItems) {
		this.amtOfItems = amtOfItems;
	}
	
	@Override
	public double getWeight() {
		return super.getWeight() * amtOfItems;
	}
	
	
}
