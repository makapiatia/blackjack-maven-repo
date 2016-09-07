package com.tj.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandTest {
	
	@Test
	public void testHandTotals()
	{
		boolean isDealer = true;
		Hand hand = new Hand(isDealer);
		
		hand.addCard(new Card(CardSuit.CLUBS, CardRank.JACK));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.TWO));
		assertEquals(12, hand.getHandTotal());
		
		// Clear the hand
		hand.clearHand();
		
		hand.addCard(new Card(CardSuit.DIAMONDS, CardRank.ACE));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.QUEEN));
		assertEquals(21, hand.getHandTotal());
		
		// Clear the hand
		hand.clearHand();
				
		hand.addCard(new Card(CardSuit.SPADES, CardRank.FOUR));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.TWO));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.KING));
		hand.addCard(new Card(CardSuit.CLUBS, CardRank.SEVEN));
		assertEquals(23, hand.getHandTotal());		
	}
	
	@Test
	public void testClearHand()
	{
		boolean isDealer = true;
		Hand hand = new Hand(isDealer);
		
		hand.addCard(new Card(CardSuit.CLUBS, CardRank.JACK));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.TWO));
		hand.addCard(new Card(CardSuit.HEARTS, CardRank.FIVE));
		assertEquals(17, hand.getHandTotal());
		
		// Clear the hand
		hand.clearHand();
		assertEquals(0, hand.getHandTotal());
	}
}
