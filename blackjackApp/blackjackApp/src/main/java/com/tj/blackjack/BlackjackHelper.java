package com.tj.blackjack;

/**
 * 
 * @author Tia Jackson
 *
 */
public class BlackjackHelper {
	
	// Add a card to the hand
	public static void hitHand(Hand blackjackPersonHand, Deck cardDeck, boolean showCard){
		
		Card card = cardDeck.getNextCardFromDeck();
		
		if(blackjackPersonHand.isDealer){
			if(showCard){
				System.out.println("New Dealer card is: " +card.toString());
			}
		} else {
			System.out.println("New Player card is: " +card.toString());
		}
		
		blackjackPersonHand.addCard(card);
	}
	
	// Check dealer and player hands for blackjack, bust, tie, and closet to 21
	public static BlackjackResult compareFinalHands(Hand dHand, Hand pHand){
		
		int dealerHandTotal = dHand.getHandTotal();
		int playerHandTotal = pHand.getHandTotal();
		
		// Dealer_hand and player_hand are both bust - dealer wins
		if(isBothHandsBust(dHand, pHand)){
			System.out.println("Both Dealer hand and Player Hands are BUST! : Dealer WINS");	
			return BlackjackResult.BOTH_BUST;
			
		} else if(BlackjackHelper.isBust(dHand)){			
			System.out.println("Dealer is BUST! : Player WINS");
			return BlackjackResult.DEALER_BUST;
			
		} else if(BlackjackHelper.isBust(pHand)){
			System.out.println("Player is BUST! : Dealer WINS");
			return BlackjackResult.PLAYER_BUST;
					
		} else if(isTie(dHand, pHand)){
			// Check for both hands tied - tie
			System.out.println("Dealer and Player have TIE hands. : TIE");
			return BlackjackResult.BOTH_TIE;
					
		} else if(BlackjackHelper.isBlackjack(dHand)){
			System.out.println("Dealer has BLACKJACK! : Dealer WINS");
			return BlackjackResult.DEALER_BLACKJACK;
			
		} else if(BlackjackHelper.isBlackjack(pHand)){
			System.out.println("Player has BLACKJACK! : Player WINS");
			return BlackjackResult.PLAYER_BLACKJACK;
					
		}  else if(dealerHandTotal > playerHandTotal){
			// if Dealer_hand > player_hand	- dealer wins
			System.out.println("Dealer hand is closet to 21. : Dealer WINS");
			return BlackjackResult.DEALER_HIGHER_HAND;
		} else {
			// - Player wins
			System.out.println("Player hand is closet to 21. : Player WINS");
			return BlackjackResult.PLAYER_HIGHER_HAND;
		}
	}
	
	// Check to see if hand is 21 (blackjack)
	public static boolean isBlackjack(Hand blackjackPersonHand){
		
		boolean isBlackjackFlag = false;
		
		int handTotal = blackjackPersonHand.getHandTotal();
		
		if(handTotal == Constants.BLACKJACK_NUMBER){
			isBlackjackFlag = true;
		}
		
		return isBlackjackFlag;		
	}
	
	// Check to see if hand is over 21 (bust)
	public static boolean isBust(Hand blackjackPersonHand){
		
		boolean isBustFlag = false;
		
		int handTotal = blackjackPersonHand.getHandTotal();
		
		if(handTotal > Constants.BLACKJACK_NUMBER){
			isBustFlag = true;
		}
		
		return isBustFlag;	
	}
	
	// Check to see if dealer and player hands are a tie
	public static boolean isTie(Hand dHand, Hand pHand){
		
		boolean isTieFlag = false;
		
		if(dHand.getHandTotal() == pHand.getHandTotal()){
			isTieFlag = true;
		}
		
		return isTieFlag;
	}
	
	// Check to see if dealer and player hands are both blackjack (21) hands 
	public static boolean isBlackjackTie(Hand dHand, Hand pHand){
		
		boolean isBlackjackTieFlag = false;
		
		if(dHand.getHandTotal() == pHand.getHandTotal()){
			if(dHand.getHandTotal() == Constants.BLACKJACK_NUMBER){
				isBlackjackTieFlag = true;
			}
		}
		
		return isBlackjackTieFlag;
	}
	
	// Check to see if dealer and player hands are both bust ( over 21) hands 
	public static boolean isBothHandsBust(Hand dHand, Hand pHand){
		
		boolean isBothHandsBustFlag = false;
		
		int dealerHandTotal = dHand.getHandTotal();
		int playerHandTotal = pHand.getHandTotal();
		
		if((dealerHandTotal > Constants.BLACKJACK_NUMBER) && (playerHandTotal > Constants.BLACKJACK_NUMBER)){
			isBothHandsBustFlag = true;
		}
		
		return isBothHandsBustFlag;
	}

}
