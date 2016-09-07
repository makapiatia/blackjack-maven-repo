package com.tj.blackjack;

/**
 * 
 * @author Tia Jackson
 *
 */
public class Dealer extends BlackjackPerson{
	
	// Create a Dealer
	Dealer(boolean isDealer) {
		super(isDealer);
	}
	
	// Show the top card in the dealer hand
	public void showTopCardInHand(){
		hand.showTopCardInHand();
	}
}
