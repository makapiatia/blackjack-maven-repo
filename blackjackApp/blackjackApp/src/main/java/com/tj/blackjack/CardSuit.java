package com.tj.blackjack;
/**
 * Possible card suits represented by an enum.
 * @author Tia Jackson
 *
 */

// Create a CardSuit with a description
public enum CardSuit {	
	CLUBS("Clubs"),
	DIAMONDS("Diamonds"),
	SPADES("Spades"),
	HEARTS("Hearts");
	
	private String suiteDescription;
	
	// Create a CardSuit with a description
	private CardSuit(String suiteDescription){
		this.suiteDescription = suiteDescription;
	}
	
	// Get the description of the suit
	public String getSuitDescription(){
		return this.suiteDescription;
	}
}
