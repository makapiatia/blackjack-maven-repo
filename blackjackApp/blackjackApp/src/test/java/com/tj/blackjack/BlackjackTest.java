package com.tj.blackjack;

import static org.junit.Assert.assertTrue;

import com.tj.blackjack.Deck;

import org.junit.Test;

public class BlackjackTest {
		
	@Test
	public void testCompareFinalDealerAndPlayerHands(){
	
		System.out.println("\n");
		
		// Create and shuffle a new deck of cards
		Deck deckOfCards = new Deck();
		deckOfCards.shuffleCards();
		
		// Create a Dealer and get the dealer's hand
		boolean isDealerHand = true;
		Dealer dealer = new Dealer(isDealerHand);
		Hand dealerHand = dealer.getHand();
		
		// Create a Player and get the player's hand
		isDealerHand = false;
		Player player = new Player(isDealerHand);
		Hand playerHand = player.getHand();
		
		// Setup cards for Higher Player Hand
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.JACK));
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.TWO));
		
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.JACK));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.FIVE));
		
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		BlackjackResult result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
		
		assertTrue(BlackjackResult.PLAYER_HIGHER_HAND == result);
		
		// Setup cards for Higher Dealer Hand
		dealerHand.clearHand();
		playerHand.clearHand();
		
		dealerHand.addCard(new Card(CardSuit.SPADES, CardRank.EIGHT));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.TWO));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.FIVE));
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.FIVE));
		
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.QUEEN));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.SIX));
		
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
		
		assertTrue(BlackjackResult.DEALER_HIGHER_HAND == result);
		
		// Setup cards for TIED Dealer and Player Hands
		dealerHand.clearHand();
		playerHand.clearHand();
						
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.FOUR));
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.QUEEN));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.SIX));
						
		playerHand.addCard(new Card(CardSuit.CLUBS, CardRank.FOUR));
		playerHand.addCard(new Card(CardSuit.CLUBS, CardRank.SIX));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.QUEEN));
						
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
						
		assertTrue(BlackjackResult.BOTH_TIE == result);
		
		// Setup cards for Player Blackjack Hand
		dealerHand.clearHand();
		playerHand.clearHand();
				
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.FOUR));
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.TWO));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.TEN));
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.THREE));
				
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.ACE));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.KING));
				
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
		
		assertTrue(BlackjackResult.PLAYER_BLACKJACK == result);
		
		// Setup cards for Dealer Blackjack Hand
		dealerHand.clearHand();
		playerHand.clearHand();
						
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.ACE));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.QUEEN));
						
		playerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.TEN));
		playerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.NINE));
					
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
				
		assertTrue(BlackjackResult.DEALER_BLACKJACK == result);
		
		// Setup cards for Dealer Bust Hand
		dealerHand.clearHand();
		playerHand.clearHand();
						
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.EIGHT));
		dealerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.SEVEN));
		dealerHand.addCard(new Card(CardSuit.CLUBS, CardRank.EIGHT));
						
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.THREE));
		playerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.KING));
		playerHand.addCard(new Card(CardSuit.DIAMONDS, CardRank.SIX));
					
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
				
		assertTrue(BlackjackResult.DEALER_BUST == result);
		
		// Setup cards for Player Bust Hand
		dealerHand.clearHand();
		playerHand.clearHand();
								
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.SEVEN));
		dealerHand.addCard(new Card(CardSuit.SPADES, CardRank.NINE));
								
		playerHand.addCard(new Card(CardSuit.CLUBS, CardRank.NINE));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.FOUR));
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.TEN));
				
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
						
		assertTrue(BlackjackResult.PLAYER_BUST == result);
		
		// Setup cards for Player Bust Hand
		dealerHand.clearHand();
		playerHand.clearHand();
										
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.KING));
		dealerHand.addCard(new Card(CardSuit.HEARTS, CardRank.FIVE));
		dealerHand.addCard(new Card(CardSuit.SPADES, CardRank.SEVEN));
										
		playerHand.addCard(new Card(CardSuit.CLUBS, CardRank.SEVEN));
		playerHand.addCard(new Card(CardSuit.HEARTS, CardRank.KING));
		playerHand.addCard(new Card(CardSuit.SPADES, CardRank.JACK));
				
		dealerHand.showHandleTotal();
		playerHand.showHandleTotal();
		result = BlackjackHelper.compareFinalHands(dealerHand, playerHand);
								
		assertTrue(BlackjackResult.BOTH_BUST == result);
	}

}
