package com.tj.blackjack;

import java.util.ArrayList;

import java.util.List;
/**
 * 
 * @author Tia Jackson
 *
 */
public class Hand {
	
	private List<Card> cards = new ArrayList<Card>();
	
	boolean isDealer = false;
	String handType;
	boolean hasAce = false;
	private int highHandTotal = 0;
	private int lowHandTotal = 0;	
	private int handTotal = 0;
	
	// Create a new hand
	public Hand(boolean isDealerHand){
		isDealer = isDealerHand;
		
		if(isDealer){
			handType = Constants.HAND_TYPE_DEALER;
		} else {
			handType = Constants.HAND_TYPE_PLAYER;
		}
	}
	
	// Add a card to the hand
	public void addCard(Card card){
		
		cards.add(card);
		
		int newCardValue = card.getCardRank().getRankValue();
		
		if(newCardValue == Constants.ACE_RANK_VALUE){
			hasAce = true;
		}
		
		lowHandTotal = lowHandTotal + newCardValue;
		highHandTotal = lowHandTotal + Constants.ADD_TEN_FOR_HIGH_ACE;
		
		if(hasAce && (highHandTotal < Constants.BUST_VALUE)){
			handTotal = highHandTotal;
		} else {
			handTotal = lowHandTotal;
		}
	}
	
	// Show all the cards in the hand
	public void showHand(){
			
		System.out.println("\nCurrent cards in " + handType + " hand are: ");
	
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}
	
	// Display the top card in a hand
	public void showTopCardInHand(){
		
		Card firstCard = cards.get(0);
		
		System.out.println("\n" + handType + " Top Card is: " + firstCard.toString() + "\n");
	}
	
	// Remove all cards from the hand
	public void clearHand(){
		
		cards.clear();
		
		lowHandTotal = 0;
		highHandTotal = 0;
		handTotal = 0;
		hasAce = false;
	}
	
	// Get the card total in the hand
	public int getHandTotal(){		
		return handTotal;		
	}
	
	// Show the card total in the hand
	public void showHandleTotal(){
		
		System.out.println(handType + " hand total is: " + handTotal);
	}
	
	// Set if a dealer hand
	public boolean isDealer(){
		return isDealer;
	}
}
