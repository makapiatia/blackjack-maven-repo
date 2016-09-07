package com.tj.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

import com.tj.blackjack.Deck;

public class DeckTest {
	
	@Test
	public void testDeck()
	{
		Deck deck = new Deck();
		List<Card> deckCards = deck.getAllCardsInDeck();
		assertEquals(52, deckCards.size());
	}
	
	@Test
	public void checkShuffle()
	{
		Deck deck = new Deck();
		
		System.out.println("\nNew Deck without shuffling...");
		System.out.println("Showing first 5 cards of new deck WITHOUT shuffling:");
		for(int i=0; i < 5; i++){
			Card card = deck.getNextCardFromDeck();
			System.out.println(card.toString());
		}
		
		deck = new Deck();
		System.out.println("\nNew Deck with shuffle...");
		
		deck.shuffleCards();
		
		System.out.println("Showing first 5 cards of new deck WITH shuffling:");
		for(int i=0; i < 5; i++){
			Card card = deck.getNextCardFromDeck();
			System.out.println(card.toString());
		}
	}
	
	@Test
	public void countQueensInDeck()
	{
		int numberQueensInDeck = 0;
	
		Deck deck = new Deck();

		String rankDescription;
		
		for (int i = 0; i < 52; i++)
		{
			Card card = deck.getNextCardFromDeck();
			
			rankDescription = card.getCardRank().getRankDescription();
			
			if(rankDescription.equals("Queen")){
				numberQueensInDeck = numberQueensInDeck + 1;
			}
		}
		
		assertTrue(numberQueensInDeck == 4);
	}
}
