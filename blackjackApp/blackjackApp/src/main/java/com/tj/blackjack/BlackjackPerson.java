package com.tj.blackjack;

/**
 * 
 * @author Tia Jackson
 *
 */
public abstract class BlackjackPerson {
	
	protected Hand hand;
	
	BlackjackPerson(boolean isDealer){
		hand = new Hand(isDealer);
	}
	
	// Get hand for this person
	public Hand getHand(){
		return hand;
	}
	
	// Add card to the hand
	public void addCardToHand(Card card){		
		hand.addCard(card);
	}
	
	// Clear hand of all cards
	public void clearHand(){
		hand.clearHand();
	}
	
	// Show all cards in this hand
	public void showHand(){
		hand.showHand();
	}
	
	// Get total of all cards in this hand
	public int getHandTotal(){
		return hand.getHandTotal();
	}

}
