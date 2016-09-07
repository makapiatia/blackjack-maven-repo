package com.tj.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck of cards for a game of Blackjack.
 * @author Tia Jackson
 *
 */
public class Deck {
	
	private List<Card> cards = new ArrayList<Card>();
	private CardSuit[] cardSuits;
    private CardRank[] cardRanks;
	
    // Create a new deck of cards by populating it with 52 cards
	public Deck(){
		fillNewCardDeck();
	}
	
	public void fillNewCardDeck(){

		cardSuits=CardSuit.values();
		cardRanks=CardRank.values();
		
		for(int i=0; i < cardSuits.length; i++){
			for(int j=0; j < cardRanks.length; j++){
				Card newCard = new Card(cardSuits[i], cardRanks[j]);
				addCardToDeck(newCard);
			}
		}
	}
	
	// Add an individual card to the deck
	public void addCardToDeck(Card card){
		cards.add(card);
	}
	
	// Get the next card from the top of the deck
	public Card getNextCardFromDeck(){
		
		if(cards.size() != 0){
			return cards.remove(0);
		} else {
			return null;
		}
	}
	
	// Shuffle the cards in the deck.
	public void shuffleCards(){
		 Collections.shuffle(cards);
	}
	
	public List<Card> getAllCardsInDeck(){
		return cards;
	}

	// Empty all cards from the deck
	public void clearAllCards(){
		cards.clear();
	}
}
