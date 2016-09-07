package com.tj.blackjack;

/**
 * Create a card from a suite and rank.
 * @author Tia Jackson
 *
 */
public class Card {
	
	// Card suit... either hearts, spades, diamonds or clubs
	private CardSuit cardSuit;
	
	// Card value, A can be either 1 or 11. 
	// J, Q, K all count as 10 which will be handled later.
	private CardRank cardRank;
	
	// Create card with suit and rank
	public Card(CardSuit cardSuit, CardRank cardRank){
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}
	
	// Get card rank
	public CardRank getCardRank(){
		return cardRank;
	}
	
	// Get card suit
	public CardSuit getCardSuit(){
		return cardSuit;
	}
	
	// Print description of rank and description of suit
	public String toString(){
		return cardRank.getRankDescription() + " of " + cardSuit.getSuitDescription();
	}

}
