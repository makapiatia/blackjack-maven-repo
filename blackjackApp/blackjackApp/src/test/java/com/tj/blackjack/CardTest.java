package com.tj.blackjack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CardTest {

	@Test
	public void testFaceCards()
	{
		Card card = new Card(CardSuit.CLUBS, CardRank.JACK);
		assertEquals(10, card.getCardRank().getRankValue());
		assertEquals("Jack", card.getCardRank().getRankDescription());
		assertEquals("Clubs", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.HEARTS, CardRank.QUEEN);
		assertEquals(10, card.getCardRank().getRankValue());
		assertEquals("Queen", card.getCardRank().getRankDescription());
		assertEquals("Hearts", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.DIAMONDS, CardRank.KING);
		assertEquals(10, card.getCardRank().getRankValue());
		assertEquals("King", card.getCardRank().getRankDescription());
		assertEquals("Diamonds", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.SPADES, CardRank.ACE);
		assertEquals(1, card.getCardRank().getRankValue());
		assertEquals("Ace", card.getCardRank().getRankDescription());
		assertEquals("Spades", card.getCardSuit().getSuitDescription());
	}
	
	@Test
	public void testNumberCards()
	{
		Card card = new Card(CardSuit.CLUBS, CardRank.SIX);
		assertEquals(6, card.getCardRank().getRankValue());
		assertEquals("6", card.getCardRank().getRankDescription());
		assertEquals("Clubs", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.HEARTS, CardRank.TWO);
		assertEquals(2, card.getCardRank().getRankValue());
		assertEquals("2", card.getCardRank().getRankDescription());
		assertEquals("Hearts", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.DIAMONDS, CardRank.NINE);
		assertEquals(9, card.getCardRank().getRankValue());
		assertEquals("9", card.getCardRank().getRankDescription());
		assertEquals("Diamonds", card.getCardSuit().getSuitDescription());
		
		card = new Card(CardSuit.SPADES, CardRank.SEVEN);
		assertEquals(7, card.getCardRank().getRankValue());
		assertEquals("7", card.getCardRank().getRankDescription());
		assertEquals("Spades", card.getCardSuit().getSuitDescription());
	}
}
