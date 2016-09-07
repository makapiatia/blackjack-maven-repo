package com.tj.blackjack;

/**
 * Possible blackjack results represented by an enum.
 * @author Tia Jackson
 *
 */
// Create a CardSuit with a description
public enum BlackjackResult {	
	BOTH_BUST(),
	DEALER_BUST(),
	PLAYER_BUST(),
	BOTH_TIE(),
	DEALER_BLACKJACK(),
	PLAYER_BLACKJACK(),
	DEALER_HIGHER_HAND(),
	PLAYER_HIGHER_HAND();
}
